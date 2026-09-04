package RentalService.dao;

import RentalService.db.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PriceListDAO {

    Connection con = DatabaseConnection.getConnection();

    public PriceListDAO() throws SQLException {
    }

    public int addPrice5000() throws SQLException {
        Statement stmt = con.createStatement();
        return stmt.executeUpdate("UPDATE PriceList SET HourlyPrice = HourlyPrice + 5000");
    }
}
