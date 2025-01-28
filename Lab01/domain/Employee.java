package Lab01.domain;

public class Employee {
    private int id;
    private String name;
    private String ssn;
    private double salary;

    public Employee() {}

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getSsn() {return ssn;}
    public void setSsn(String ssn) {this.ssn = ssn;}

    public double getSalary() {return salary;}
    public void setSalary(double salary) {this.salary = salary;}
}