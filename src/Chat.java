import java.io.IOException;
import java.util.Scanner;

public class Chat {

    private String chatName;

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
}
