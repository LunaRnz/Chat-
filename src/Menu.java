import java.io.IOException;
import java.util.Scanner;

public class Menu {

    Chat chat = new Chat();
    User user1 = new User();
    User user2 = new User();

    public Menu(){
    }

    public void panel() throws IOException {
        int option;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Choose an option\n" +
                    "1.Chat\n" +
                    "2.View chats\n" +
                    "3.Close");
            option = Integer.parseInt(sc.nextLine());

                switch (option) {

                    case 1:
                        System.out.println("Write the chat name: ");
                        String chatName = sc.nextLine();
                        chat.createChat(chatName);
                        chat.userName(user1);
                        chat.userName(user2);
                        do {
                            chat.writeInChat(chatName, user1.getName());
                            chat.writeInChat(chatName, user2.getName());
                        } while (chat.terminateChat() == false);
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }
        }while (option == 3);
    }

}
