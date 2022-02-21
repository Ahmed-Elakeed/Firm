package domain;

public class DataClass {
    int owner_id;
    String owner_name;
    int prop_id;
    String prop_address;
    int percent_owned;

    public DataClass(int owner_id, String owner_name, int prop_id, String prop_address, int percent_owned) {
        this.owner_id = owner_id;
        this.owner_name = owner_name;
        this.prop_id = prop_id;
        this.prop_address = prop_address;
        this.percent_owned = percent_owned;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public int getProp_id() {
        return prop_id;
    }

    public void setProp_id(int prop_id) {
        this.prop_id = prop_id;
    }

    public String getProp_address() {
        return prop_address;
    }

    public void setProp_address(String prop_address) {
        this.prop_address = prop_address;
    }

    public int getPercent_owned() {
        return percent_owned;
    }

    public void setPercent_owned(int percent_owned) {
        this.percent_owned = percent_owned;
    }
}
