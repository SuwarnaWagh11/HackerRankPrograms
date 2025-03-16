package _16_March_2025;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PracticeTest {

    @Test
    public void reverseTheString(){
        String str1 = "SUWARNA";
        String result = IntStream.range(0, str1.length())
                        .mapToObj(i -> String.valueOf(str1.charAt(str1.length() - i - 1)))
                                .collect(Collectors.joining());
        System.out.println(result);
    }

    @Test
    public void removeDuplicateFromString(){
        String str2 = "randhirgirisuwarna"; //op -> suwarnmtigh
        String result = str2.chars()
                .mapToObj(c->String.valueOf((char)c))
                .distinct()
                .collect(Collectors.joining());
        System.out.println(result);
    }

    @Test
    public void removeCharacterFrom1stringPresentInSecondString(){
        String s1 = "suwarna";
        String s2 = "randhir";
        String result = s1.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .filter(c -> !s2.contains(c))
                .collect(Collectors.joining());
        System.out.println(result);
        /*
        * create IntStream from given string1 of characters
        * convert each character into String of stream
        * filter the character which does not contains given character in the string2
        * collect all the character and join them*/
    }

    @Test
    public void findNumberOfAlphabeticsInTheWorld(){
        String s = "    He, is a very very good boy, isn't he!    ";
        String[] res = s.trim().split("[.,'! @]+");
        int len = res.length;
        System.out.println(len);
        Arrays.stream(res).toList().stream().forEach(System.out::println);
    }

    @Test
    public void findMaxOccurrenceOfCharacterInString1(){
        String input = "suwarnawagh";
        List<String> list = Arrays.asList(input.split(""));
        System.out.println(list);
        Map.Entry<String, Long> result = list.stream().collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get();
        System.out.println(result);
    }
    @Test
    public void finMaxOccurrenceOfCharacterInString(){
        String myName = "suwarnawagh";//o/p -> a = 3
        //convert myName string to stream of character
        Stream<Character> r1 = myName.chars().mapToObj(c -> (char) c);
        //group the character by their value and count occurrences of each character
        Map<Character, Long> r2 = r1.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(r2);
        //find the character with minimum occurrences
        Optional<Map.Entry<Character, Long>> r3 = r2.entrySet().stream().max(Map.Entry.comparingByValue());
        System.out.println(r3);
        Character r4 = r3.map(Map.Entry::getKey).orElse(null);
        System.out.println(r4);
    }

    @Test
    public void findMinimumOccurrenceOfCharacter(){
        String anyStr = "aaaaaabbbbbbbccccccccdd";
        //convert string to character
        Character minOccrOfCharacter = anyStr.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse(null);
        System.out.println(minOccrOfCharacter);
    }
    @Test
    public void findMinimumOccurrenceOfCharactersCount(){
        String myStr = "aaaaabbbbbccccdd";
        Long minCharactCount = myStr.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getValue)
                .orElse(null);
        System.out.println(minCharactCount);
    }

    @Test
    public void findMaximumOccurrenceOfCharactersCount(){
        String input = "aaaaaaabbbbbcccd";
        Long maxOccrCount = input.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue())
                .map(Map.Entry::getValue).orElse(null);
        System.out.println(maxOccrCount);
    }

    @Test
    public void findMaximumOccurrenceOfCharacterAndItsValue(){
        String input = "Sachin Tendulkar";
        Map.Entry<Character, Long> result = input.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).orElse(null);
        System.out.println(result);
    }

    @Test
    public void findOccurrenceOfCharacter(){
        String input = "bulbhulaiyyaa";
        Map result = input.chars().mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(result);
    }
}
