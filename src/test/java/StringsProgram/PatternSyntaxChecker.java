package StringsProgram;

import java.util.Scanner;
import java.util.regex.Pattern;

/*Sample Input
3
([A-Z])(.+)
[AZ[a-z](a-z)
batcatpat(nat
Sample Output

Valid
Invalid
Invalid
Note: In this problem, a regex is only valid if you can compile it using the Pattern.compile method.*/
public class PatternSyntaxChecker {
    public static void main(String[] args) {
/*        ([A-Z])(.+)
        [AZ[a-z](a-z)
        batcatpat(nat*/
        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        while(N > 0){
            String pattern = sc.nextLine();

            try{
                Pattern.compile(pattern);
                System.out.println("Valid");

            } catch (Exception e){
                System.out.println("Invalid");
            }

            N--;
        }

        sc.close();
    }
}
