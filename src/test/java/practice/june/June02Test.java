package practice.june;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.maxBy;

public class June02Test {
    List<Employee> employee = List.of(
            new Employee("Alice", "HR", 30000),
            new Employee("Bob", "IT", 35000),
            new Employee("John", "HR", 33000),
            new Employee("Mike", "IT", 32000),
            new Employee("Ewa", "HR", 34000));

    @Test
    public void groupStringsByTheirLength() {
        List<String> words = List.of("apple", "banana", "pear", "kiwi", "plum");
        Map<Integer, List<String>> res = words.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(res);
    }

    @Test
    public void groupNumbersIntoEvenAndOdd() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
        Map<String, List<Integer>> res = numbers.stream().collect(Collectors.groupingBy(
                i -> i % 2 == 0 ? "Even" : "Odd"
        ));
        System.out.println(res);
    }

    @Test
    public void groupEmployeesByDept() {
        Map<String, List<Employee>> result = employee.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(result);
    }

    @Test
    public void countNoOfEmployeesInEachDept() {
        Map<String, Long> res = employee.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(res);
    }

    @Test
    public void GroupAndFindMaxSalaryInEachDepartment() {
        Object result = employee.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                collectingAndThen(maxBy(Comparator.comparingDouble(Employee::getSalary)), Optional::get)));


        Map<String, Employee> res = employee.stream().collect(Collectors.toMap( //- Collects the stream into a Map<String, Employee>, with a custom merge strategy.
                Employee::getDepartment,   // keyMapper - Extracts the key for the map (department name).
                Function.identity(),       // valueMapper - Uses the whole Employee object as the value.
                BinaryOperator.maxBy(       // merge function (if key conflict) - When two employees have the same department key (i.e., key collision), the merge function picks the one with the higher salary.
                        Comparator.comparingDouble(Employee::getSalary)    // compare salaries
                )));
        System.out.println(res);

        Map<String, Optional<Employee>> res2 = employee.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                maxBy(Comparator.comparingDouble(Employee::getSalary))));
        System.out.println(res2);
        /*
        employee stream
        collect - using grouping strategy
        groupingBy - used key as department
        collectingAndThen-to collect max by salary and then convert it to plain Employee
        maxBy(comparingDOuble by salary - which returns Option<Employee> we need to wrap it in above function
        */
        Map<String, Employee> res3 = employee.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.collectingAndThen(maxBy(Comparator.comparingDouble(Employee::getSalary)), Optional::get)));
        System.out.println(res3);


    }
}
