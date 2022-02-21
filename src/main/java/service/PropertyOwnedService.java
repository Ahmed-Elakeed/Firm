package service;

import dataAccess.OwnerDAO;
import dataAccess.PropertyOwnedDAO;
import domain.DataClass;
import domain.Owner;
import domain.PropertyOwned;

import java.util.List;

public class PropertyOwnedService {
   PropertyOwnedDAO propertyOwnedDAO=new PropertyOwnedDAO();


    public List<PropertyOwned> findAllPropertyOwned(){
        return propertyOwnedDAO.findAllPropertyOwned();
    }

    public PropertyOwned findPropertyOwnedByID(Integer ID){
        return propertyOwnedDAO.findPropertyOwnedByID(ID);
    }

    public void insertPropertyOwned(PropertyOwned propertyOwned){
        propertyOwnedDAO.insertPropertyOwned(propertyOwned);
    }

    public void deletePropertyOwnedByID(Integer ID){
        propertyOwnedDAO.deletePropertyOwnedByID(ID);
    }
    public void deletePropertyOwnedByPropertyID(Integer ID){
        propertyOwnedDAO.deletePropertyOwnedByPropertyID(ID);
    }
    public void deletePropertyOwnedByBothID(Integer ID,Integer ID2){
        propertyOwnedDAO.deletePropertyOwnedByBothID(ID,ID2);
    }
    public List<DataClass> getData(){
        return propertyOwnedDAO.getData();
    }
    public Integer all_percent(Integer ID){
        return propertyOwnedDAO.allPercents(ID);
    }
}
