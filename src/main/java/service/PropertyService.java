package service;

import dataAccess.EmployeeDAO;
import dataAccess.PropertyDAO;
import domain.Employee;
import domain.Property;

import java.util.List;

public class PropertyService {
    PropertyDAO propertyDAO=new PropertyDAO();

    public List<Property> findAllProperties(){
        return propertyDAO.findAllProperties();
    }

    public Property findPropertyByID(Integer ID){
        return propertyDAO.findPropertyByID(ID);
    }

    public void insertProperty(Property property){
        propertyDAO.insertProperty(property);
    }

    public void deletePropertyByID(Integer ID){
        propertyDAO.deletePropertyByID(ID);
    }
}
