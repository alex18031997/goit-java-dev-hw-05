package config;

import props.PropertyReader;

import java.io.IOException;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Database {
    private static Database INSTANCE = null;

    static {
        try {
            INSTANCE = new Database();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Connection connection;
    private Database() throws SQLException, IOException {
        String url = PropertyReader.getDataFromProp("", true);
        String user = PropertyReader.getDataFromProp("postgres.db.user", false);
        String password = PropertyReader.getDataFromProp("postgres.db.password", false);

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(String.format("can not create connection reason: %s", e));
        }

    }

    public static Connection getConnection() {
        return connection;
    }

    public static void executeUpdate(String query) {
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(String.format("can not execute reason: %s", e));
            throw new RuntimeException("Can not run query");
        }
    }

    public static void insertValueToDB(String query) throws SQLException {
        String regForTabName =  "INSERT INTO\\s+([^\\s(]+)";
        Matcher matcherForTableName = findMatcher(regForTabName, query);

        while (matcherForTableName.find()) {
            preparedStatement(matcherForTableName.group(1));
        }
    }

    private static Matcher findMatcher(String reg, String query) {
        Pattern pattern = Pattern.compile(reg, Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(query);
        return matcher;
    }

    private static void preparedStatement(String tableName) throws SQLException {
        switch (tableName) {
            case "worker":
                String sqlWorker = "INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY) VALUES\n" +
                        "(?, ?, ?, ?)";
                PreparedStatement workerStatement = connection.prepareStatement(sqlWorker);
                workerStatement.setString(1, "Jane Smith");
                workerStatement.setString(2, "1985-09-20");
                workerStatement.setString(3, "Junior");
                workerStatement.setString(4, "800");
                System.out.println("queryStatement--> " + workerStatement);
                workerStatement.executeQuery();
                break;
            case "client":
                String sqlClient = "INSERT INTO client (NAME) VALUES (?)";
                PreparedStatement clientStatement = connection.prepareStatement(sqlClient);
                clientStatement.setString(1, "privatBank");
                System.out.println("clientStatement--> " + clientStatement);
                clientStatement.executeQuery();
            case "project":
                String sqlProject = "INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE)" +
                        "VALUES\n" +
                        "    (?, ?, ?)";
                PreparedStatement projectStatement = connection.prepareStatement(sqlProject);
                projectStatement.setString(1, "1");
                projectStatement.setString(1, "2023-06-30");
                projectStatement.setString(1, "2023-06-30");
                projectStatement.executeQuery();
                break;
        }
    }

    public static ResultSet executeQuery(String query) {
        try (Statement statement = connection.createStatement()) {
            return statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println(String.format("can not execute reason: %s", e));
            throw new RuntimeException("Can not run query");
        }
    }
}
