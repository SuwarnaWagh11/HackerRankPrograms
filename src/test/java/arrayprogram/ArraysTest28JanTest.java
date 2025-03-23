package arrayprogram;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArraysTest28JanTest {
    @Test
    public void test11() {
        int[] nums = {2,4,3,2,9,6,7,8,9};
        int[] nums1 = {1,4,3,2,9,6,7,8,9};
        String[] names = {"Suwarna","Randhir","Giri"};
        //Arrays.stream(nums).forEach(System.out::print);
        //List<int[]> convertedIntArrToList = Arrays.asList(nums);//it gives List<int[]> which will print [[I@1175e2db]
        //Stream<Integer> boxedInteger = Arrays.stream(nums).boxed();//it returns java.util.stream.IntPipeline$1@26f0a63f
        //List<Integer> convertedIntToList = Arrays.stream(nums).boxed().collect(Collectors.toList());//[1, 4, 3, 2, 9, 6, 7, 8, 9]
        //Arrays.sort(nums);//this will sort given array - 1,2,3,4,6,7,8,9,9
        //System.out.println(Arrays.binarySearch(nums, 8));//6
        System.out.println(Arrays.compare(nums,nums1));//if first is greater then 1 if not then -1 else 0-Same
        List<String> convertedArrToList = Arrays.asList(names);//[Suwarna, Randhir, Giri]
    }

    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+",");
        }
    }
}
