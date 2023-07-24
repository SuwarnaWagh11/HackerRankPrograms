package streamstest;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StudyStreams1 {
    public static void main(String[] args) throws IOException {
        Employee[] arrOfEmp = {
                new Employee(1, "Suwarna Wagh", 20000),
                new Employee(2, "Randhir Giri", 30000),
                new Employee(3, "Suwarna Wagh", 20000),
                new Employee(4, "Vin Diesel w", 20000)
        };
        //create stream of the Employee class -> Stream<Employee>
        Stream<Employee> s = Stream.of(arrOfEmp);
        //or convert it first in List and create 1.
        List<Employee> list = Arrays.asList(arrOfEmp);
        Stream<Employee> lst1 = list.stream();
        //can we build the stream? how?

        List<Employee> result11 = list.stream().collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Employee::getName))))
                .stream().collect(Collectors.toList());

        System.out.println(result11);
        Stream.Builder<Employee> buildr = Stream.builder();
        buildr.accept(arrOfEmp[0]);
        buildr.accept(arrOfEmp[1]);
        Stream<Employee> strm = buildr.build();

        //lets now explore stream operation
        System.out.println(list);
        list.stream().forEach(e->e.salaryIncrement(2000));
        System.out.println(list);
        //Assert.assertEquals(list.get(0).getSalary(), 22000.00,0);

        Stream<String> streamGenerated =
                Stream.generate(() -> "element").limit(10);
        System.out.println(streamGenerated.collect(Collectors.toList()));

       // IntStream.range(1,5).forEach(System.out::print);

        Random random = new Random();
        //random.doubles(1).forEach(System.out::println);

        IntStream s1 = "Suwarna".chars(); //there is no interface for CharStream in JDK,
        //"Suwarna".chars().forEach(System.out::println);

        Path path = Paths.get("C:\\MyApp\\text1.txt");
        //Stream<String> f = Files.lines(path);
        Files.lines(path).forEach(System.out::println);
        List<String> l = Files.lines(path).filter(ele -> ele.contains("very")).collect(Collectors.toList());
        //System.out.println(l);
        //Files.lines(path).forEach(System.out::println);

        Stream<String> stream =
                Stream.of("a", "b", "c").filter(element -> element.contains("b"));
        Optional<String> anyElement = stream.findAny();
        //System.out.println(anyElement);

        Stream<String> onceModifiedStream =
                Stream.of("abcd", "bbcd", "cbcd").skip(1).map(ele -> ele.concat("hey!"));
        onceModifiedStream.forEach(System.out::print);

        List<Integer> num = Arrays.asList(1,2,3,4,5);
        num.stream().map(n -> n *2).forEach(System.out::print);
        System.out.println();

        //list.stream().map(name -> name.getName()).forEach(System.out::println);
        list.stream().map(Employee::getSalary).forEach(System.out::println);

        String lstring = list.stream().map(Employee::getName).collect(Collectors.joining(", ", "(", ")"));
        System.out.println(lstring);

        Double avg = list.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(avg);

        Double sm = list.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(sm);

        Map<Double, List<Employee>> ser1 = list.stream().collect(Collectors.groupingBy(Employee::getSalary));
        System.out.println(ser1);

        Map<Boolean, List<Employee>> lws = list.stream().collect(Collectors.partitioningBy(ele -> ele.getSalary() > 25000));
        System.out.println(lws);
    }
}
