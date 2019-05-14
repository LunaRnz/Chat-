import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    private static final int portNumber = 4444;
    private int serverPort;
    private List<ClientThread> clients;

    public void mainServer(){

        Server server = new Server(portNumber);
        server.startServer();
    }

    public Server(){}

    public Server(int portNumber){
        this.serverPort = portNumber;
    }

    public List<ClientThread> getClients(){
        return clients;
    }

    private void startServer(){
        clients =  new ArrayList<ClientThread>();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(serverPort);
            acceptClients(serverSocket);
        } catch (IOException e){
            System.err.println("Could nor listen on port: "+serverPort);
            System.exit(1);
        }
    }

    public void acceptClients(ServerSocket serverSocket){

        System.out.println("server starts port = "+serverSocket.getLocalSocketAddress());

        while (true){
            try {
                Socket socket = serverSocket.accept();
                System.out.println("accepts: " + socket.getRemoteSocketAddress());
                ClientThread clientThread = new ClientThread(this, socket);
                Thread thread = new Thread(clientThread);
                thread.start();
                clients.add(clientThread);
            } catch (IOException e) {
                System.out.println("Accept failed on: "+portNumber);
            }
        }
    }

}
