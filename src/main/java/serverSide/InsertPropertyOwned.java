package serverSide;

import domain.PropertyOwned;
import service.OwnerService;
import service.PropertyOwnedService;
import service.PropertyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/InsertPropertyOwned")
public class InsertPropertyOwned extends HttpServlet {
    PropertyOwnedService propertyOwnedService=new PropertyOwnedService();
    OwnerService ownerService=new OwnerService();
    PropertyService propertyService=new PropertyService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String owner_id=req.getParameter("owner_id");
        String prop_id=req.getParameter("prop_id");
        String percent_owned=req.getParameter("percent_owned");
        if(ownerService.findOwnerByID(Integer.parseInt(owner_id))==null || propertyService.findPropertyByID(Integer.parseInt(prop_id))==null){
            resp.sendRedirect("insertPropertyOwnedForm.jsp");
        }else {
            if (Integer.parseInt(percent_owned) + propertyOwnedService.all_percent(Integer.parseInt(prop_id)) > 100) {
                resp.sendRedirect("insertPropertyOwnedForm.jsp");
            } else {
                propertyOwnedService.insertPropertyOwned(new PropertyOwned(Integer.parseInt(owner_id), Integer.parseInt(prop_id), Integer.parseInt(percent_owned)));
                resp.sendRedirect("PropertyOwned");
            }
        }
    }
}
