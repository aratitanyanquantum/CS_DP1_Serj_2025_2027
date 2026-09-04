package RentalService.model;

public class Office {
    private int officeId;
    private String officeName;
    private String address;
    private String phone;

    public Office() {
    }

    public Office(int officeId, String officeName, String address, String phone) {
        this.officeId = officeId;
        this.officeName = officeName;
        this.address = address;
        this.phone = phone;
    }

    public int getOfficeId() {
        return officeId;
    }
    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }
    public String getOfficeName() {
        return officeName;
    }
    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Office{" +
                "officeId=" + officeId +
                ", officeName='" + officeName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
