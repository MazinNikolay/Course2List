package pro.sky.Course2HomeworkListSpring.service;

import pro.sky.Course2HomeworkListSpring.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    List<Employee> printAllEmployees();
}
