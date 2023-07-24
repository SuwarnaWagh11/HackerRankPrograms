package StringsProgram;

import java.util.Scanner;

/*IP address is a string in the form "A.B.C.D", where the value of A, B, C, and D may range from 0 to 255.
Leading zeros are allowed. The length of A, B, C, or D can't be greater than 3.
valid :
000.12.12.034
121.234.12.12
23.45.12.56
249.255.01.254
invalid
000.12.234.23.23
666.666.23.23
.213.123.23.32
23.45.22.32.
I.Am.not.an.ip

/*IP address is a string in the form "A.B.C.D", where the value of
A, B, C, and D may range from 0 to 255.
Leading zeros are allowed. The length of A, B, C, or D can't be greater than 3.
*/

class MyRegex {
    // A.B.C.D
    // 000 - 199 -> [01]?[0123456789][0123456789] or
    // 200 - 249 -> [2][01234][0123456789] or
    // 250 - 255 -> [2][5][012345]
    String range1 = "([01]?[0-9][0-9]?";
    String range2 = "|2[0-4][0-9]";
    String range3 = "|25[0-5])";
    String A = range1.concat(range2).concat(range3); // 0 - 255
    final String pattern = A + '.' + A + '.' + A + '.' + A;
}
class PatternToValidateIPAddress {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //while (in.hasNext()) {
            String IP = "249.255.01.256";
            System.out.println(IP.matches(new MyRegex().pattern));
        //}

    }
}

