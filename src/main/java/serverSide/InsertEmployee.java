package serverSide;

import domain.Employee;
import service.EmployeeService;
import service.SalesOfficeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/InsertEmployee")
public class InsertEmployee extends HttpServlet {
   EmployeeService employeeService=new EmployeeService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer emp_id=Integer.parseInt(req.getParameter("emp_id"));
        String emp_name=req.getParameter("emp_name");
        Integer emp_officeNumber=Integer.parseInt(req.getParameter("emp_officeNumber"));
        String emp_email=req.getParameter("emp_email");
        String emp_pass=req.getParameter("emp_pass");
        String emp_pass1=req.getParameter("emp_pass1");
        if(new SalesOfficeService().findSalesOfficeByID(emp_officeNumber)!=null && employeeService.findEmployeeByID(emp_id)==null && employeeService.login(emp_email)==null && emp_pass.equals(emp_pass1)){
            employeeService.insertEmployee(new Employee(emp_id,emp_name,emp_officeNumber,emp_email,emp_pass));
            resp.sendRedirect("Employees");
        }else{
            resp.sendRedirect("insertEmployee.jsp");
        }
    }
}
