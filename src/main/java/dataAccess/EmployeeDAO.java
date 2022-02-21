package dataAccess;

import dataAccess.database.DatabaseConfigurations;
import domain.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDAO {
    Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    PreparedStatement preparedStatement;
    public List<Employee> findAllEmployees(){
        List<Employee> list=null;
        Employee employee;
        try {
            preparedStatement= DatabaseConfigurations.getConnection().prepareStatement("select * from employee");
            ResultSet res = preparedStatement.executeQuery();
            list=new ArrayList<Employee>();
            while (res.next()) {
                int emp_id=res.getInt("emp_id");
                String emp_name= res.getString("emp_name");
                int office_num=res.getInt("office_num");
                String email=res.getString("email");
                String pass_word= res.getString("password");
                employee=new Employee(emp_id,emp_name,office_num,email,pass_word);
                list.add(employee);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return list;
    }
    public Employee findEmployeeByID(Integer ID) {
        Employee employee = null;
        try {
            preparedStatement = DatabaseConfigurations.getConnection().prepareStatement("select * from employee where emp_id=?");
            preparedStatement.setObject(1,ID);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                int emp_id=res.getInt("emp_id");
                String emp_name= res.getString("emp_name");
                int office_num=res.getInt("office_num");
                String email=res.getString("email");
                String pass_word= res.getString("password");
                employee=new Employee(emp_id,emp_name,office_num,email,pass_word);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return employee;
    }
    public Employee login(String email){
        Employee employee=null;
        try {
            preparedStatement = DatabaseConfigurations.getConnection().prepareStatement("select * from employee where email=?");
            preparedStatement.setObject(1,email);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                int emp_id=res.getInt("emp_id");
                String emp_name= res.getString("emp_name");
                int office_num=res.getInt("office_num");
                String emp_email=res.getString("email");
                String pass_word= res.getString("password");
                employee=new Employee(emp_id,emp_name,office_num,emp_email,pass_word);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
       return employee;
    }
    public void insertEmployee(Employee employee) {
        try {
            preparedStatement = DatabaseConfigurations.getConnection().prepareStatement("insert into employee values (?,?,?,?,?)");
            preparedStatement.setObject(1,employee.getEmp_id());
            preparedStatement.setObject(2,employee.getEmp_name());
            preparedStatement.setObject(3,employee.getOffice_num());
            preparedStatement.setObject(4,employee.getEmp_email());
            preparedStatement.setObject(5,employee.getEmp_password());
            preparedStatement.executeUpdate();
        } catch (Exception throwable) {
            logger.log(Level.SEVERE,"Employee ID has invalid value");
        }
    }

    public void deleteEmployeeByID(Integer ID,Integer manager_id){
        try {
            if(isManager(ID)){
                preparedStatement = DatabaseConfigurations.getConnection().prepareStatement("update Sales_office set manager_id=? where manager_id=?");
                preparedStatement.setObject(1,manager_id);
                preparedStatement.setObject(2,ID);
                preparedStatement.executeUpdate();
                preparedStatement = DatabaseConfigurations.getConnection().prepareStatement("delete from employee where emp_id=?");
                preparedStatement.setObject(1,ID);
                preparedStatement.executeUpdate();
            }else {
                preparedStatement = DatabaseConfigurations.getConnection().prepareStatement("delete from employee where emp_id=?");
                preparedStatement.setObject(1, ID);
                preparedStatement.executeUpdate();
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
        public void updateEmployee(Employee employee){
            try {
                preparedStatement = DatabaseConfigurations.getConnection().prepareStatement("UPDATE employee SET emp_name=?,office_num=?,email=?,pass_word=? WHERE emp_id=?");
                preparedStatement.setObject(1,employee.getEmp_name());
                preparedStatement.setObject(2,employee.getOffice_num());
                preparedStatement.setObject(3,employee.getEmp_email());
                preparedStatement.setObject(4,employee.getEmp_password());
                preparedStatement.setObject(5,employee.getEmp_id());
                preparedStatement.executeUpdate();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }

    }
    public boolean isManager(Integer id){
        boolean flag=false;
        try {
            preparedStatement = DatabaseConfigurations.getConnection().prepareStatement("SELECT * from sales_office WHERE manager_id=?");
            preparedStatement.setObject(1,id);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
              flag=true;
            }

        } catch (Exception throwable) {
            logger.log(Level.SEVERE,"Employee ID has invalid value");
        }
        return flag;
    }
}
