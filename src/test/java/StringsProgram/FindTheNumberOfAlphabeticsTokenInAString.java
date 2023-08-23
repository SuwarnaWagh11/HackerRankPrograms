package StringsProgram;

import java.util.Arrays;
import java.util.List;

/*Sample Input -- > He is a very very good boy, isn't he?
Sample Output -->
10
He
is
a
very
very
good
boy
isn
t
he
Note: You may find the String.split method helpful in completing this challenge.*/
public class FindTheNumberOfAlphabeticsTokenInAString {
    public static void main(String[] args) {
        String s = "    He is a very very good boy, isn't he    ";
        if(!s.isBlank()){
            s = s.trim();
            String[] tokens = s.split("[.,'?_! @]+");
            List<String> list = Arrays.asList(tokens);
            System.out.println(list.size());
            list.stream().forEach(System.out::println);
        }else{
            System.out.println(0);
        }

    }
}
