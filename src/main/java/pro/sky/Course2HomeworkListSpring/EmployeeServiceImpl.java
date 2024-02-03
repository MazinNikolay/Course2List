package pro.sky.Course2HomeworkListSpring;

import org.springframework.stereotype.Service;
import pro.sky.Course2HomeworkListSpring.exceptions.EmployeeAlreadyAddedException;
import pro.sky.Course2HomeworkListSpring.exceptions.EmployeeNotFoundException;
import pro.sky.Course2HomeworkListSpring.exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    final private static int maxRangeEmployee = 4;

    private final List<Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new ArrayList<>();
    }

    @Override
    public void addEmployee(Employee employee) {
        if (employees.size() >= maxRangeEmployee) {
            throw new EmployeeStorageIsFullException("Превышен лимит количества сотрудников в фирме");
        } else if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Сотрудник с такими данными уже добавлен");
        }
        employees.add(employee);
    }

    @Override
    public void removeEmployee(String firstName, String lastName) {
        if (!employees.contains(new Employee(firstName, lastName))) {
            throw new EmployeeNotFoundException("Сотрудник с заданными данными не найден");
        }
        Employee employee = new Employee(firstName, lastName);
        employees.remove(employee);
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException("Сотрудник с заданными данными не найден");
    }

    @Override
    public List<Employee> printAllEmployees() {
        return Collections.unmodifiableList(employees);
    }
}
