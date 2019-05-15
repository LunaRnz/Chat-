import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    private static final String host = "localhost";
    private static final int portNumber = 4444;

    private User user = new User();
    Chat chat = new Chat();

    private String userName;
    private String serverHost;
    private String chatName;
    private int serverPort;
    private Scanner userInputScanner;
    //private DBConnections dbConnections = new DBConnections();

    public void mainClient(){
        String readName = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input username: ");
        while (readName == null || readName.trim().equals("")){
            readName = scan.nextLine();
            //dbConnections.insertUser(readName);
            if (readName.trim().equals("")){
                System.out.println("Invalid user name ");
            }
        }
        System.out.println(userName + " please name the chat like this, chat+your name");
        chatName = scan.nextLine();
        //dbConnections.insertChat(chatName);
        Client client = new Client(readName, host, portNumber, chatName);
        client.startClient(scan);
    }

    public Client(){}

    private Client(String userName, String host, int portNumber, String chatName){
        this.userName  = userName;
        this.serverHost = host;
        this.serverPort = portNumber;
        this.chatName = chatName;
    }

    private void startClient(Scanner scan){
        try{
            Socket socket = new Socket(serverHost, serverPort);
            Thread.sleep(1000);

            ServerThread serverThread = new ServerThread(socket, userName, chatName);
            Thread serverAccessThread = new Thread(serverThread);
            serverAccessThread.start();

            while (serverAccessThread.isAlive()){
                if (scan.hasNextLine()){
                    serverThread.addNextMessage(scan.nextLine());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
