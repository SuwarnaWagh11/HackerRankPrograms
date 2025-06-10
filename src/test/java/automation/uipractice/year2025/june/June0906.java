package automation.uipractice.year2025.june;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

public class June0906 {

    /*
     * Find Common Elements Between Two Sets
     * iterate thr each element
     * take new var to store res
     * after checking if element in s1 contains in s2, if yes add, return the result
     * */
    @Test
    public void test09(){
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5, 6));
        Set<Integer> res = new HashSet<>();
        for(Integer temp: set1){
            if (set2.contains(temp)){
                res.add(temp);
            }
        }
        System.out.println(res);
        set2.retainAll(set1);
        System.out.println(set2);
        Set<Integer> res1 = set1.stream().filter(set2::contains).collect(Collectors.toSet());
        System.out.println(res1);
    }

    /*
     * Find All Strings That Start With a Given Letter
     * iterate thr each element
     * take new var to store res
     * after checking ifStrings That Start With a Given Letter, if yes add, return the result
     * */
    @Test
    public void test10(){
        List<String> lst = List.of("apple", "banana", "avocado", "berry", "apricot");
        System.out.println(lst);
        //List<Integer> res = lst.stream().distinct().toList();
        //System.out.println(res);
        List<String> result = new ArrayList<>();
        for(int i = 0; i < lst.size(); i++){
            if(lst.get(i).startsWith("a")){
                result.add(lst.get(i));
            }
        }
        System.out.println(result);

        List<String> res = lst.stream().filter(s -> s.startsWith("a")).toList();
        System.out.println(res);
    }


    /*
    * Remove Duplicates from a List
    * iterate thr each element
    * take new var to store res
    * after checking if new var list contains the element, if not add, return the result
    * */
    @Test
    public void test11(){
        List<Integer> lst = List.of(1, 2, 3, 2, 4, 1, 5);
        System.out.println(lst);
        //List<Integer> res = lst.stream().distinct().toList();
        //System.out.println(res);
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < lst.size(); i++){
            if(!result.contains(lst.get(i))){
                result.add(lst.get(i));
            }
        }
        System.out.println(result);
    }
}
