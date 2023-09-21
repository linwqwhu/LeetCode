package com.linwqwhu;

import org.junit.Test;

import java.security.Key;
import java.util.Arrays;

/**
 * 552.学生出勤经历
 * 动态规划
 */
public class Test552 {

    public int checkRecord(int n) {

        int mod = (int) 1e9 + 7;
        //dp[i][j][k]表示前i天中有j个A，结尾中有k个L
        int[][][] dp = new int[n + 1][2][3];
        dp[0][0][0] = 1;
        for (int i = 1; i <= n; i++) {
            //以p结尾
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++)
                    dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j][k]) % mod;
            }
            //以A结尾
            for (int k = 0; k < 3; k++) {
                dp[i][1][0] = (dp[i][1][0] + dp[i - 1][0][k]) % mod;
            }
            //以L结尾
            for (int k = 1; k < 3; k++) {
                for (int j = 0; j < 2; j++) {
                    dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k - 1]);
                }
            }
        }

        int res = 0;
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 3; k++) {
                res = (res + dp[n][j][k]) % mod;
            }
        }
        return res;
    }

    @Test
    public void testCheckRecord() {
        int i = checkRecord(2);
        System.out.println(i);
    }

    public int checkRecord2(int n) {

        int mod = (int) 1e9 + 7;
        //dp[i][j][k]表示前i天中有j个A，结尾中有k个L
        int[][] dp = new int[2][3];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int[][] dpNew = new int[2][3];
            //以p结尾
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++)
                    dpNew[j][0] = (dpNew[j][0] + dp[j][k]) % mod;
            }
            //以A结尾
            for (int k = 0; k < 3; k++) {
                dpNew[1][0] = (dpNew[1][0] + dp[0][k]) % mod;
            }
            //以L结尾
            for (int k = 1; k < 3; k++) {
                for (int j = 0; j < 2; j++) {
                    dpNew[j][k] = (dpNew[j][k] + dp[j][k - 1]);
                }
            }
            dp = dpNew;
        }

        int res = 0;
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 3; k++) {
                res = (res + dp[j][k]) % mod;
            }
        }
        return res;
    }


    static final int MOD = 1000000007;

    /**
     * 矩阵快速幂
     *
     * @param n
     * @return
     */
    public int checkRecord3(int n) {
        long[][] mat = {
                {1, 1, 0, 1, 0, 0},
                {1, 0, 1, 1, 0, 0},
                {1, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1, 0},
                {0, 0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0, 0}
        };
        long[][] res = pow(mat, n);
        long sum = Arrays.stream(res[0]).sum();
        return (int) (sum % MOD);
    }

    public long[][] pow(long[][] mat, int n) {
        long[][] ret = {{1, 0, 0, 0, 0, 0}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, mat);
            }
            n >>= 1;
            mat = multiply(mat, mat);
        }
        return ret;
    }

    private long[][] multiply(long[][] a, long[][] b) {
        int row = a.length;
        int col = b[0].length;
        int temp = b.length;
        long[][] c = new long[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < temp; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                    c[i][j] %= MOD;
                }
            }
        }
        return c;
    }
}
