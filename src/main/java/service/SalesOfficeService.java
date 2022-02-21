package service;

import dataAccess.PropertyDAO;
import dataAccess.SalesOfficeDAO;
import domain.Property;
import domain.SalesOffice;

import java.util.List;

public class SalesOfficeService {
    SalesOfficeDAO salesOfficeDAO=new SalesOfficeDAO();

    public List<SalesOffice> findAllSalesOffice(){
        return salesOfficeDAO.findAllSalesOffice();
    }

    public SalesOffice findSalesOfficeByID(Integer ID){
        return salesOfficeDAO.findSalesOfficeByID(ID);
    }

    public void insertSalesOffice(SalesOffice salesOffice){
        salesOfficeDAO.insertSalesOffice(salesOffice);
    }

    public void deleteSalesOfficeByID(Integer ID,Integer office_num){
        salesOfficeDAO.deleteSalesOfficeByID(ID,office_num);
    }
}
