package com.linwqwhu;

import org.junit.Test;

import java.util.Arrays;

/**
 * 2316.统计无向图中无法互相达到点对数（未完成）
 */
public class Test2316 {
    /**
     * 错误
     * @param n
     * @param edges
     * @return
     */
    public long countPairs(int n, int[][] edges) {
        boolean[][] isConnect = new boolean[n][n];
        for (int[] edge : edges) {
            int i = edge[0];
            int j = edge[1];
            isConnect[i][j] = true;
            isConnect[j][i] = true;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = 0; k < n && !isConnect[i][j]; k++) {
                    isConnect[i][j] = isConnect[i][k] && isConnect[k][j];
                }
            }
        }

        long res = 1l * n * (n - 1) / 2;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnect[i][j])
                    res--;
            }
        }
        return res;
    }

    @Test
    public void testCountPairs() {
        int n = 50;
        int[][] edges = {
                {20, 0}, {31, 1}, {2, 15}, {5, 31}, {6, 44},
                {48, 7}, {4, 8}, {9, 3}, {10, 44}, {33, 11},
                {22, 12}, {2, 13}, {20, 14}, {2, 16}, {17, 25},
                {18, 22}, {7, 19}, {15, 21}, {22, 23}, {24, 11},
                {6, 26}, {1, 27}, {28, 2}, {29, 6}, {17, 30},
                {26, 32}, {8, 34}, {35, 5}, {7, 37}, {9, 38},
                {39, 36}, {40, 20}, {25, 41}, {42, 41}, {43, 14},
                {45, 33}, {44, 46}, {47, 41}, {49, 2}
        };
        long res = countPairs(n, edges);
        System.out.println(res);
    }


    public long countPairs2(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            uf.union(x, y);
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += n - uf.getSize(uf.find(i));
        }
        return res / 2;
    }

    class UnionFind {
        int[] parents;
        int[] sizes;

        public UnionFind(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
            sizes = new int[n];
            Arrays.fill(sizes, 1);
        }

        public int find(int x) {
            if (parents[x] == x) {
                return x;
            } else {
                parents[x] = find(parents[x]);
                return parents[x];
            }
        }

        public void union(int x, int y) {
            int rx = find(x), ry = find(y);
            if (rx != ry) {
                if (sizes[rx] > sizes[ry]) {
                    parents[ry] = rx;
                    sizes[rx] += sizes[ry];
                } else {
                    parents[rx] = ry;
                    sizes[ry] += sizes[rx];
                }
            }
        }

        public int getSize(int x) {
            return sizes[x];
        }
    }
}
