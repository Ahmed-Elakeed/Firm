package serverSide;

import domain.Employee;
import service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
    EmployeeService employeeService=new EmployeeService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String old_pass=req.getParameter("old_pass");
            String new_pass1=req.getParameter("new_pass1");
            String new_pass2=req.getParameter("new_pass2");
            Integer id=Integer.parseInt(req.getSession(false).getAttribute("id").toString());
            Employee employee=employeeService.findEmployeeByID(id);
            if(employee.getEmp_password().equals(old_pass) && new_pass1.equals(new_pass2)){
                employee.setEmp_password(new_pass1);
                employeeService.updateEmployee(employee);
                req.getSession().invalidate();
                resp.sendRedirect("login.html");
            }else{
                resp.sendRedirect("changePassword.jsp");
            }
    }
}
