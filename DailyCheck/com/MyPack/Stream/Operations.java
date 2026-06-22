package DailyCheck.com.MyPack.Stream;

import java.util.List;

public class Operations {

    public static void main(String[] args) {
        List<Employee> employeeList= DatabaseOfEmployee.getEmployees();

        employeeList.forEach(i-> System.out.println(i));
    }
}
