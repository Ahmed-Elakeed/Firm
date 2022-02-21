package serverSide;

import domain.Employee;
import service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Login")
public class Login extends HttpServlet {
    EmployeeService employeeService=new EmployeeService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String email=req.getParameter("email");
            String password=req.getParameter("password");

            Employee employee=employeeService.login(email);
            if(employee!=null) {
                if (employee.getEmp_password().equals(password)) {
                    HttpSession httpSession= req.getSession(true);
                    httpSession.setAttribute("name",employee.getEmp_name());
                    httpSession.setAttribute("email",employee.getEmp_email());
                    httpSession.setAttribute("id",employee.getEmp_id());
                    if(employeeService.isManager(employee.getEmp_id())){
                        httpSession.setAttribute("degree","manager");
                    }else{
                        httpSession.setAttribute("degree","employee");
                    }
                    req.getRequestDispatcher("home.jsp").forward(req, resp);
                } else {
                    resp.sendRedirect("login.html");
                }
            }else{
                resp.sendRedirect("login.html");
            }
    }
}
