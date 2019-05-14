import java.sql.*;
import java.util.ArrayList;

public class DBConnections {

    static String url;
    static String driver = "com.mysql.jdbc.Driver";
    static String username = "root";
    static String password = "";
    static Connection conn = null;
    static Statement stmt = null;

    public void createDB(){
        url = "jdbc:mysql://localhost:3306/";
        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database");
            conn = DriverManager.getConnection(url, username, password);

            System.out.println("Creating database");
            stmt = conn.createStatement();

            String sql = "CREATE DATABASE IF NOT EXISTS M03Chat";
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (stmt!=null){
                    stmt.close();
                }
            } catch (SQLException e) {
            }
            try {
                if (conn!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void createTable(){
        url = "jdbc:mysql://localhost:3306/M03Chat";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to a selected database");
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected database succesfully");

            System.out.println("Creating table in given databse");
            stmt = conn.createStatement();

            String sqlUser = "CREATE TABLE IF NOT EXISTS User" +
                    "(name VARCHAR(255) not NULL," +
                    " PRIMARY KEY (name))";
            String sqlChat = "CREATE TABLE IF NOT EXISTS Chat" +
                    "(name VARCHAR(255)," +
                    " PRIMARY KEY (name))";
            String sqlMessage = "CREATE TABLE IF NOT EXISTS Message" +
                    "( message MEDIUMTEXT NOT NULL," +
                    "name VARCHAR(255) not NULL," +
                    " PRIMARY KEY (message(767)),"+
                    "FOREIGN KEY (name) REFERENCES Chat (name))";
            stmt.executeUpdate(sqlUser);
            System.out.println("User Table Created");
            stmt.executeUpdate(sqlChat);
            System.out.println("Chat Table Created");
            stmt.executeUpdate(sqlMessage);
            System.out.println("Message Table Created");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt!=null){
                    conn.close();
                }
            } catch (SQLException e) {
            }
            try {
                if (conn!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void insertUser(String userName){
        url = "jdbc:mysql://localhost:3306/M03Chat";

        try{
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(url, username, password);

            stmt =conn.createStatement();

            String sql = "INSERT INTO User " +
                    "VALUES( '"+userName+"')";
            stmt.executeUpdate(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try{
                if (conn!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void insertChat(String chatName){
        url = "jdbc:mysql://localhost:3306/M03Chat";

        try{
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(url, username, password);

            stmt =conn.createStatement();

            String sql = "INSERT INTO Chat " +
                    "VALUES( '"+chatName+"')";
            stmt.executeUpdate(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try{
                if (conn!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void insertMessage(String messages, String chatName){
        url = "jdbc:mysql://localhost:3306/M03Chat";

        try{
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(url, username, password);

            stmt =conn.createStatement();

            String sql = "INSERT INTO Message " +
                    "VALUES( '"+messages+"','"+chatName+"')";
            stmt.executeUpdate(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try{
                if (conn!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
