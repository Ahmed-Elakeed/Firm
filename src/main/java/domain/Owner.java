package domain;

import service.OwnerService;

public class Owner {
    private Integer ID;
    private String name;

    public Owner(Integer ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                '}';
    }
}
