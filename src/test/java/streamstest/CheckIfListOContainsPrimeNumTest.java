package streamstest;

import com.google.common.math.IntMath;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CheckIfListOContainsPrimeNumTest {

    @Test
    public void test121() {
        List<Integer> list = Arrays.asList(2,5,4,3,6,8,10,13,17,19,20,22,37);
        System.out.println(list);
        //List<Integer> primes = list.stream().filter(e -> isPrime(e)).toList();
        List<Integer> primes = Optional.ofNullable(list).orElse(list).stream()
                .filter(IntMath::isPrime)
                .toList();
        System.out.println(primes);
    }

}
