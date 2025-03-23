package practice;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PracticeTest {

    @Test
    public void test119() {
        String str = "ssaddaswwsadfggfgtyythjjhyioolkkokkhggtfd";
        //characterCount(str);
        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = str.toCharArray();
        for(char c: arr){
            if(!map.containsKey(c)){
                map.put(c, 1);
            }else{
                map.put(c, map.get(c) + 1);
            }
        }
        List<String> list = Arrays.asList(str);
        System.out.println(map);
        Set<Map.Entry<String, Long>> updated = list.stream()
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                .entrySet();
        System.out.println(updated);
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::print);
        System.out.println();
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::print);
        //map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).forEach(System.out::print);
    }
}
