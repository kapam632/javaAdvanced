package hw08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    private static final String URL = "jdbc:postgresql://localhost:5432/mydb?user=postgres&password=postgres";


    public static void main(String[] args) {
        Main main = new Main();
        String url = URL;
        if (args.length > 0){
            url = args[0];
        }
        main.deployDump(url);
    }

    private void deployDump(String url){
        try (Connection conn = DriverManager.getConnection(url)) {
            new DumpExecutor().deployDump(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
