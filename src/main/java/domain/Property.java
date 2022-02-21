package domain;

public class Property {
    int prop_id;
    String address;
    String city;
    String state;
    String zip_code;
    int office_num;

    public Property(int prop_id, String address, String city, String state, String zip_code, int office_num) {
        this.prop_id = prop_id;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip_code = zip_code;
        this.office_num = office_num;
    }

    public int getProp_id() {
        return prop_id;
    }

    public void setProp_id(int prop_id) {
        this.prop_id = prop_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public int getOffice_num() {
        return office_num;
    }

    public void setOffice_num(int office_num) {
        this.office_num = office_num;
    }

    @Override
    public String toString() {
        return "Property{" +
                "prop_id=" + prop_id +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip_code='" + zip_code + '\'' +
                ", office_num=" + office_num +
                '}';
    }
}
