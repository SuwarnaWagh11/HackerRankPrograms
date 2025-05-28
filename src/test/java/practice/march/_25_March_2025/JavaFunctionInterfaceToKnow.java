package practice.march._25_March_2025;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class JavaFunctionInterfaceToKnow {
    @Test
    public void predicateToKnow(){
        //return T/F boolean value. --> filter() takes predicate as an argument
        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println(isEven.test(4));
        System.out.println(isEven.test(41));
        List<Integer> list = Arrays.asList(10, 3, 4, 5);
        //map() takes function as an argument and return the stream
        Set<Integer> set = list.stream().map(d -> d * 2).sorted().collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(set);
        Supplier<String> supplier;

    }

    @Test
    public void supplierToKnow(){

    }
}
