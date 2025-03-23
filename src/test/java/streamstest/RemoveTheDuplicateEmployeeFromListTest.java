package streamstest;

import org.junit.jupiter.api.Test;

import java.util.*;

public class RemoveTheDuplicateEmployeeFromListTest {

    @Test
    public void test11() {
        Employee[] arrOfEmp = {
                new Employee(1, "Suwarna Wagh", 40000),
                new Employee(2, "Randhir Giri", 30000),
                new Employee(3, "Abcdfe jiji", 20000),
                new Employee(4, "Vin Diesel w", 10000)
        };
        List<Employee> list = Arrays.asList(arrOfEmp);
        //List<Employee> result = list.stream().collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Employee::getName)))).stream().toList();
        //System.out.println(result.stream().max(Comparator.comparing(Employee::getSalary)).get());

        System.out.println(list);
        Collections.reverseOrder(Comparator.comparing(Employee::getSalary));
        //Collections.sort(list, Comparator.comparing(Employee::getSalary));
        //Collections.sort(list, Comparator.comparing(Employee::getName));
//[Employee{id=3, name='Abcdfe jiji', salary=20000.0}, Employee{id=2, name='Randhir Giri', salary=30000.0}, Employee{id=1, name='Suwarna Wagh', salary=20000.0}, Employee{id=4, name='Vin Diesel w', salary=20000.0}]
        System.out.println(list);
    }
}
