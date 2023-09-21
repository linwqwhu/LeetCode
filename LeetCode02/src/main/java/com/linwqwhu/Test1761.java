package com.linwqwhu;

import org.junit.Test;

/**
 * 1761. 一个图中连通三元组的最小度数
 */
public class Test1761 {


    public int minTrioDegree(int n, int[][] edges) {
        boolean[][] g = new boolean[n][n]; //邻接矩阵
        int[] d = new int[n]; // 每个点的度数
        //建立邻接矩阵及度数数组
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            g[node1-1][node2-1] = true;
            g[node2-1][node1-1] = true;
            d[node1-1]++;
            d[node2-1]++;
        }
        int re = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                for (int k = j + 1; k < n; ++k) {
                    if (g[i][j] && g[j][k] && g[k][i]) {
                        re = Math.min(re, d[k] + d[j] + d[i] - 6);
                    }
                }
            }
        }
        return re == Integer.MAX_VALUE ? -1 : re;
    }

    @Test
    public void testMinTrioDegree() {
        int[][] edges = {{1, 2}, {1, 3}, {3, 2}, {4, 1}, {5, 2}, {3, 6}};
        int re = minTrioDegree(6, edges);
        System.out.println(re);
    }
}
