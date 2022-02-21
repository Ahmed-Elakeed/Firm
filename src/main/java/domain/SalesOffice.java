package domain;

public class SalesOffice {
    Integer office_num;
    String office_location;
    Integer manager_id;

    public SalesOffice(Integer office_num, String office_location, Integer manager_id) {
        this.office_num = office_num;
        this.office_location = office_location;
        this.manager_id = manager_id;
    }

    public Integer getOffice_num() {
        return office_num;
    }

    public void setOffice_num(Integer office_num) {
        this.office_num = office_num;
    }

    public String getOffice_location() {
        return office_location;
    }

    public void setOffice_location(String office_location) {
        this.office_location = office_location;
    }

    public Integer getManager_id() {
        return manager_id;
    }

    public void setManager_id(Integer manager_id) {
        this.manager_id = manager_id;
    }

    @Override
    public String toString() {
        return "SalesOffice{" +
                "office_num=" + office_num +
                ", office_location='" + office_location + '\'' +
                ", manager_id=" + manager_id +
                '}';
    }
}
