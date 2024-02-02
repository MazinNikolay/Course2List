package pro.sky.Course2HomeworkListSpring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.Course2HomeworkListSpring.exceptions.EmployeeAlreadyAddedException;
import pro.sky.Course2HomeworkListSpring.exceptions.EmployeeNotFoundException;
import pro.sky.Course2HomeworkListSpring.exceptions.EmployeeStorageIsFullException;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee add(@RequestParam("firstName") String firstName,
                        @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        try {
            employeeService.addEmployee(employee);
            return employeeService.findEmployee(firstName, lastName);
        } catch (EmployeeAlreadyAddedException | EmployeeStorageIsFullException | EmployeeNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(path = "/find")
    public Employee find(@RequestParam("firstName") String firstName,
                         @RequestParam("lastName") String lastName) {
        try {
            return employeeService.findEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping(path = "/remove")
    public Employee remove(@RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        try {
            employeeService.removeEmployee(firstName, lastName);
            return employee;
        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(path = "/print")
    public List<Employee> print() {
        return employeeService.printAllEmployees();
    }
}
