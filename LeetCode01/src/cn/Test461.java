package cn;

import org.junit.Test;

/**
 * 汉明距离
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 */
public class Test461 {
    public int hammingDistance1(int x, int y) {
        String strX = Integer.toBinaryString(x);
        String strY = Integer.toBinaryString(y);
        System.out.println(strX);
        System.out.println(strY);
        int count = 0;
        int i, j;
        for (i = strX.length() - 1, j = strY.length() - 1; i >= 0 && j >= 0; i--, j--) {
            count += strX.charAt(i) == strY.charAt(j) ? 0 : 1;
        }
        while(i >= 0) {
            count += strX.charAt(i) == '1' ? 1 : 0;
            i--;
        }
        while (j >= 0) {
            count += strY.charAt(j) == '1' ? 1 : 0;
            j--;
        }
        return count;

    }

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x^y);

    }
    @Test
    public void test() {
        System.out.println(hammingDistance(4, 1));
    }
}
