package domain;

public class PropertyOwned {
    Integer owner_id;
    Integer prop_id;
    Integer percent_owned;

    public PropertyOwned(Integer owner_id, Integer prop_id, Integer percent_owned) {
        this.owner_id = owner_id;
        this.prop_id = prop_id;
        this.percent_owned = percent_owned;
    }

    public Integer getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Integer owner_id) {
        this.owner_id = owner_id;
    }

    public Integer getProp_id() {
        return prop_id;
    }

    public void setProp_id(Integer prop_id) {
        this.prop_id = prop_id;
    }

    public Integer getPercent_owned() {
        return percent_owned;
    }

    public void setPercent_owned(Integer percent_owned) {
        this.percent_owned = percent_owned;
    }

    @Override
    public String toString() {
        return "PropertyOwned{" +
                "owner_id=" + owner_id +
                ", prop_id=" + prop_id +
                ", percent_owned=" + percent_owned +
                '}';
    }
}
