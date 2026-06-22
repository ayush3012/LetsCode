package DailyCheck.com.MyPack.Stream;

import java.util.ArrayList;
import java.util.List;

public class DatabaseOfEmployee {
    public static List<Employee> getEmployees() {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1L, "Ayush", 120000.0, "IT", "Delhi"));
        employees.add(new Employee(2L, "Rahul", 90000.0, "HR", "Mumbai"));
        employees.add(new Employee(3L, "Priya", 150000.0, "IT", "Bangalore"));
        employees.add(new Employee(4L, "Neha", 110000.0, "Finance", "Delhi"));
        employees.add(new Employee(5L, "Amit", 95000.0, "IT", "Pune"));
        employees.add(new Employee(6L, "Rohit", 85000.0, "HR", "Mumbai"));
        employees.add(new Employee(7L, "Anjali", 130000.0, "Finance", "Bangalore"));
        employees.add(new Employee(8L, "Karan", 105000.0, "IT", "Delhi"));
        employees.add(new Employee(9L, "Sneha", 98000.0, "Marketing", "Chennai"));
        employees.add(new Employee(10L, "Vikas", 125000.0, "IT", "Hyderabad"));
        employees.add(new Employee(11L, "Pooja", 87000.0, "HR", "Pune"));
        employees.add(new Employee(12L, "Rakesh", 145000.0, "Finance", "Mumbai"));
        employees.add(new Employee(13L, "Meena", 92000.0, "Marketing", "Delhi"));
        employees.add(new Employee(14L, "Arjun", 135000.0, "IT", "Bangalore"));
        employees.add(new Employee(15L, "Nikita", 108000.0, "Finance", "Hyderabad"));
        employees.add(new Employee(16L, "Deepak", 79000.0, "Support", "Chennai"));
        employees.add(new Employee(17L, "Shreya", 99000.0, "Support", "Pune"));
        employees.add(new Employee(18L, "Manish", 118000.0, "Marketing", "Delhi"));
        employees.add(new Employee(19L, "Ritu", 101000.0, "HR", "Bangalore"));
        employees.add(new Employee(20L, "Saurabh", 160000.0, "IT", "Mumbai"));

        return employees;
    }
}
