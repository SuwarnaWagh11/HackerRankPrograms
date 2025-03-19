package _19_March_2025;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class ManualTest {

    @Test
    public void calculateTheStringLengthWithoutUsingLengthFunction(){
        String input = "suwarna";
        int cnt = 0;
        for(char c: input.toCharArray()){
            cnt ++;
        }
        System.out.println(cnt);

        int count = 0;
        try{
            while(true){
                input.substring(count, count+1);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e){
            System.out.println("Here is the count after exception ->  "+count);
        }
    }
    @Test
    public void convertUpperCaseToLowercaseOrViceVersa(){
        String input = "SuwarnA MaRuTi WaGh";
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) >= 'A' && input.charAt(i) <= 'Z'){
                res.append((char) (input.charAt(i) + 32));
            }else if(input.charAt(i) >= 'a' && input.charAt(i) <= 'z'){
                res.append((char) (input.charAt(i) - 32));
            }else{
                res.append(input.charAt(i));
            }
        }
        System.out.println(res);
    }
    @Test
    public void vowelCount(){
        String input = "suwarnaMarutiWAGH";
        HashSet<Character> vowSet = new HashSet<>();
        HashSet<Character> constSet = new HashSet<>();
        String ref = "aeiouAEIOU";
        for (int i = 0; i < input.length(); i++) {
            if((input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') || (input.charAt(i) >= 'a' && input.charAt(i) <= 'z')){
               if(ref.indexOf(input.charAt(i)) != -1){
                    vowSet.add(input.charAt(i));
               }else {
                   constSet.add(input.charAt(i));
               }
            }
        }
        System.out.println("Vowels count is "+ vowSet.size());
        System.out.println("Constants count is "+ constSet.size());
    }
    @Test
    public void palindromeVerification(){
        String input = "madam";
        String reverse = "";
        for (int i = input.length() - 1; i >= 0 ; i--) {
            reverse = reverse + input.charAt(i);
        }
        System.out.println(reverse);
        if (input.equals(reverse)) {
            System.out.println("String is Palindrome");
        } else {
            System.out.println("String is NOT Palindrome");
        }
    }

    @Test
    public void reverseTheGivenString(){
        String name = "Hello";
        for (int i = name.length() - 1; i >= 0; i--) {
            System.out.print(name.charAt(i));
        }
        System.out.println();
        String input = "Hello World, I am Suwarna.";
        char[] arr = input.toCharArray();
        for (int i = arr.length - 1; i >= 0 ; i--) {
            System.out.print(arr[i]);
        }
    }
}
