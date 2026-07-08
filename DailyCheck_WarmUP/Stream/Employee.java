package DailyCheck_WarmUP.Stream;

public class Employee {

    private Long employeeId;
    private String employeeName;
    private Double salary;
    private String department;
    private String location;

    public Employee() {
    }

    public Employee(Long employeeId, String employeeName, Double salary,
                    String department, String location) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
        this.department = department;
        this.location = location;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
