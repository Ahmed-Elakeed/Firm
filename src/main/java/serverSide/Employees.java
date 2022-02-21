package serverSide;

import domain.Employee;
import service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Employees")
public class Employees extends HttpServlet {
    EmployeeService employeeService=new EmployeeService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> list=employeeService.findAllEmployees();
        req.setAttribute("data",list);
        req.getRequestDispatcher("employees.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                    Integer id=Integer.parseInt(req.getParameter("emp_id"));
                    Integer manager_id=Integer.parseInt(req.getParameter("manager_id"));
                    if(employeeService.findEmployeeByID(manager_id)!=null && employeeService.findEmployeeByID(id)!=null && !id.equals(manager_id)) {
                        employeeService.deleteEmployeeByID(id, manager_id);
                    }
                     resp.sendRedirect("Employees");
    }
}
