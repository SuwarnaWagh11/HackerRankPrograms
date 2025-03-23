package streamstest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamIntProgramTest {

    public static StreamIntProgramTest test = new StreamIntProgramTest();
    @Test
    public void test124() {
        int[] nums = new int[]{4,2,3,4,1,5};
        int[] nums1 = new int[]{7,8,9,0,4,3,5,9};
        Integer[] convertedIntToIntegerArray = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        //int[] -> Integer[] ?? Arrays to stream-v to boxed to toArray Integer[]
        Integer[] convertedIntToIntegerArray1 = Arrays.stream(nums1).boxed().toArray(Integer[]::new);
        List<Integer> mergedArray = Stream.of(convertedIntToIntegerArray1, convertedIntToIntegerArray)
                .flatMap(Stream::of)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(mergedArray);

        //test.convertIntArrayToStream(nums);
        //test.convertStringArrayToStream(name);
        //test.primeNumber(nums);

    }
    public void convertIntArrayToStream(int[] nums){
        IntStream sNums = Arrays.stream(nums);  // converted int array in intstreams
        //List<Integer> list1 = sNums.boxed().collect(Collectors.toList()); // converted intstreams to list
        //List list2 = IntStream.range(0,10).boxed().collect(Collectors.toList());
        boolean isEven = IntStream.range(0, 20).boxed().allMatch(p -> p % 2 == 0);
        List<Integer> list3 = sNums.boxed().filter(i -> isEven).collect(Collectors.toList());
        System.out.println(list3);

    }
    public void convertStringArrayToStream(String[] name){
        Stream<String> sName = Arrays.stream(name);
        List<String> list1 = sName.collect(Collectors.toList());
        System.out.println(list1);
    }
    public void primeNumber(int[] nums){
        IntStream sNums = Arrays.stream(nums);
        List<Integer> primes = sNums.boxed().filter(c -> isPrime(c)).collect(Collectors.toList());
        System.out.println(primes);
    }

    private boolean isPrime(int n) {
        return IntStream.range(2,n).noneMatch(i -> n % i == 0);
    }
}
