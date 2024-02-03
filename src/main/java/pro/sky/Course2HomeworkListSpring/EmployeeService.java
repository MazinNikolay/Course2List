package pro.sky.Course2HomeworkListSpring;

import java.util.List;

public interface EmployeeService {

    void addEmployee(Employee employee);

    void removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    List<Employee> printAllEmployees();
}
