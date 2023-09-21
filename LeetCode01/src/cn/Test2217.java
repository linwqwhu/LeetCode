package cn;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * 找到指定长度的回文数
 */
public class Test2217 {
    /**
     * 枚举（超时）
     *
     * @param queries
     * @param intLength
     * @return
     */
    public long[] kthPalindrome1(int[] queries, int intLength) {
        List list = new ArrayList<Long>();
        Double min = Math.pow(10, intLength - 1);
        Double max = Math.pow(10, intLength);
        for (Long num = min.longValue(); num < max.longValue(); num++) {
            if (num % 10 == 0) {
                continue;
            }
            char[] chs = String.valueOf(num).toCharArray();
            int i = 0;
            for (; i < intLength / 2; i++) {
                if (chs[i] != chs[intLength - 1 - i]) {
                    break;
                }
            }
            if (i >= intLength / 2) {
                list.add(num);
            }
        }

        long[] results = new long[queries.length];
        for (int j = 0; j < queries.length; j++) {
            if (queries[j] <= list.size()) {
                results[j] = (Long) list.get(queries[j] - 1);
            } else {
                results[j] = Long.valueOf(-1);
            }
        }
        return results;
    }

    @Test
    public void t() {
        int[] q = {965598625, 198268812, 541725641, 18, 9, 446798683, 343077910, 26, 31};
        int intLength = 8;
        long[] longs = kthPalindrome(q, intLength);
        System.out.println();

    }

    public long[] kthPalindrome(int[] queries, int intLength) {
        long min = ((Double) Math.pow(10, (intLength + 1) / 2 - 1)).longValue();
        long max = ((Double) Math.pow(10, (intLength + 1) / 2)).longValue() - 1;
        long[] res = new long[queries.length];
        for (int i = 0; i < intLength / 2; i++) {
            long num = min + queries[i] - 1;
            if (num > max) {
                res[i] = -1;
            } else {
                StringBuilder first = new StringBuilder(String.valueOf(num));
                String second;
                if (intLength % 2 == 0) {
                    second = first.reverse().toString();
                } else {
                    second = first.reverse().toString().substring(1, first.length());
                }
                res[i] = Long.valueOf(first.reverse().toString() + second);
            }
        }
        return res;
    }

    @Test
    public void t2() {
        StringBuilder first = new StringBuilder(String.valueOf(1200));
        String second = first.reverse().toString().substring(1, first.length());
        System.out.println(first);
        System.out.println(first.toString()+second);
    }
}
