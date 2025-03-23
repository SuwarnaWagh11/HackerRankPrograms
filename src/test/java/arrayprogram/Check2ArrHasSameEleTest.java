package arrayprogram;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Check2ArrHasSameEleTest {
    @Test
    public void test115() {
        Integer[] arr1 = {1,2,5,3,4,2,9};
        Integer[] arr2 = {1,3,2,4,5,1,8};
        int[] arr3 = {1,3,2,4,5,1,8};
        Arrays.stream(arr3).boxed().toList();
        System.out.println(checkIfSimilarArray(arr1, arr2));
        System.out.println(reverseString("suwarna"));
        System.out.println(reverseStringWithoutInBuiltFun("maruti"));
        swapNumWithoutUsing3rdVar(13,15);

    }

    private static void swapNumWithoutUsing3rdVar(int i, int i1) {
        System.out.println("before swapping swapNumWithoutUsing3rdVar("+i+" , "+i1+")");
        i = i + i1;
        i1 = i - i1;
        i = i - i1;
        System.out.println("after swapping swapNumWithoutUsing3rdVar("+i+" , "+i1+")");
    }

    private static String reverseStringWithoutInBuiltFun(String maruti) {
        String newStr = "";
        for(int i = maruti.length() - 1; i>= 0 ; i--){
            newStr = newStr + maruti.charAt(i);
        }
        return newStr;
    }

    private static StringBuilder reverseString(String suwarna) {
        StringBuffer sb = null;
        StringBuilder builder = new StringBuilder(suwarna);
        return builder.reverse();
    }

    private static boolean checkIfSimilarArray(Integer[] arr1, Integer[] arr2) {
        Set<Integer> s1 = new HashSet<>(List.of(arr1));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(arr2));

        if(s1.size() != s2.size())
            return false;

        for(Integer i: s1){
            if(!s2.contains(i))
                return false;
        }
        return true;
    }
}
