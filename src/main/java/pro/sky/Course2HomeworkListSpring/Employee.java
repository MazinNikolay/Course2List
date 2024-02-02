package pro.sky.Course2HomeworkListSpring;

public class Employee {


    private String firstName = "";
    private String lastName = "";


    public Employee(String firstName, String lastName) {
        if (firstName.isEmpty() || firstName.isBlank()) {
            throw new IllegalArgumentException("Не заполнено имя сотрудника");
        } else {
            this.firstName = firstName;
        }
        if (lastName.isEmpty() || lastName.isBlank()) {
            throw new IllegalArgumentException("Не заполнена фамилия сотрудника");
        } else {
            this.lastName = lastName;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    public int hashCode() {
        return 31 * this.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Employee employee = (Employee) obj;
        return this.firstName.equals(employee.getFirstName()) && this.lastName.equals(employee.getLastName());
    }
}
