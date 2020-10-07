package net.creepans.tangotaxi.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL  {

    private static String username, password, database, host, port;
    private static boolean autoReconnect;
    private static Connection con;

    public MySQL() {

    }

    public static void connect() {
        if (check()) return;            // If already connected
        try {
            /*host = "localhost";
            username = "root";
            password = "";
            database = "database";
            port = "3306";*/
            con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=" + autoReconnect, username, password); // connects to database
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        if (!check()) return;
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void createTables() {
        if (!check()) connect();
        try {
            // Creates Tables for certain usages TODO: Add Time Column
            con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS tangotaxi_protokoll (ID FLOAT NOT NULL AUTO_INCREMENT, User FLOAT, Start VARCHAR(63), Ziel VARCHAR(63), Kosten INTEGER(4), Status VARCHAR(63), PRIMARY KEY (ID))");
            con.createStatement().executeUpdate("ID FLOAT NOT NULL AUTO_INCREMENT, Name VARCHAR(63), Vorname VARCHAR(63), Guthaben FLOAT, PRIMARY KEY (ID)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(String query) {
        if (!check()) connect();
        try {
            con.createStatement().executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getResult(String query) {
        if (!check()) connect();
        try {
            return  con.createStatement().executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean check() {
        return con != null;
    }


}
