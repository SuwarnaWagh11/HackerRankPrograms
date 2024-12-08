package arrayprogram;
/*Program to find the minimum (or maximum) element of an array
  Find the largest three distinct elements in an array
 */

import org.bouncycastle.mime.CanonicalOutputStream;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Task210923 {
    public static void main(String[] args) {
        //solution1 :: time complexity- O(n log(n))
        int[] a ={1,423,6,46,34,23,13,53,4};
        findMinAndMaxInt(a);
        findLargest3DistinctEle(a);
        Collections co;
        Collection c;
    }

    private static void findLargest3DistinctEle(int[] a) {
        int first = 0, secnd = 0, third = 0;

    }

    private static void findMinAndMaxInt(int[] a) {
        Arrays.sort(a);
        System.out.println(a[0] +" & " + a[a.length-1]);
        List<Integer> ls = Arrays.stream(a).boxed().toList();
        //System.out.println(ls);
    }
}
