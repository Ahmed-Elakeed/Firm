package dataAccess;

import dataAccess.database.DatabaseConfigurations;
import domain.DataClass;
import domain.Owner;
import domain.PropertyOwned;

import javax.xml.crypto.Data;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertyOwnedDAO {
    Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    PreparedStatement preparedStatement;
    public List<PropertyOwned> findAllPropertyOwned(){
        List<PropertyOwned> list=null;
        PropertyOwned propertyOwned;
        try {
            preparedStatement= DatabaseConfigurations.getConnection().prepareStatement("select * from property_owned");
            ResultSet res = preparedStatement.executeQuery();
            list=new ArrayList<PropertyOwned>();
            while (res.next()) {
                int owner_id=res.getInt("owner_id");
                int prop_id=res.getInt("prop_id");
                int percent_owned=res.getInt("percent_owned");
                propertyOwned=new PropertyOwned(owner_id,prop_id,percent_owned);
                list.add(propertyOwned);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return list;
    }
    public PropertyOwned findPropertyOwnedByID(Integer ID) {
        PropertyOwned propertyOwned = null;
        try {
            preparedStatement = DatabaseConfigurations.getConnection().prepareStatement("select * from property_owned where prop_id=?");
            preparedStatement.setObject(1,ID);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                int owner_id=res.getInt("owner_id");
                int prop_id=res.getInt("prop_id");
                int percent_owned=res.getInt("percent_owned");
                propertyOwned=new PropertyOwned(owner_id,prop_id,percent_owned);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return propertyOwned;
    }

    public void insertPropertyOwned(PropertyOwned propertyOwned) {
        try {
            preparedStatement = DatabaseConfigurations.getConnection().prepareStatement("insert into property_owned values (?,?,?)");
            preparedStatement.setObject(1,propertyOwned.getOwner_id());
            preparedStatement.setObject(2,propertyOwned.getProp_id());
            preparedStatement.setObject(3,propertyOwned.getPercent_owned());
            preparedStatement.executeUpdate();
        } catch (Exception throwable) {
            logger.log(Level.SEVERE,"Owner ID Or Property ID has invalid value");
        }
    }

    public void deletePropertyOwnedByID(Integer ID){
        try {
            preparedStatement = DatabaseConfigurations.getConnection().prepareStatement("delete from property_owned where owner_id=?");
            preparedStatement.setObject(1,ID);
            preparedStatement.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
    public void deletePropertyOwnedByPropertyID(Integer ID){
        try {
            preparedStatement = DatabaseConfigurations.getConnection().prepareStatement("delete from property_owned where prop_id=?");
            preparedStatement.setObject(1,ID);
            preparedStatement.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
    public void deletePropertyOwnedByBothID(Integer ID,Integer ID2){
        try {
            preparedStatement = DatabaseConfigurations.getConnection().prepareStatement("delete from property_owned where owner_id=? and prop_id=?");
            preparedStatement.setObject(1,ID);
            preparedStatement.setObject(2,ID2);
            preparedStatement.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
    public List<DataClass> getData(){
        List<DataClass> list=null;
        DataClass dataClass;
        try {
            preparedStatement= DatabaseConfigurations.getConnection().prepareStatement("SELECT owner.owner_id,owner.owner_name,property.prop_id,concat(property.address,concat(\" \",concat(property.city,concat(\" \",concat(property.state,concat(\" ----- (Zip Code) \",property.zip_code)))))) AS \"Address and Zip Code\",property_owned.percent_owned from property_owned INNER join owner on owner.owner_id=property_owned.owner_id INNER JOIN property on property.prop_id=property_owned.prop_id");
            ResultSet res = preparedStatement.executeQuery();
            list=new ArrayList<DataClass>();
            while (res.next()) {
                int owner_id=res.getInt("owner_id");
                String owner_name=res.getString("owner_name");
                int prop_id=res.getInt("prop_id");
                String address=res.getString("Address and Zip Code");
                int percent_owned=res.getInt("percent_owned");
                dataClass=new DataClass(owner_id,owner_name,prop_id,address,percent_owned);
                list.add(dataClass);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return list;
    }
    public Integer allPercents(Integer ID) {
        Integer all_percent=0;
        try {
            preparedStatement = DatabaseConfigurations.getConnection().prepareStatement("SELECT* from (SELECT sum(property_owned.percent_owned) as all_percent from property_owned where property_owned.prop_id=?) tale WHERE tale.all_percent >= 0 and tale.all_percent <=100");
            preparedStatement.setObject(1,ID);
            ResultSet resultSet=preparedStatement.executeQuery();
                while (resultSet.next()) {
                    all_percent = Integer.parseInt(resultSet.getString("all_percent"));
                }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return  all_percent;
    }
}
