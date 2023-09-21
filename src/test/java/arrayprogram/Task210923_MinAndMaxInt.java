package arrayprogram;
//Program to find the minimum (or maximum) element of an array

import java.util.Arrays;
import java.util.List;

public class Task210923_MinAndMaxInt {
    public static void main(String[] args) {
        //solution1 :: time complexity- O(n log(n))
        int[] a ={1,423,6,46,34,23,13,53,4};
        Arrays.sort(a);
        System.out.println(a[0] +" & " +a[a.length-1]);
        List<Integer> ls = Arrays.stream(a).boxed().toList();
        System.out.println(ls);
    }
}
