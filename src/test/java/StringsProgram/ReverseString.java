package StringsProgram;

import java.util.Locale;

public class ReverseString {
    public static void main(String[] args) {
        String str1 = "abba";
        String str2 = new String("suwarna");
        String str3 = "suwarnaanrawus";
        String str4 = "suwarnaanrawus";
        String pallindrom = "";
        //switch case with string
        printColorUsingSwitch("GREEN");
        //make String UpperCase& LowerCase
        System.out.println(str1.toUpperCase());
        System.out.println(str1.toLowerCase());
        System.out.println(str1.getBytes());
        //remove the given character from string
        if(str4.contains('a'+"")){
            str4 = str4.replaceAll('a'+"", "");
        }System.out.println(str4 + " is after removing the character");
        //check pallindrom with reverse()
        StringBuilder sb = new StringBuilder(str1);
        sb.reverse();
        if(sb.toString().equals(str1)){
            System.out.println("is pallidrom");
        }
        //check pallindrom without any method
        for(int i = str3.length()-1; i >= 0;i--){
            pallindrom = pallindrom + str3.charAt(i);
        }
        if(pallindrom.equals(str3)) {
            System.out.println(pallindrom + " is pallidrom");
        }
        System.out.println(str1.equals(str2));//true - checks if the content of the object is same
        System.out.println(str1 == str2);//false - it checks if the object points to the same memory location
        System.out.println(str3.equals(str2));
    }

    private static void printColorUsingSwitch(String color) {
        switch (color){
            case "blue":
                System.out.println("found blue");
                break;
            case "red":
                System.out.println("saw red");
                break;
            case "green":
                System.out.println("gorgeous green");
                break;
            default:
                System.out.println("and nothing here");
        }
    }
}
