package RentalService.dao;

import RentalService.db.DatabaseConnection;
import RentalService.model.Office;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OfficeDAO {

    Connection con = DatabaseConnection.getConnection();

    public OfficeDAO() throws SQLException {
    }

    public ArrayList<Office> getYerevanOffices() throws SQLException {
        ArrayList<Office> offices = new ArrayList<>();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
            "SELECT DISTINCT o.OfficeID, o.OfficeName, o.Address, o.Phone " +
            "FROM Offices o " +
            "JOIN Cars c ON o.OfficeID = c.OfficeID " +
            "JOIN Rental r ON c.CarID = r.CarID " +
            "WHERE o.Address LIKE 'Yerevan%' " +
            "AND r.StartDate >= DATEADD(month, -1, GETDATE())"
        );
        while (rs.next()) {
            Office o = new Office();
            o.setOfficeId(rs.getInt("OfficeID"));
            o.setOfficeName(rs.getString("OfficeName"));
            o.setAddress(rs.getString("Address"));
            o.setPhone(rs.getString("Phone"));
            offices.add(o);
        }
        return offices;
    }
}
