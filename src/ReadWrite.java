import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWrite {

    File file;
    FileWriter writer;
    static String nameChat;

    public static void setNameChat(String nameChat) {
        ReadWrite.nameChat = nameChat;
    }

    public static String getNameChat() {
        return nameChat;
    }

    public void createChatFile(String nameChat) throws IOException {
        file = new File(nameChat+".txt");

        if (file.createNewFile()){
            System.out.println("Chat created");
        } else {
            System.out.println("Chat name already in use");
        }

    }

    public void writeInChatFile(String nameChat,String user,String message) throws IOException {

        writer = new FileWriter(nameChat+".txt", true);
        BufferedWriter bf = new BufferedWriter(writer);
        bf.write(user+":"+message+"\n");
        //writer.write(user+":"+message+"\n");
        //writer.write("\n");
        //writer.close();
        bf.close();
    }


}
