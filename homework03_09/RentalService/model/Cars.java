package RentalService.model;

public class Cars {
    private int carId;
    private String brand;
    private String model;
    private int productionYear;
    private String plateNumber;
    private boolean insurance;
    private int officeId;
    private int priceId;

    public Cars() {
    }

    public Cars(String brand, String model, int productionYear, String plateNumber,
                boolean insurance, int officeId, int priceId) {
        this.brand = brand;
        this.model = model;
        this.productionYear = productionYear;
        this.plateNumber = plateNumber;
        this.insurance = insurance;
        this.officeId = officeId;
        this.priceId = priceId;
    }

    public int getCarId() {
        return carId;
    }
    public void setCarId(int carId) {
        this.carId = carId;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getProductionYear() {
        return productionYear;
    }
    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }
    public String getPlateNumber() {
        return plateNumber;
    }
    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
    public boolean isInsurance() {
        return insurance;
    }
    public void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }
    public int getOfficeId() {
        return officeId;
    }
    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }
    public int getPriceId() {
        return priceId;
    }
    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", productionYear=" + productionYear +
                ", plateNumber='" + plateNumber + '\'' +
                ", insurance=" + insurance +
                ", officeId=" + officeId +
                ", priceId=" + priceId +
                '}';
    }
}
