package com.linwqwhu;

import javax.print.attribute.standard.MediaSize;
import java.util.*;

/**
 * 1162.地图分析
 */
public class Test1162 {
    public int maxDistance(int[][] grid) {
        int maxDistance = -1;
        int[][] distance = new int[grid.length][grid[0].length];
        Deque<int[]> next = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                distance[i][j] = -1;
                if (grid[i][j] == 1) {
                    next.offer(new int[]{i, j});
                    distance[i][j] = 0;
                }
            }
        }

        while (!next.isEmpty()) {
            int[] nums = next.poll();
            int i = nums[0];
            int j = nums[1];
            //上下左右
            if (i > 0 && distance[i - 1][j] == -1) {
                distance[i - 1][j] = distance[i][j] + 1;
                next.offer(new int[]{i - 1, j});
            }
            if (i < grid.length - 1 && distance[i + 1][j] == -1) {
                distance[i + 1][j] = distance[i][j] + 1;
                next.offer(new int[]{i + 1, j});
            }
            if (j > 0 && distance[i][j - 1] == -1) {
                distance[i][j - 1] = distance[i][j] + 1;
                next.offer(new int[]{i, j - 1});
            }
            if (j < grid[0].length - 1 && distance[i][j + 1] == -1) {
                distance[i][j + 1] = distance[i][j] + 1;
                next.offer(new int[]{i, j + 1});
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (maxDistance < distance[i][j]) {
                    maxDistance = distance[i][j];
                }
            }
        }

        return maxDistance == 0 ? -1 : maxDistance;
    }
}
