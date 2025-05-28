package practice.may._28_May_2025;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class May28_StreamTest {
    @Test
    public void convertAllToUpperCase(){
        String[] names = {"john", "doe"};
        List<String> res = Arrays.stream(names).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(res);
    }

    @Test
    public void countNameWithLength3(){
        String[] names = {"Ava", "Bob", "Charlie"};
        long res = Arrays.stream(names).filter(n -> n.length() > 3).count();
        System.out.println(res);
    }
    @Test
    public void sortNameAlphabetically(){
        String[] names = {"Zara", "Liam", "Anna"};
        List<String> res = Arrays.stream(names).sorted().toList();
        System.out.println(res);
    }

    @Test
    public void joinNamesByComma(){
        String[] names = {"Alice", "Bob", "Anna"};
        String res = String.join(",", names);
        System.out.println(res);
    }

    @Test
    public void findLongestString(){
        String[] words = {"cat", "elephant", "dog"};
        String max = "";
        int count = 0;
        for(int i =0; i < words.length; i++){
            System.out.println(words[i].length());
            if(words[i].length() > count){
                max = words[i];
                count = words[i].length();
            }
        }
        System.out.println(max);
    }

    @Test
    public void findLongestStringWithStream() {
        String[] words = {"cat", "elephant", "dog"};
        String res = Arrays.stream(words).max((s1, s2)-> Integer.compare(s1.length(), s2.length())).get();
        String longestStr = Arrays.stream(words).max(Comparator.comparingInt(String::length)).orElse("NotFound");
        System.out.println(longestStr);
    }

    @Test
    public void removeEmptyOrBlankString() {
        String[] words = {"apple", "", " ", "banana"};

    }
}
