import java.io.IOException;
import java.util.Scanner;

public class Chat {

    ReadWrite rw = new ReadWrite();
    Scanner sc = new Scanner(System.in);


    private String message;


    public Chat(){}

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void createChat(String chatName) throws IOException {
        rw.createChatFile(chatName);
    }

    public void writeInChat(String chatName, String user) throws IOException {
        System.out.println(user+":");
        message = sc.nextLine();
        rw.writeInChatFile(chatName, user, message);
    }


    public void userName(User user){
        System.out.println("Write your name: ");
        String name = sc.nextLine();
        user.setName(name);
    }

    public boolean terminateChat(){
        if (message.equals("qw")){
            return true;
        } else {
            return false;
        }
    }

}
