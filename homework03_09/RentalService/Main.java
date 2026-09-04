package RentalService;

import RentalService.dao.CarsDAO;
import RentalService.dao.OfficeDAO;
import RentalService.dao.PriceListDAO;
import RentalService.model.Cars;
import RentalService.model.Office;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {

        CarsDAO carsDAO = new CarsDAO();
        Cars car = new Cars("Kia", "Sportage", 2023, "05EE005", true, 1, 1);
        int added = carsDAO.addCar(car);
        System.out.println("cars added: " + added);

        OfficeDAO officeDAO = new OfficeDAO();
        ArrayList<Office> offices = officeDAO.getYerevanOffices();
        for (Office o : offices) {
            System.out.println(o);
        }

        PriceListDAO priceListDAO = new PriceListDAO();
        int updated = priceListDAO.addPrice5000();
        System.out.println("prices updated: " + updated);

        int deleted = carsDAO.deleteOldCars();
        System.out.println("cars deleted: " + deleted);
    }
}
