package streamstest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class RemoveTheDuplicateEmployeeFromList {

    public static void main(String[] args) {
        Employee[] arrOfEmp = {
                new Employee(1, "Suwarna Wagh", 20000),
                new Employee(2, "Randhir Giri", 30000),
                new Employee(3, "Suwarna Wagh", 20000),
                new Employee(4, "Vin Diesel w", 20000)
        };
        List<Employee> list = Arrays.asList(arrOfEmp);
        List<Employee> result = list.stream().collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Employee::getName)))).stream().toList();
        System.out.println(result.stream().max(Comparator.comparing(Employee::getSalary)).get());
    }
}
