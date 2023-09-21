package com.linwqwhu;

/**
 * 661.图片平滑器
 */
public class Test661 {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] res = new int[m][n];
        int[][] moves = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int k = 0;
                for (int[] move : moves) {
                    int x = i + move[0];
                    int y = j + move[1];
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        res[i][j] += img[x][y];
                        k++;
                    }
                }
                if (k != 0)
                    res[i][j] /= k;
            }
        }

        return res;
    }
}
