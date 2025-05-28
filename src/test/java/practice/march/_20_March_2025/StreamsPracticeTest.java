package practice.march._20_March_2025;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsPracticeTest {

    @Test
    public void findSumOfSquareOfOddNumber(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Integer result = numbers.stream().filter(n-> n % 2 !=0).map(s->(s*s)).mapToInt(Integer::intValue).sum();
        System.out.println(result);
    }

    @Test
    public void findTheLongestWord(){
        List<String> words = Arrays.asList("cat", "elephant", "giraffe", "tiger");
        Optional<String> longestWord = words.stream().max(Comparator.comparingInt(String::length));
        longestWord.ifPresent(System.out::println);
    }

    @Test
    public void groupWordsByTheirFirstCharacterUsingStream(){
        List<String> list = Arrays.asList("suwarna","maruti","sadhna","swapna","sulbha","vimal","mom","randhir");
        Map<Character, List<String>> result = list.stream().collect(Collectors.groupingBy(name -> name.charAt(0)));
        System.out.println(result);
    }
    @Test
    public void groupWordsByTheirFirstCharacter(){
        List<String> list = Arrays.asList("suwarna","maruti","sadhna","swapna","sulbha","vimal","mom","randhir");
        HashMap<Character, List<String>> map = new LinkedHashMap<>();
        for(String name: list){
            if(!map.containsKey(name.charAt(0))){
                map.put(name.charAt(0), new ArrayList<>(Arrays.asList(name)));
            }else{
                map.get(name.charAt(0)).add(name);
            }
        }
        System.out.println(map);
    }

    @Test
    public void findTheSecondLowestNumber(){
        List<Integer> nums = Arrays.asList(1,3,2,5,8,4,1);
        long lowNum = nums.stream().distinct().sorted().skip(1).findFirst().get();
        System.out.println(lowNum);
    }

    @Test
    public void findTheSecondHighestNumber(){
        List<Integer> nums = Arrays.asList(1,3,2,5,8,4,1);
        long num = nums.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(num);

    }
    @Test
    public void convertAListOfStringToUppercase(){
        List<String> list = Arrays.asList("suwarna","maruti","randhir","giri");
        List<String> names = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(names);
    }

    @Test
    public void findTheMaxAndMin(){
        List<Integer> nums = Arrays.asList(1,6,3,8,4,10,9);
        int max = nums.stream().mapToInt(i -> i).max().getAsInt();
        int min = nums.stream().mapToInt(i->i).min().getAsInt();
        System.out.println("Given list contains max number = "+ max + "\n Minimum Number = "+min);
    }

    @Test
    public void evenAndOddFilter(){
        List<Integer> numbers = Arrays.asList(1, 3, 5, 4, 6, 9, 8);
        long oddNumbers = numbers.stream().filter(n-> n % 2 != 0).count();
        System.out.println("Count of Odd Numbers-"+ oddNumbers);
        long evens = numbers.stream().filter(n -> n%2 == 0).count();
        System.out.println("Count of Even Numbers-"+ evens);
    }
}
