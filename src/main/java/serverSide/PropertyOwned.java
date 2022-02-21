package serverSide;

import domain.DataClass;
import service.PropertyOwnedService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/PropertyOwned")
public class PropertyOwned extends HttpServlet {
    PropertyOwnedService propertyOwnedService=new PropertyOwnedService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("PropertyOwnedTopNav.jsp").include(req,resp);
        List<DataClass> list=new PropertyOwnedService().getData();
        req.setAttribute("data",list);
        req.getRequestDispatcher("data.jsp").include(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String owner_id=req.getParameter("owner_id");
        String prop_id=req.getParameter("prop_id");
        if(owner_id!="" && prop_id!=""){
            propertyOwnedService.deletePropertyOwnedByBothID(Integer.parseInt(owner_id),Integer.parseInt(prop_id));
        }else if(owner_id!="" && prop_id==""){
            propertyOwnedService.deletePropertyOwnedByID(Integer.parseInt(owner_id));
        }else if(owner_id=="" && prop_id!=""){
            propertyOwnedService.deletePropertyOwnedByPropertyID(Integer.parseInt(prop_id));
        }
        resp.sendRedirect("PropertyOwned");
    }
}
