package com.ieee;

import java.util.*;
import java.lang.*;
import java.io.*;

public class MatrixExploration {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);

        String[] nmk = in.nextLine().split(" ");
        int n = Integer.parseInt(nmk[0]);
        int m = Integer.parseInt(nmk[1]);
        int k = Integer.parseInt(nmk[2]);

        boolean[][] mat = new boolean[n][m];

        int indexLine = 0;
        while (indexLine < n) {
            String matLine = in.nextLine();
            for (int i = 0; i < m; i++) {
                if (matLine.charAt(i) == '.') {
                    mat[indexLine][i] = true;
                }
            }
            indexLine++;
        }

        int[][] specialCell = new int[k][2];
        indexLine = 0;
        while (indexLine < k) {
            String[] sLine = in.nextLine().split(" ");
            specialCell[indexLine][0] = Integer.parseInt(sLine[0]) - 1;
            specialCell[indexLine][1] = Integer.parseInt(sLine[1]) - 1;
            indexLine++;
        }

        int[][] dis = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i], 2 * (n + m));
        }
        int[][] moves = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        Deque<int[]> deque = new ArrayDeque<>();

        for (int[] special : specialCell) {
            dis[special[0]][special[1]] = 0;
            deque.add(new int[]{special[0], special[1]});
        }
        while (!deque.isEmpty()) {
            int[] xy = deque.pop();
            for (int[] move : moves) {
                int x = xy[0] + move[0];
                int y = xy[1] + move[1];
                if (x >= 0 && x < n && y >= 0 && y < m && mat[x][y]) {
                    int num = dis[xy[0]][xy[1]] + 1;
                    if (dis[x][y] > num) {
                        dis[x][y] = num;
                        deque.add(new int[]{x, y});
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j]) {
                    res += dis[i][j];
                }
            }
        }

        System.out.println(res);
    }
}
