package StringsProgram;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class GuessTheOpTest {
    @Test
    public void test11() {
/*        int count = 0;
        String s1 = "I am I think an am very smart";
        String[] arr = s1.split(" ");
        for(String s: arr){
            if(s.equals("am")){
                count++;
            }
        }
        System.out.println(count);
        s1 = s1.replaceAll("am", "");
        System.out.println(s1);*/

        String s = "fy67h4s";
        if(!s.isBlank()){
            int sum = 0;
            s = s.trim();
            String[] tokens = s.split("[.,'?_! @]+");
            String replaceDigit = s.replaceAll("\\d","");    //fyhs'@.fd,
            String withoutNumbers = s.replaceAll("[0-9]","");//fyhs'@.fd,
            String withoutChar = s.replaceAll("[a-zA-Z]","");//674'@.,32
            String getNumbers = s.replaceAll("[^0-9]","");//67432 - 22
            String[] s2 = getNumbers.split("");
            int[] val = Arrays.stream(s2).mapToInt(Integer::parseInt).toArray();
            for(int i = 0; i < val.length; i++){
                sum = sum + val[i];
            }
            System.out.println(sum+" is sum ");

            String[] se = s.split("[^0-9]");

            //int[] arr = Arrays.stream(se).mapToInt(Integer::parseInt).toArray();

        }else{
            System.out.println(0);
        }
    }
}







