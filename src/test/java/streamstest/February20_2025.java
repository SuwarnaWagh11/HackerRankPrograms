package streamstest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class February20_2025 {

    public static void main(String[] args) {
        findDuplicateFromStream();

    }
    public static void findDuplicateFromStream(){
        Stream<Integer> strm = Stream.of(1, 4, 3, 5, 2, 4, 2, 5);
        HashSet<Integer> st = new HashSet<>();
        Set<Integer> duplicate = strm.filter(n -> !st.add(n)).collect(Collectors.toSet());
        System.out.println(duplicate);
    }
}
