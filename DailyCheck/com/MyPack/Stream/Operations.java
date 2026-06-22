package DailyCheck.com.MyPack.Stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Operations {

    // get list of 2 employee from each department whose salary is highest
    // and if salary is same then compare by name
    /*
      SQL query for employee with highest salary in each department::
      select * from ( select e.*, dense_rank() over (partition by department order by salary desc)r
      from employee e) where e.r=1;

      SQL query for second highest salary::
      select * from (select *, dense_rank() over (order by salary desc)r from employee) where r=2;

      SQL query to delete duplicate record::
      delete from employee where id IN (select id from (select id,ROW_NUMBER() over (partition by email order
      by order_id)r from employee) where r>1);
    * */
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

    static void secondHighestSalary(List<Employee> employeeList)
    {
        Employee e= employeeList.stream()
            .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
            .collect(Collectors.toMap(
                    Employee::getSalary,
                    emp -> emp,
                    (e1, e2) -> e1,
                    LinkedHashMap::new
            ))
            .values()
            .stream()
            .skip(1)//.skip(n-1) for nth highest salary
            .findFirst()
            .orElse(null);
        System.out.println(e);
    }

    static void averageSalaryInEachDepartment(List<Employee> employeeList)
    {
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment
                ,Collectors.averagingDouble(Employee::getSalary)))
                //,Collectors.summingDouble(Employee::getSalary)
                .forEach((k,v)-> System.out.println(k+" "+v));
    }

    static void departmentHavingMaxEmployee(List<Employee> employeeList)
    {
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .stream().forEach(i-> System.out.println(i));
    }

    static void top3HighestSalaryEmployee(List<Employee> employeeList)
    {
        employeeList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(3).forEach(i-> System.out.println(i));
    }

    static void sortedEmployeeName(List<Employee> employeeList)
    {
        employeeList.stream().map(Employee::getEmployeeName).sorted()
                .forEach(i-> System.out.println(i));
    }

    static void longestNamedEmployee(List<Employee> employeeList)
    {
        Employee e=employeeList.stream().max(Comparator.comparingDouble(i->i.getEmployeeName().length()))
                .orElse(null);

        System.out.println(e);
    }
    public static void main(String[] args) {

        List<Employee> employeeList= DatabaseOfEmployee.getEmployees();

        //print all employee
        //employeeList.forEach(System.out::println);

        //count of all employee
        //System.out.println("Total employees:-"+employeeList.stream().count());

        //max salary among all employee
        //Employee e=employeeList.stream().max(Comparator.comparing(Employee::getSalary)).orElse(null);

        //System.out.println(e);

        //second highest salary among all the employee
        //secondHighestSalary(employeeList);

        // max salary department wise
        //DepartmentWithHighestSalary(employeeList);

        //average salary in each department
        //averageSalaryInEachDepartment(employeeList);

        //department having max employee
        //departmentHavingMaxEmployee(employeeList);

        //top 3 highest salried employee
        //top3HighestSalaryEmployee(employeeList);

        //Employee name sorted
        //sortedEmployeeName(employeeList);

        //longest named employee
        //longestNamedEmployee(employeeList);
    }
}
