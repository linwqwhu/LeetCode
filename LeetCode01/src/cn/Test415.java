package cn;

import org.junit.Test;

/**
 * 字符串相加
 */
public class Test415 {
    public String addStrings1(String num1, String num2) {
        if (num1.length() == 0) {
            return num2;
        }
        if (num2.length() == 0) {
            return num1;
        }
        StringBuilder sb = new StringBuilder();
        num1 = sb.append(num1).reverse().toString();
        sb.delete(0, num1.length());

        num2 = sb.append(num2).reverse().toString();
        sb.delete(0, num2.length());

        int k = 0;
        int carry = 0;
        int num;
        while (k < num1.length() && k < num2.length()) {
            num = charToInt(num1.charAt(k)) + charToInt(num2.charAt(k)) + carry;
            carry = num / 10;
            sb.append(num % 10);
            k++;
        }
        while (k < num1.length()) {
            num = charToInt(num1.charAt(k)) + carry;
            carry = num / 10;
            sb.append(num % 10);
            k++;
        }
        while (k < num2.length()) {
            num = charToInt(num2.charAt(k)) + carry;
            carry = num / 10;
            sb.append(num % 10);
            k++;
        }
        if (carry == 1) {
            sb.append("1");
        }


        return sb.reverse().toString();
    }

    private static long stringToInt(String s) {
        long sum = 0;
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            sum = sum * 10 + charToInt(ch);
        }
        return sum;
    }

    private static int charToInt(char ch) {
        switch (ch) {
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            default:
                return 0;
        }
    }

    @Test
    public void t() {
        String num1 = "1111111111111111111111111";
        String num2 = "2222222222222222222222222";
        String num3 = "3333333333333333333333333";

        System.out.println(addStrings(num1, num2));
    }

    public String addStrings(String num1, String num2) {
        if (num1.length() == 0) {
            return num2;
        }
        if (num2.length() == 0) {
            return num1;
        }
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int n = i >= 0 ? num1.charAt(i) - '0' : 0;
            int m = j >= 0 ? num2.charAt(j) - '0' : 0;
            int temp = m + n + carry;
            carry = temp / 10;
            sb.append(temp % 10);
            i--;
            j--;
        }
        if (carry == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
