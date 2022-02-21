package serverSide;


import domain.DataClass;
import domain.PropertyOwned;
import service.PropertyOwnedService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ShowData")
public class ShowData extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PropertyOwnedService propertyOwnedService=new PropertyOwnedService();
        List<DataClass> list=propertyOwnedService.getData();
        req.setAttribute("data",list);
        req.getRequestDispatcher("data.jsp").forward(req,resp);
    }
}
