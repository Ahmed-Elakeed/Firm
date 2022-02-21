package dataAccess;

import dataAccess.database.DatabaseConfigurations;
import domain.Employee;
import domain.Property;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertyDAO {
    Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    PreparedStatement preparedStatement;
    public List<Property> findAllProperties(){
        List<Property> list=null;
        Property property;
        try {
            preparedStatement= DatabaseConfigurations.getConnection().prepareStatement("select * from property");
            ResultSet res = preparedStatement.executeQuery();
            list=new ArrayList<Property>();
            while (res.next()) {
                int prop_id=res.getInt("prop_id");
                String address= res.getString("address");
                String city= res.getString("city");
                String state= res.getString("state");
                String zip_code= res.getString("zip_code");
                int office_num=res.getInt("office_num");
                property=new Property(prop_id,address,city,state,zip_code,office_num);
                list.add(property);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return list;
    }
    public Property findPropertyByID(Integer ID) {
        Property property = null;
        try {
            preparedStatement = DatabaseConfigurations.getConnection().prepareStatement("select * from property where prop_id=?");
            preparedStatement.setObject(1,ID);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                int prop_id=res.getInt("prop_id");
                String address= res.getString("address");
                String city= res.getString("city");
                String state= res.getString("state");
                String zip_code= res.getString("zip_code");
                int office_num=res.getInt("office_num");
                property=new Property(prop_id,address,city,state,zip_code,office_num);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return property;
    }

    public void insertProperty(Property property) {
        try {
            preparedStatement = DatabaseConfigurations.getConnection().prepareStatement("insert into property values (?,?,?,?,?,?)");
            preparedStatement.setObject(1,property.getProp_id());
            preparedStatement.setObject(2,property.getAddress());
            preparedStatement.setObject(3,property.getCity());
            preparedStatement.setObject(4,property.getState());
            preparedStatement.setObject(5,property.getZip_code());
            preparedStatement.setObject(6,property.getOffice_num());
            preparedStatement.executeUpdate();
        } catch (Exception throwable) {
            logger.log(Level.SEVERE,"Property ID has invalid value");
        }
    }

    public void deletePropertyByID(Integer ID){
        try {
            preparedStatement = DatabaseConfigurations.getConnection().prepareStatement("delete from property where prop_id=?");
            preparedStatement.setObject(1,ID);
            preparedStatement.executeUpdate();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
