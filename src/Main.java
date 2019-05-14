import java.io.IOException;

public class Main {
    public static void main (String[] args) throws IOException {
        DBConnections dbConnections = new DBConnections();
        dbConnections.createDB();
        dbConnections.createTable();
        Menu menu = new Menu();
        menu.panel();
    }
}
