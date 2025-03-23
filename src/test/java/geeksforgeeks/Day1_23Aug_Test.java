package geeksforgeeks;

import org.junit.jupiter.api.Test;

import java.util.Scanner;
/*
https://www.geeksforgeeks.org/java-programming-examples/

*/
public class Day1_23Aug_Test {
    //@Test
    public void test11() {
        readNumUsingScanner();
        multiplyTwoFloatingPoints();// O(1) it is doing constant operations
        swapTwoNumber(20,30);
        swapTwoNumberWithTwoOperator(20,30);
        addTwoBinaryString("110","011");
        maxValueFromThreeInteger(223,45,331);
    }

    private static void maxValueFromThreeInteger(int a, int b, int c) {
        if(a > b){
            if(a > c){
                System.out.println(a + " is max");
            }
            else{
                System.out.println(c + " is max");
            }
        }else{
            if(b > c){
                System.out.println(b + "is max");
            }else{
                System.out.println(c + " is max");
            }
        }
    }

    private static void addTwoBinaryString(String m,String n) {
        int s = Integer.parseInt(m);
        int t = Integer.parseInt(n);
        int sum = s + t ;
        String final1 = Integer.toBinaryString(sum);
        System.out.println(final1);
    }

    private static void swapTwoNumberWithTwoOperator(int m, int n) {
        System.out.println(m +"is before swapping "+ n);
        m = m ^ n;
        n = m ^ n;
        m = m ^ n;
        System.out.println(m +"is after swapping "+ n);
    }

    private static void swapTwoNumber(int i, int i1) {
        System.out.println(i +"is before swapping "+ i1);
        i = i + i1;
        i1 = i - i1;
        i = i - i1;
        System.out.println(i +"is after swapping "+ i1);
    }

    private static void multiplyTwoFloatingPoints() {
        float f1= 20.01222f;
        float f2 = 30.0002545445f;
        System.out.println(f1 * f2);
    }

    private static void readNumUsingScanner() {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(num);
    }
}
