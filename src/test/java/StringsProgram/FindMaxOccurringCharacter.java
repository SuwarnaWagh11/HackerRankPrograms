package StringsProgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindMaxOccurringCharacter {

    public static void main(String[] args) {
        String str = "suwarnawagh";//o/p -> a = 3
        List<String> list = Arrays.asList(str.split(""));
        Map.Entry<String, Long> result = list.stream().collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get();
        System.out.println(result);


    }
}
