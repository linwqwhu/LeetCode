package com.linwqwhu;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 733.图像渲染
 */
public class Test733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if (color == oldColor) {
            return image;
        }
        int m = image.length, n = image[0].length;
        int[][] moves = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{sr, sc});

        boolean[][] visited = new boolean[m][n];
        visited[sr][sc] = true;

        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            visited[position[0]][position[1]] = true;
            image[position[0]][position[1]] = color;
            for (int[] move : moves) {
                int x = position[0] + move[0];
                int y = position[1] + move[1];
                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && image[x][y] == oldColor) {
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return image;
    }
}
