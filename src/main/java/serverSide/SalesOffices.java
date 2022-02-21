package serverSide;

import domain.SalesOffice;
import service.SalesOfficeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SalesOffices")
public class SalesOffices extends HttpServlet {
    SalesOfficeService salesOfficeService=new SalesOfficeService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<SalesOffice> list=salesOfficeService.findAllSalesOffice();
        req.setAttribute("data",list);
        req.getRequestDispatcher("salesOffices.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Integer office_num=Integer.parseInt(req.getParameter("office_num"));
            Integer office_num1=Integer.parseInt(req.getParameter("office_num1"));
            if(salesOfficeService.findSalesOfficeByID(office_num)!=null) {
                if (salesOfficeService.findSalesOfficeByID(Integer.parseInt(req.getParameter("office_num1")))!=null) {
                    salesOfficeService.deleteSalesOfficeByID(office_num,office_num1);
                }
            }
            resp.sendRedirect("SalesOffices");
    }
}
