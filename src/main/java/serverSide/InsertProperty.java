package serverSide;

import domain.Property;
import service.PropertyService;
import service.SalesOfficeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/InsertProperty")
public class InsertProperty extends HttpServlet {
    PropertyService propertyService=new PropertyService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Integer prop_id=Integer.parseInt(req.getParameter("prop_id"));
            String prop_address=req.getParameter("prop_address");
            String prop_city=req.getParameter("prop_city");
            String prop_state=req.getParameter("prop_state");
            String prop_zipCode=req.getParameter("prop_zipCode");
            Integer prop_officeNum=Integer.parseInt(req.getParameter("prop_officeNum"));
            if(propertyService.findPropertyByID(prop_id)==null && new SalesOfficeService().findSalesOfficeByID(prop_officeNum)!=null) {
                propertyService.insertProperty(new Property(prop_id, prop_address, prop_city, prop_state, prop_zipCode, prop_officeNum));
                resp.sendRedirect("Properties");
            }else {
                resp.sendRedirect("insertProperty.jsp");
            }
    }
}
