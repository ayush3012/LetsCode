package DailyCheck_WarmUP.Stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

    static void basicOperation()
    {
        String s="geeksforgeeks";

        //count frequency
        System.out.println("=====count frequency=====");
        s.chars().mapToObj(i->Character.valueOf((char)i))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .forEach((k,v)-> System.out.println(k+" = "+v));

        System.out.println("========================");

        s.chars().mapToObj(i->Character.valueOf((char)i))
                .collect(Collectors.toMap(Function.identity(),i->1,Integer::sum))
                .forEach((k,v)-> System.out.println(k+"->"+v));

        System.out.println("======Reverse string==========");
        //reverse string
        String rev=IntStream.range(0,s.length()).map(i->s.length()-i-1)
                .mapToObj(i->""+s.charAt(i)).collect(Collectors.joining(""));

        System.out.println("reverse of "+s+" is: "+rev);

        System.out.println("======Fibonacci series==========");
        Stream.iterate(new int[]{0,1},f->new int[]{f[1],f[0]+f[1]})
                .map(i->i[0])
                .limit(10).forEach(i-> System.out.print(i+" "));

        System.out.println("\n======String length==========");
        List<String> al= List.of("ayush","karna","rahul","om","jagadish");

        al.stream().collect(Collectors.toMap(Function.identity(),String::length))
                .forEach((k,v)-> System.out.println(k+" with length "+v));

        System.out.println("\n======first unique element==========");
        s.chars().mapToObj(i->Character.valueOf((char)i))
                .filter(i->s.indexOf(i)==s.lastIndexOf(i))
                .limit(1)
                .forEach(i-> System.out.println("first unique char in "+s+" is: "+i));

        System.out.println("\n======Sum of element of array==========");
        int[] arr={1,2,3,4,5,6,7,8,9};

        int sum=Arrays.stream(arr).reduce(0,(a,b)->a+b);

        System.out.println("sum of all element of array: "+Arrays.toString(arr)+" = "+sum);
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

        //basic operations
        basicOperation();
    }
}
