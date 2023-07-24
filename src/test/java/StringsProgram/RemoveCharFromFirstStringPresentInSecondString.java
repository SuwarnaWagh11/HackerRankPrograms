package StringsProgram;

public class RemoveCharFromFirstStringPresentInSecondString {
    public static void main(String[] args) {
        String string1 = "suwarna";
        String string2 = "randhir";
        String res = "";
        //o/p-> res = suw
        System.out.println(removeChars(string1, string2));
    }

    public static String removeChars(String string1, String string2) {
        // we extract every character of string string 2
        for (int index = 0; index < string2.length();
             index++) {
            char i = string2.charAt(index);
            // we find char exit or not
            while (string1.contains(i + "")) {
                //int itr = string1.indexOf(i);
                // if char exit we simply remove that char
                string1 = string1.replace((i + ""), "");
            }
        }
        return string1;
    }
}
