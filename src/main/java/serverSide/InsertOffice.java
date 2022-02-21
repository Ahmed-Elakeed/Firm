package serverSide;

import domain.SalesOffice;
import service.EmployeeService;
import service.SalesOfficeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/InsertOffice")
public class InsertOffice extends HttpServlet {
    SalesOfficeService salesOfficeService=new SalesOfficeService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer office_num=Integer.parseInt(req.getParameter("office_num"));
        String office_location=req.getParameter("office_location");
        Integer manager_id=Integer.parseInt(req.getParameter("manager_id"));
        if(salesOfficeService.findSalesOfficeByID(office_num)==null && new EmployeeService().findEmployeeByID(manager_id)!=null){
            salesOfficeService.insertSalesOffice(new SalesOffice(office_num,office_location,manager_id));
            resp.sendRedirect("SalesOffices");
        }else{
            resp.sendRedirect("insertOffice.jsp");
        }
    }
}
