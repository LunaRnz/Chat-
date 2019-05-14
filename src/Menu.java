import java.io.IOException;
import java.util.Scanner;

public class Menu {

    private Client client1 = new Client();
    private Server server = new Server();

    public Menu(){
    }

    public void panel(){
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
                        System.out.println("Do you want to create a server?(Write Yes or No)");
                        String answer = sc.nextLine();
                        if (answer.equals("Yes")) {
                            server.mainServer();
                        } else if (answer.equals("No")) {
                            client1.mainClient();
                        }
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }
        }while (option != 3);
    }

}
