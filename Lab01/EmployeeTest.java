package Lab01;

import Lab01.domain.Employee;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setId(101);
        emp.setName("Jane Smith");
        emp.setSsn("012-34-4567");
        emp.setSalary(120_345.27);

        System.out.println("Employee id = " + emp.getId());
        System.out.println("Employee name = " + emp.getName());
        System.out.println("Employee Soc Sec = " + emp.getSsn());
        System.out.println("Employee salary = " + emp.getSalary());
    }
}