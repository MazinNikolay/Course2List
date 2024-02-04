package pro.sky.Course2HomeworkListSpring.service;

import org.springframework.stereotype.Service;
import pro.sky.Course2HomeworkListSpring.exception.EmployeeAlreadyAddedException;
import pro.sky.Course2HomeworkListSpring.exception.EmployeeNotFoundException;
import pro.sky.Course2HomeworkListSpring.exception.EmployeeStorageIsFullException;
import pro.sky.Course2HomeworkListSpring.model.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    final private static int MAX_RANGE_EMPLOYEE = 4;

    private final List<Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new ArrayList<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.size() >= MAX_RANGE_EMPLOYEE) {
            throw new EmployeeStorageIsFullException("Превышен лимит количества сотрудников в фирме");
        } else if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Сотрудник с такими данными уже добавлен");
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Сотрудник с заданными данными не найден");
        }
        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee target = new Employee(firstName, lastName);
        int targetIndex = employees.indexOf(target);
//        if (!employees.contains(target)) {
        if (targetIndex < 0) {
            throw new EmployeeNotFoundException("Сотрудник с заданными данными не найден");
        }
        return employees.get(targetIndex);
    }

    @Override
    public List<Employee> printAllEmployees() {
        return Collections.unmodifiableList(employees);
    }
}
