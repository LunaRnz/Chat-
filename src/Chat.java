import java.io.IOException;
import java.util.Scanner;

public class Chat {

    private String chatName;
    DBConnections dbConnections = new DBConnections();

    public Chat(){}

    public Chat(String chatName) {
        this.chatName = chatName;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public void viewChat(){
        Scanner sc = new Scanner(System.in);
        System.out.println("What chat dou you want to see?: ");
        String chatName = sc.nextLine();
        dbConnections.selectChatAndMessages();
    }
}
