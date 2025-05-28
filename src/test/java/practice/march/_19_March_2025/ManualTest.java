package practice.march._19_March_2025;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManualTest {

    @Test
    public void checkIfTwoStringsAreRotationsOfEachOther(){
        String input1 = "abcde";
        String input2 = "abedc";
        char[] arr1 = input1.toCharArray();
        char[] arr2 = input2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        boolean flag = Arrays.equals(arr1, arr2);
        if(flag){
            System.out.println("Both String are rotation of each other");
        }else {
            System.out.println("Both String are NOT rotation of each other");
        }
    }

    @Test
    public void checkIfStringIsValidEmailAddress() {
        String emailID = "@@suwarna.123@gmail.com";
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if(emailID.matches(emailRegex)){
            System.out.println("A valid email");
        }else{
            System.out.println("Not valid email");
        }
    }

    @Test
    public void checkIfStringContainOnlyDigit() {
        String name = "11122334";
        if (name.isEmpty()) return;
        for(char n : name.toCharArray()){
            if(!Character.isDigit(n)){
                System.out.println("Not only digit");
                return;
            }

        }
        System.out.println("String contains only digit");
    }

    @Test
    public void reverseEachWordInString() {
        String input = "Java is fun";
        String[] arr = input.split("\\s+");
        StringBuilder sb= new StringBuilder();
        for(String str : arr){
            sb.append(new StringBuilder(str).reverse().append(" "));
        }
        assertEquals("avaJ si nuf", sb.toString().trim());
    }

    @Test
    public void countNumberOfWordsInTheString() {
        String input = "Hey, This is note of 10 rupees.";
        String newInput = input.replaceAll("[^a-zA-Z ]","");
        System.out.println(newInput);
        String[] arr = newInput.split("\\s+"); //handle multiple spaces
        System.out.println("Word count = "+ arr.length);
        assertEquals(6, arr.length);
    }
    @Test
    public void countNumberOfUniqueCharactersInTheString() {
        String input = "Hey, This is note of 10 rupees.";
        String newInput = input.replaceAll("[0-9.,'&* ]+","").toLowerCase();
        System.out.println(newInput);
        Set<Character> set = new LinkedHashSet<>();
        for(char c: newInput.toCharArray()){
            set.add(c);
        }
        System.out.println("Number of characters in string is : "+set.size());
    }

    @Test
    public void maxOccurrenceOfCharTheString() {
        String input = "SuwarnaMarutiWagh";
        Map.Entry<Character, Long> map = input.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);
        System.out.println("Max occurrence of character - "+map);
    }
    @Test
    public void removeDuplicatesFromTheString(){
        String input = "SuwarnaMarutiWagh";
        String output = input.chars().mapToObj(c->(char)c)
                .distinct()
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println(output);
    }
    @Test
    public void checkIfStringIsAnagram(){
        String str1 = "silentn";
        String str2 = "listean";
        if(str2.length() != str1.length()){
            System.out.println("Not Anagram");
            return;
        }
        char[] a1 = str1.toCharArray();
        char[] a2 = str2.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);

        if(Arrays.equals(a1,a2)){
            System.out.println("Is anagram");
        }else {
        System.out.println("Not Anagram");}
    }
    @Test
    public void swapTheFirstAndLastCharOfString(){
        String input = "suwarnamaruti";
        String output = input.charAt(input.length()-1)
                + input.substring(1, input.length())
                + input.charAt(0);
        System.out.println(output);
    }

    @Test
    public void findFrequesncyOfEachCharacterInString(){
        String input = "how are howai in area";
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = input.toCharArray();
        for(char c: arr){
            if( c !=' '){
                map.put(c, map.getOrDefault(c, 0)+1);
            }
        }
        System.out.println(map);

    }
    @Test
    public void findFirstNonRepeatingCharInTheWord(){
        String input = "how are howai in area";
        Map<Character, Integer> map = new LinkedHashMap<>();
        char[] a = input.toLowerCase().toCharArray();
        for(char c: a){
            if(c != ' '){
                map.put(c, map.getOrDefault(c, 0)+1);
            }
        }
        System.out.println(map);
        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            if(entry.getValue() == 1){
                System.out.println("This is the first non repeating word - "+ entry.getKey());
                return;
            }
        }
        System.out.println("There is no repeating word in the given string");
    }
    @Test
    public void replaceAllVowelWithStar(){
        String input = "My Name Is Suwarna";
        System.out.println(input.replaceAll("[aeiouAEIOU]", "*"));
    }

    @Test
    public void removeSpacesFromTheString(){
        String input = "  Suwarna       Maruti Wagh ";
        System.out.println(input.replace(" ",""));
        char[] in = input.toCharArray();
        int j = 0;
        for(int i = 0; i < in.length; i++){
            if(in[i] != ' '){
                in[j++] = in[i];
            }
        }
        String op = new String(in, 0, j);
        System.out.println(op);
    }

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
