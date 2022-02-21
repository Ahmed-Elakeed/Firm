package domain;

public class Employee {
    Integer emp_id;
    String emp_name;
    Integer office_num;
    String emp_email;
    String emp_password;

    public Employee(Integer emp_id, String emp_name, Integer office_num,String emp_email, String emp_password) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.office_num = office_num;
        this.emp_email=emp_email;
        this.emp_password = emp_password;
    }

    public String getEmp_email() {
        return emp_email;
    }

    public void setEmp_email(String emp_email) {
        this.emp_email = emp_email;
    }

    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public Integer getOffice_num() {
        return office_num;
    }

    public void setOffice_num(Integer office_num) {
        this.office_num = office_num;
    }

    public String getEmp_password() {
        return emp_password;
    }

    public void setEmp_password(String emp_password) {
        this.emp_password = emp_password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_id=" + emp_id +
                ", emp_name='" + emp_name + '\'' +
                ", office_num=" + office_num +
                ", emp_password='" + emp_password + '\'' +
                '}';
    }
}
