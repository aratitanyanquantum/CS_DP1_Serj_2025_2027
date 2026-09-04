package RentalService.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=RentalService;encrypt=true;trustServerCertificate=true;loginTimeout=10";
            connection = DriverManager.getConnection(url, "sa", "Qwerty$1234");
            System.out.println("connected");
        }
        return connection;
    }
}
