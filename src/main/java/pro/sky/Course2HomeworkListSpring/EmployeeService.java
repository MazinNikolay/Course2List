package pro.sky.Course2HomeworkListSpring;

public interface EmployeeService {

    void addEmployee(Employee employee);
    void removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);

}
