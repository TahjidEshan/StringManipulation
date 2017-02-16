/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package stringcode;

/**
 *
 * @author Eshan
 */
public class StringCode {

    public static String blowUp(String str) {
        int length = str.length();
        String result = "";
        for (int i = 0; i < length; i++) {
            char m = str.charAt(i);
            int ascii = (int) m;
            if (ascii > 47 && ascii < 58) {
                if (i != (length - 1)) {
                    char v = str.charAt(i);
                    int val = (int) v - 48;
                    for (int j = 0; j < val; j++) {
                        result = result + str.charAt(i + 1);
                    }
                }
            } else {
                result = result + str.charAt(i);
            }
        }
        return result;
    }


    public static int maxRun(String str) {
        int run = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            int temp = 1;
            if (str.charAt(i) == str.charAt(i + 1)) {
                int m = i + 1;
                temp++;
                while (m < (str.length() - 1)) {
                    if (str.charAt(m) == str.charAt(m + 1)) {
                        temp++;
                        m++;
                        i++;
                    } else {
                        break;
                    }
                }
            }
            if (temp > run) {
                run = temp;
            }
        }
        return run;
    }


    public static void main(String[] args) {
        System.out.println(blowUp("a4tx2z"));
        System.out.println(blowUp("12x"));
        System.out.println(maxRun("xyyyzzzz"));
    }
}
