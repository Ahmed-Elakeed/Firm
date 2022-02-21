package service;

import dataAccess.EmployeeDAO;
import dataAccess.OwnerDAO;
import domain.Employee;
import domain.Owner;

import java.util.List;

public class EmployeeService {
    EmployeeDAO employeeDAO=new EmployeeDAO();


    public List<Employee> findAllEmployees(){
        return employeeDAO.findAllEmployees();
    }

    public Employee findEmployeeByID(Integer ID){
        return employeeDAO.findEmployeeByID(ID);
    }

    public void insertEmployee(Employee employee){
        employeeDAO.insertEmployee(employee);
    }

    public void deleteEmployeeByID(Integer ID,Integer manager_id){
        employeeDAO.deleteEmployeeByID(ID,manager_id);
    }
    public Employee login(String email){
        return employeeDAO.login(email);
    }
    public void updateEmployee(Employee employee){
        employeeDAO.updateEmployee(employee);
    }
    public boolean isManager(Integer ID){
        return employeeDAO.isManager(ID);
    }
}
