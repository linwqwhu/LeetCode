package com.linwqwhu;

import java.nio.channels.NonReadableChannelException;
import java.util.ArrayList;
import java.util.List;

/**
 * 54.螺旋矩阵
 */
public class Test54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        int k = 0;
        while (res.size() < m * n) {
            while (res.size() < m * n && j < n - k) {
                res.add(matrix[i][j]);
                j++;
            }
            j--;
            i++;
            while (res.size() < m * n && i < m - k) {
                res.add(matrix[i][j]);
                i++;
            }
            i--;
            j--;
            while (res.size() < m * n && j >= k) {
                res.add(matrix[i][j]);
                j--;
            }
            j++;
            i--;
            while (res.size() < m * n && i > k) {
                res.add(matrix[i][j]);
                i--;
            }
            i++;
            j++;
            k++;
        }
        return res;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        int d = 0, u = matrix.length - 1, l = 0, r = matrix[0].length - 1;
        List<Integer> res = new ArrayList<>();

        while (true) {
            for (int j = l; j <= r; j++)
                res.add(matrix[d][j]);
            if (++d > u)
                break;

            for (int i = d; i <= u; i++)
                res.add(matrix[i][r]);
            if (--r < l)
                break;

            for (int j = r; j >= l; j--)
                res.add(matrix[u][j]);
            if (--u < d)
                break;

            for (int i = u; i >= d; i--)
                res.add(matrix[i][l]);
            if (++l > r)
                break;
        }

        return res;
    }
}
