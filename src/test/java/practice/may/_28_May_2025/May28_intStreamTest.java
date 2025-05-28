package practice.may._28_May_2025;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class May28_intStreamTest {
    @Test
    public void sumOfAllIntegersInArray(){
        int[] arr = {1, 2, 3, 4};
        int sm = IntStream.of(arr).sum();
        System.out.println(sm);
    }

    @Test
    public void countEvenNumbers(){
        int[] arr = {1, 2, 3, 4, 5, 6};
        long res = IntStream.range(0, arr.length)
                .filter(i -> i % 2 == 0)
                .count();
        System.out.println(res);

        int[] arr1 = {1, 2, 3, 4, 5, 6};
        long res1 = IntStream.of(arr1)
                .filter(i -> i % 2 == 0)
                .count();
        System.out.println(res1);
    }
    @Test
    public void findMaxandMin(){
        int[] arr = {10, 20, 5, 7, 30};
        int min = IntStream.of(arr).min().getAsInt();
        int max = IntStream.of(arr).max().getAsInt();
        System.out.println("Min = " + min + "\n Max = "+ max);
    }

    @Test
    public void squareEachElement(){
        int[] arr = {1, 2, 3};
        List<Integer> res = IntStream.of(arr).mapToObj(i -> i * i).collect(Collectors.toList());
        System.out.println(res);
    }

    @Test
    public void getDistinctEvenNumbers(){
        int[] arr = {2, 4, 6, 2, 4, 8, 5, 9};
        IntStream.of(arr).filter(i -> i % 2 == 0).distinct().forEach(System.out::println);
        int[] res = Arrays.stream(arr).filter(i -> i % 2 == 0).distinct().toArray();
        System.out.println(Arrays.toString(res));
    }

    @Test
    public void sortInDescendingOrder(){
        int[] arr = {3, 1, 4, 2};
        List<Integer> res = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(res);
    }

    @Test
    public void findAvgOfNumbers() {
        int[] arr = {10, 20, 30, 40};
        Double avg = Arrays.stream(arr).average().orElse(0.0);
        System.out.println(avg);
    }

    @Test
    public void filterNumberDivisibleBy3() {
        int[] arr = {3, 6, 7, 9, 10};
        List<Integer> res = Arrays.stream(arr).boxed().filter(i -> i % 3 == 0).collect(Collectors.toList());
        System.out.println(res);
    }
}
