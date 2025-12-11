import java.util.*;
import java.text.NumberFormat;


class Employee {
    // Private instance variables (Encapsulation)
    private int employee_id;
    private String employee_name;
    private double employee_salary;

    // Constructor
    public Employee(int employee_id, String employee_name, double employee_salary) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
    }

    // Getter and Setter for employee_id
    public int getEmployeeId() {
        return employee_id;
    }

    public void setEmployeeId(int employee_id) {
        this.employee_id = employee_id;
    }

    // Getter and Setter for employee_name
    public String getEmployeeName() {
        return employee_name;
    }

    public void setEmployeeName(String employee_name) {
        this.employee_name = employee_name;
    }

    // Getter for employee_salary (returns formatted string)
    public String getEmployeeSalary() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        return formatter.format(employee_salary);
    }

    // Protected method to get raw salary (used internally)
    protected double getRawSalary() {
        return employee_salary;
    }

    @Override
    public String toString() {
        return "Employee{ID=" + employee_id + ", Name='" + employee_name +
                "', Salary=" + getEmployeeSalary() + "}";
    }
}
