package com.linwqwhu;

/**
 * 59.螺旋矩阵II
 */
public class Test59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int d = 0, u = n - 1;
        int l = 0, r = n - 1;
        int k = 1;
        while (true) {
            for (int j = l; j <= r; j++) {
                res[d][j] = k;
                k++;
            }
            if (++d > u)
                break;

            for (int i = d; i <= u; i++) {
                res[i][r] = k;
                k++;
            }
            if (--r < l)
                break;

            for (int j = r; j >= l; j--) {
                res[u][j] = k;
                k++;
            }
            if (--u < d)
                break;

            for (int i = u; i >= d; i--) {
                res[i][l] = k;
                k++;
            }
            if (++l > r)
                break;
        }
        return res;
    }
}
