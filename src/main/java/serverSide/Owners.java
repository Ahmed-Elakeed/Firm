package serverSide;

import domain.Owner;
import service.OwnerService;
import service.PropertyOwnedService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Owners")
public class Owners extends HttpServlet {
    OwnerService ownerService=new OwnerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Owner> list=ownerService.findAllOwners();
        req.setAttribute("data",list);
        req.getRequestDispatcher("owners.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Integer id = Integer.parseInt(req.getParameter("owner_id"));
            new PropertyOwnedService().deletePropertyOwnedByID(id);
            ownerService.deleteOwnerByID(id);
            resp.sendRedirect("Owners");
    }
}
