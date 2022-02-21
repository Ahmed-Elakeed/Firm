package serverSide;

import domain.Property;
import service.PropertyOwnedService;
import service.PropertyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Properties")
public class Properties extends HttpServlet {
    PropertyService propertyService=new PropertyService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Property> list=propertyService.findAllProperties();
        req.setAttribute("data",list);
        req.getRequestDispatcher("properties.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Integer id = Integer.parseInt(req.getParameter("prop_id"));
            new PropertyOwnedService().deletePropertyOwnedByPropertyID(id);
            propertyService.deletePropertyByID(id);
            resp.sendRedirect("Properties");
    }
}
