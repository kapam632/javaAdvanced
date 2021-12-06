package hw08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DumpExecutor {
    private static final String SQL_FILE = "dump.sql";

    public void deployDump(Connection conn){
        try (Statement statement = conn.createStatement()) {
            statement.executeUpdate(getSql());
            select(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String getSql() {
        StringBuilder stringBuilder = new StringBuilder();
        InputStream is = getClass().getClassLoader().getResourceAsStream(SQL_FILE);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            br.lines().forEach(stringBuilder::append);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    private void select(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM dbo.\"Heroes\"");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String ultimate = resultSet.getString("ultimate");
            System.out.println(String.format("record %d\t%s\t%s", id, name, ultimate));
        }
        resultSet.close();
    }
}
