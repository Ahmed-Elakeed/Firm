package serverSide;

import domain.Owner;
import service.OwnerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/InsertOwner")
public class InsertOwner extends HttpServlet {
    OwnerService ownerService=new OwnerService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id=Integer.parseInt(req.getParameter("owner_id"));
        String name=req.getParameter("owner_name");
        if(ownerService.findOwnerByID(id)==null){
            ownerService.insertOwner(new Owner(id,name));
            resp.sendRedirect("Owners");
        }else{
            resp.sendRedirect("insertOwner.jsp");
        }

    }
}
