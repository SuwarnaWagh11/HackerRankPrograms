package StringsProgram;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class FindMaxOccurringCharacterTest {

    @Test
    public void test127() {
        String str = "suwarnawagh";//o/p -> a = 3
        List<String> list = Arrays.asList(str.split(""));
        /*Map.Entry<String, Long> result = list.stream().collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get();*/
        Map.Entry<String, Long> result = list.stream().collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue()).get();
        //System.out.println(result);

        
        int[] nums = {2,3,1,3,4,3,1,3,4,3,5,2};
        List<Integer> list1 = Arrays.stream(nums).boxed().toList();
        //System.out.println(list1);
        Map.Entry<Integer, Long> l = list1.stream().collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue()).get();
        //System.out.println(l);
        findMaxOccrUsingStreams(str);
        findMaxOccrWithoutStreams(str);

    }

    private static void findMaxOccrWithoutStreams(String str) {
        char[] arr = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(char c: arr){
            if(!map.containsKey(c)){
                map.put(c, 1);
            }else{
                map.put(c, map.get(c)+1);
            }
        }
        Map.Entry<Character,Integer> maxEntry = null;
        System.out.println(map);
        for(Map.Entry<Character, Integer> l: map.entrySet()){
            if(maxEntry == null || l.getValue().compareTo(maxEntry.getValue()) > 0){
                maxEntry = l;
            }
        }
        System.out.println(maxEntry);
        
    }

    public static void findMaxOccrUsingStreams(String myName){
        List<String> list = Arrays.asList(myName.split(""));
        System.out.println(list);
        Map.Entry<String, Long> l = list.stream().collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue()).get();
        System.out.println(l);
    }
}
