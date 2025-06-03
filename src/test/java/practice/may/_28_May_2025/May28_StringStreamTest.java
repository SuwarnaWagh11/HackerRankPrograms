package practice.may._28_May_2025;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class May28_StringStreamTest {

    /*Expected o/p
     [JOHN, DOE]
   */
    @Test
    public void convertAllToUpperCase(){
        String[] names = {"john", "doe"};
        List<String> res = Arrays.stream(names).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(res);
    }
    /*Expected o/p
     1
   */
    @Test
    public void countNameWithLengthGreaterThan3(){
        String[] names = {"Ava", "Bob", "Charlie"};
        long res = Arrays.stream(names).filter(n -> n.length() > 3).count();
        System.out.println(res);
    }
    /*Expected o/p
      [Anna, Liam, Zara]
    */
    @Test
    public void sortNameAlphabetically(){
        String[] names = {"Zara", "Liam", "Anna"};
        List<String> res = Arrays.stream(names).sorted().toList();
        System.out.println(res);
    }
    /*Expected o/p
      Alice,Bob,Anna
    */
    @Test
    public void joinNamesByComma(){
        String[] names = {"Alice", "Bob", "Anna"};
        String res1 = Arrays.stream(names).collect(Collectors.joining(", "));
        String res = String.join(",", names);
        System.out.println(res);
    }
    /*Expected o/p
            elephant
    */
    @Test
    public void findLongestString(){
        String[] words = {"cat", "elephant", "dog"};
        String max = "";
        int count = 0;
        for(int i =0; i < words.length; i++){
            if(words[i].length() > count){
                max = words[i];
                count = words[i].length();
            }
        }
        System.out.println(max);
    }
    /*Expected o/p
        elephant
    */
    @Test
    public void findLongestStringWithStream() {
        String[] words = {"cat", "elephant", "dog"};
        String res = Arrays.stream(words).max((s1, s2)-> Integer.compare(s1.length(), s2.length())).get();
        String longestStr = Arrays.stream(words).max(Comparator.comparingInt(String::length)).orElse("NotFound");
        System.out.println(longestStr);
        String smallest = Arrays.stream(words).min(Comparator.comparingInt(String::length)).orElse("NotFound");
        System.out.println(smallest);
    }
    /*Expected o/p
    [apple, banana]
    */
    @Test
    public void removeEmptyOrBlankString() {
        String[] words = {"apple", "", " ", "banana"};
        List<String> res = Arrays.stream(words)
                .filter(a -> !a.isBlank())
                .collect(Collectors.toList());
        System.out.println(res);
    }
    /*Expected o/p
    [banana, apple]
    */
    @Test
    public void findDuplicateStrings() {
        Set<String> seen = new HashSet<>();
        String[] words = {"apple", "banana", "apple", "orange", "banana"};
        Set<String> res = Arrays.stream(words).filter(s -> !seen.add(s)).collect(Collectors.toSet());
        System.out.println(res);
    }
    /*Expected o/p
    {2=[hi], 3=[hey], 5=[hello, world]}
    */
    @Test
    public void groupStringsByTheirLength() {
        String[] words = {"hi", "hello", "hey", "world"};
        Map<Integer, List<String>> res = Arrays.stream(words).collect(Collectors.groupingBy(String::length));
        System.out.println(res);
    }
}
