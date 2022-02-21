package dataAccess;

import dataAccess.database.DatabaseConfigurations;
import domain.PropertyOwned;
import domain.SalesOffice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SalesOfficeDAO {
    Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    PreparedStatement preparedStatement;
    public List<SalesOffice> findAllSalesOffice(){
        List<SalesOffice> list=null;
        SalesOffice salesOffice;
        try {
            preparedStatement= DatabaseConfigurations.getConnection().prepareStatement("select * from sales_office");
            ResultSet res = preparedStatement.executeQuery();
            list=new ArrayList<SalesOffice>();
            while (res.next()) {
                int office_num=res.getInt("office_num");
                String office_location=res.getString("office_location");
                int manager_id=res.getInt("manager_id");
                salesOffice=new SalesOffice(office_num,office_location,manager_id);
                list.add(salesOffice);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return list;
    }
    public SalesOffice findSalesOfficeByID(Integer ID) {
        SalesOffice salesOffice = null;
        try {
            preparedStatement = DatabaseConfigurations.getConnection().prepareStatement("select * from sales_office where office_num=?");
            preparedStatement.setObject(1,ID);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                int office_num=res.getInt("office_num");
                String office_location=res.getString("office_location");
                int manager_id=res.getInt("manager_id");
                salesOffice=new SalesOffice(office_num,office_location,manager_id);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return salesOffice;
    }

    public void insertSalesOffice(SalesOffice salesOffice) {
        try {
            preparedStatement = DatabaseConfigurations.getConnection().prepareStatement("insert into sales_office values (?,?,?)");
            preparedStatement.setObject(1,salesOffice.getOffice_num());
            preparedStatement.setObject(2,salesOffice.getOffice_location());
            preparedStatement.setObject(3,salesOffice.getManager_id());
            preparedStatement.executeUpdate();
        } catch (Exception throwable) {
            logger.log(Level.SEVERE,"Office Num has invalid value");
        }
    }

    public void deleteSalesOfficeByID(Integer ID,Integer office_num){
        try {
                preparedStatement = DatabaseConfigurations.getConnection().prepareStatement("update employee set office_num=? where office_num=?");
                preparedStatement.setObject(1, office_num);
                preparedStatement.setObject(2, ID);
                preparedStatement.executeUpdate();
                preparedStatement = DatabaseConfigurations.getConnection().prepareStatement("update property set office_num=? where office_num=?");
                preparedStatement.setObject(1, office_num);
                preparedStatement.setObject(2, ID);
                preparedStatement.executeUpdate();
                preparedStatement = DatabaseConfigurations.getConnection().prepareStatement("delete from sales_office where office_num=?");
                preparedStatement.setObject(1, ID);
                preparedStatement.executeUpdate();

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
