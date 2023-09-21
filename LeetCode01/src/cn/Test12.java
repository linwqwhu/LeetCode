package cn;

import org.junit.Test;

/**
 * 将整数转换为罗马数字
 */
public class Test12 {

    public String intToRoman1(int num) {
        char[] chs = String.valueOf(num).toCharArray();
        int len = chs.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int m = (Integer.valueOf(chs[i]) - 48) * (int) Math.pow(10, len - 1 - i);

            if (m <= 3) {
                for (int j = 0; j < m; j++) {
                    sb.append("I");
                }
            } else if (m == 4) {
                sb.append("IV");
            } else if (m <= 8) {
                sb.append("V");
                for (int j = 6; j <= m; j++) {
                    sb.append("I");
                }
            } else if (m == 9) {
                sb.append("IX");
            } else if (m <= 30) {
                for (int j = 1; j <= m / 10; j++) {
                    sb.append("X");
                }
            } else if (m == 40) {
                sb.append("XL");
            } else if (m <= 80) {
                sb.append("L");
                for (int j = 6; j <= m / 10; j++) {
                    sb.append("X");
                }
            } else if (m == 90) {
                sb.append("XC");
            } else if (m <= 300) {
                for (int j = 1; j <= m / 100; j++) {
                    sb.append("C");
                }
            } else if (m == 400) {
                sb.append("CD");
            } else if (m <= 800) {
                sb.append("D");
                for (int j = 6; j <= m / 100; j++) {
                    sb.append("C");
                }
            } else if (m == 900) {
                sb.append("CM");
            } else if (m <= 3000) {
                for (int j = 1; j <= m / 1000; j++) {
                    sb.append("M");
                }
            }
        }
        return sb.toString();
    }

    @Test
    public void t() {
        int m = 10;
        System.out.println(intToRoman1(m));
    }

    public String intToRoman2(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                roman.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return roman.toString();
    }

    public String intToRoman(int num) {
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        StringBuilder roman = new StringBuilder();
        roman.append(thousands[num / 1000]);
        roman.append(hundreds[num / 100 % 10]);
        roman.append(tens[num / 10 % 10]);
        roman.append(ones[num % 10]);
        return roman.toString();

    }

}
