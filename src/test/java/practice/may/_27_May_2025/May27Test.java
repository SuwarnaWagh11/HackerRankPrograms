package practice.may._27_May_2025;

import org.junit.jupiter.api.Test;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
/*Stream is a sequence of elements that supports functional-style operations to process data. It is part of the java.util.stream package introduced in Java 8
 How Streams Work – Three-Step Process
Source – Where the data comes from (e.g., collection, array, I/O).
Intermediate Operations – Transform the data (lazy operations like map, filter, sorted).
Terminal Operation – Produces the result (e.g., collect, forEach, count, reduce).

IntStream - It is used to handle primitive int values efficiently
* Basic Usage:
*   range(0,9) - Used to define integer range starts from 0 till 8
*   rangeClosed(0, 9) - starts from 0 till 9
*   IntStream.of(int .. values) - used to convert int[] to intStream. Once converted, then we can get min(), max(), sum() etc.
*   iterate(1, n -> n + 2).limit(5) -> we can generate any numbers until given limit and iterate. o/p -> 13579
*   you can filter map and print/collect given intstream
*   summaryStatistics() - you can find the statistics of the given integers/int[] -> avg(), sum()
*   practice questions -> reverse the string */
public class May27Test {

    /*Iterating over the numbers*/
    @Test
    public void practiceIterationOverNumber1() {
        IntStream.range(0,9).forEach(System.out::print);
        IntStream.rangeClosed(0,9).forEach(System.out::print);
    }

    /*Iterating over the Integer Array*/
    @Test
    public void practiceIterationOverArrayOfInteger() {
        int[] num = {1,4,6,8,9};
        IntStream.of(num).forEach(System.out::print);
        int min = IntStream.of(num).min().getAsInt();
        System.out.println("\n"+min);
        int sum = IntStream.of(num).sum();
        System.out.println("\n"+sum);
    }
    /*Generating the sequence*/
    @Test
    public void practiceGeneratingSequence(){
        IntStream.iterate(0, n -> n + 2).limit(5).forEach(System.out::print);
        IntStream.iterate(1, n -> n + 2).limit(5).forEach(System.out::print);
    }

    /*You will take 0,10 numbers, filter even, and return the square of each even number*/
    @Test
    public void practiceFilteringAndMapping(){
        IntStream.range(0, 10)
                .filter(n -> n % 2 == 0)
                .mapToObj(n -> n * n)
                .forEach(System.out::println);
    }

    /*You will take int[] numbers, filter even, and return the square of each even number*/
    @Test
    public void practiceFilteringAndMappingForInyArray(){
        int[] num = {1,2,3,4,5,6,7,8,9,10};
        IntStream.of(num).filter(n -> n % 2 == 0).mapToObj( n -> n * n).forEach(System.out::println);
    }

    /*You will take 0,10 numbers,try finding diff stats*/
    @Test
    public void practiceSummaryStats(){
        int[] num = {1,2,3,4,5};
        IntSummaryStatistics stats = IntStream.of(num).summaryStatistics();
        System.out.println(stats.getAverage());
        System.out.println(stats.getSum());
    }

    /*Take list of integer and convert it in array*/
    @Test
    public void practiceConversionExample(){
        List<Integer> list = List.of(1, 3, 4, 5);
        IntStream intStr = list.stream().mapToInt(Integer::intValue);
    }
    /*Reverse the string*/
    @Test
    public void practiceForString1() {

        String name = "Suwarna";
        String str1 = "Suwarna";
        IntStream.range(0, name.length()).forEach(System.out::print); //0123456
        String list = IntStream.range(0, name.length())
                .mapToObj(i -> String.valueOf(name.charAt(name.length() - i - 1)))
                .collect(Collectors.joining());
        System.out.println(list);
    }
}
