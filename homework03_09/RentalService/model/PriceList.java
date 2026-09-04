package RentalService.model;

public class PriceList {
    private int priceId;
    private String model;
    private double dailyPrice;
    private double hourlyPrice;
    private boolean insurance;

    public PriceList() {
    }

    public PriceList(int priceId, String model, double dailyPrice, double hourlyPrice, boolean insurance) {
        this.priceId = priceId;
        this.model = model;
        this.dailyPrice = dailyPrice;
        this.hourlyPrice = hourlyPrice;
        this.insurance = insurance;
    }

    public int getPriceId() {
        return priceId;
    }
    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public double getDailyPrice() {
        return dailyPrice;
    }
    public void setDailyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }
    public double getHourlyPrice() {
        return hourlyPrice;
    }
    public void setHourlyPrice(double hourlyPrice) {
        this.hourlyPrice = hourlyPrice;
    }
    public boolean isInsurance() {
        return insurance;
    }
    public void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }

    @Override
    public String toString() {
        return "PriceList{" +
                "priceId=" + priceId +
                ", model='" + model + '\'' +
                ", dailyPrice=" + dailyPrice +
                ", hourlyPrice=" + hourlyPrice +
                ", insurance=" + insurance +
                '}';
    }
}
