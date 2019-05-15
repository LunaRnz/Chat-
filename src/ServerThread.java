import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class ServerThread implements Runnable{

    private Socket socket;
    private String userName;
    private String chatName;
    private boolean isAlived;
    private final LinkedList<String> messagesToSend;
    private boolean hasMessages = false;
    DBConnections dbConnections = new DBConnections();
    private ArrayList<String> messageList= new ArrayList<>();

    public ServerThread(Socket socket, String userName, String chatName){
        this.socket = socket;
        this.userName = userName;
        this.chatName = chatName;
        messagesToSend = new LinkedList<String>();
    }

    public void addNextMessage(String message) {
        synchronized (messagesToSend){
            hasMessages = true;
            messagesToSend.push(message);
        }
    }

    @Override
    public void run() {
        System.out.println("Welcome: "+userName);
        System.out.println("Chat name = "+chatName);
        System.out.println("Local Port: "+ socket.getLocalPort());
        System.out.println("Server = " + socket.getRemoteSocketAddress() + ":" + socket.getPort());
        dbConnections.insertUser(userName);
        dbConnections.insertChat(chatName);

        try {
            PrintWriter serverOut = new PrintWriter(socket.getOutputStream(), false);
            InputStream serverInStream = socket.getInputStream();
            Scanner serverIn = new Scanner(serverInStream);

            while (!socket.isClosed()){
                if (serverInStream.available() > 0){
                    if (serverIn.hasNextLine()){
                        System.out.println(serverIn.nextLine());
                    }
                }
                if (hasMessages){
                    String nextSend = "";
                    synchronized (messagesToSend){
                        nextSend = messagesToSend.pop();
                        hasMessages = !messagesToSend.isEmpty();
                        dbConnections.insertMessage(nextSend, chatName);
                    }
                    serverOut.println(userName + " > " +nextSend);
                    serverOut.flush();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
