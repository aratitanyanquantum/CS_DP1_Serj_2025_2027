package RentalService.dao;

import RentalService.db.DatabaseConnection;
import RentalService.model.Cars;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CarsDAO {

    Connection con = DatabaseConnection.getConnection();

    public CarsDAO() throws SQLException {
    }

    public int addCar(Cars c) throws SQLException {
        String sql = "INSERT INTO Cars (Brand, Model, ProductionYear, PlateNumber, Insurance, OfficeID, PriceID) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, c.getBrand());
        ps.setString(2, c.getModel());
        ps.setInt(3, c.getProductionYear());
        ps.setString(4, c.getPlateNumber());
        ps.setBoolean(5, c.isInsurance());
        ps.setInt(6, c.getOfficeId());
        ps.setInt(7, c.getPriceId());
        return ps.executeUpdate();
    }

    public int deleteOldCars() throws SQLException {
        Statement stmt = con.createStatement();
        return stmt.executeUpdate("DELETE FROM Cars WHERE ProductionYear < 2010");
    }
}
