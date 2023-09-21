package com.linwqwhu;

import org.junit.Test;

/**
 * 2596.检查骑士巡视方案
 */
public class Test2596 {
    public boolean checkValidGrid(int[][] grid) {

        if (grid[0][0] != 0)
            return false;
        int len = grid.length;

        for (int i = 0, j = 0, n = 0; n < len * len - 1; ) {
            int num = grid[i][j];
            //检查（i,j）的八个方向
            int[][] moves = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
            for (int[] move : moves) {
                int x = i + move[0];
                int y = j + move[1];
                if (x >= 0 && x < len && y >= 0 && y < len && grid[x][y] == num + 1) {
                    i = x;
                    j = y;
                    break;
                }
            }
            n++;
            if (grid[i][j] != num + 1)
                return false;
        }
        return true;
    }

    @Test
    public void testCheckValidGrid() {
        int[][] grid = {{0, 11, 16, 5, 20}, {17, 4, 19, 10, 15}, {12, 1, 8, 21, 6}, {3, 18, 23, 14, 9}, {24, 13, 2, 7, 22}};
        boolean res = checkValidGrid(grid);
        System.out.println(res);
    }
}
