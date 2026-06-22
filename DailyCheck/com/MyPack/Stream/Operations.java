package DailyCheck.com.MyPack.Stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Operations {

    // get list of 2 employee from each department whose salary is highest
    // and if salary is same then compare by name
    static void DepartmentWithHighestSalary(List<Employee> employeeList)
    {
        Map<String, List<Employee>> hm = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.collectingAndThen(Collectors.toList(),
                        i -> i.stream()
                                .sorted(Comparator.comparingDouble(Employee::getSalary)
                                        .reversed()
                                        .thenComparing(Employee::getEmployeeName))
                                .limit(2)
                                .collect(Collectors.toList()))));

        hm.forEach((k,v)-> System.out.println(k+" "+v));

        //use Collectors.collectingAndThen when u want further operation on that, here we collected in list
        //and then on that list we are performing further action.
        //reverseOrder()->Comparator.reverseOrder, static method we can use when it is comparable naturally
        // reversed(): instance method , used in this type of scenario when further sorting is required.
    }
    public static void main(String[] args) {

        List<Employee> employeeList= DatabaseOfEmployee.getEmployees();

        //employeeList.forEach(System.out::println);

        DepartmentWithHighestSalary(employeeList);


    }
}
