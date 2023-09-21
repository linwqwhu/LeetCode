package cn;

import org.junit.Test;

import java.util.Arrays;

/**
 * 罗马数字转整数
 */
public class Test13 {
    public int romanToInt(String s) {

        s = s.replace("IV", "a");//4
        s = s.replace("IX", "b");//9
        s = s.replace("XL", "c");//40
        s = s.replace("XC", "d");//90
        s = s.replace("CD", "e");//400
        s = s.replace("CM", "f");//900

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += getValue(s.charAt(i));
        }
        return sum;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            case 'a':
                return 4;
            case 'b':
                return 9;
            case 'c':
                return 40;
            case 'd':
                return 90;
            case 'e':
                return 400;
            case 'f':
                return 900;
            default:
                return 0;
        }
    }

    @Test
    public void t() {

        String str = "MCMXCIV";
        System.out.println(romanToInt(str));
    }

}
