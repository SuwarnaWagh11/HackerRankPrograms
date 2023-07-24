package StringsProgram;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicateFromString {
    public static void main(String[] args) {
        String str = "suwarnawagh";//o/p -> suwarngh
        List<String> list = Arrays.asList(str.split(""));
        //list.stream().distinct().collect(Collectors.toList());
        System.out.println(list.stream().distinct().collect(Collectors.toList()));
    }
}
