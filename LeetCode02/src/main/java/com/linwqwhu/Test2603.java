package com.linwqwhu;

import org.junit.Test;

import java.util.*;

/**
 * 2603.收集树中金币
 */
public class Test2603 {
    //超出内存限制
    public int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length;
        if (edges == null || n <= 2)
            return 0;

        boolean[][] adj = new boolean[n][n];
        int[] indegree = new int[n];
        for (int[] edge : edges) {
            indegree[edge[0]]++;
            indegree[edge[1]]++;
            adj[edge[0]][edge[1]] = true;
            adj[edge[1]][edge[0]] = true;
        }
        int leftEdges = n - 1;//剩余边树

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 1 && coins[i] == 0) {
                stack.push(i);
            }
        }

        //删除不含金币的叶节点（入度为1）
        while (!stack.isEmpty()) {
            int num = stack.pop();
            for (int j = 0; j < n; j++) {
                if (adj[num][j]) {
                    adj[num][j] = false;
                    adj[j][num] = false;
                    indegree[num]--;
                    indegree[j]--;
                    if (indegree[num] == 1 && coins[num] == 0)
                        stack.push(num);
                    if (indegree[j] == 1 && coins[j] == 0)
                        stack.push(j);
                }
            }
        }

        //此时叶子节点均为金币节点
        // 删除金币节点及其邻居节点
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 1) {
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            int num = stack.pop();
            for (int j = 0; j < n; j++) {
                if (adj[num][j]) {
                    adj[num][j] = false;
                    adj[j][num] = false;
                    indegree[num]--;
                    indegree[j]--;
                }
            }
        }


        int count = 0;
        for (int num : indegree) {
            if (num > 1)
                count++;
        }
        return (count - 1) * 2;

    }

    @Test
    public void testCollectTheCoins() {
        int[] coins = {0, 0, 0, 1, 1, 0, 0, 1};
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {5, 6}, {5, 7}};
        int res = collectTheCoins(coins, edges);
        System.out.println(res);
    }

    public int collectTheCoins2(int[] coins, int[][] edges) {
        int n = coins.length;
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; ++i) {
            g[i] = new ArrayList<Integer>();
        }
        int[] degree = new int[n];
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            g[x].add(y);
            g[y].add(x);
            ++degree[x];
            ++degree[y];
        }

        int rest = n;
        /* 删除树中所有无金币的叶子节点，直到树中所有的叶子节点都是含有金币的 */
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i < n; ++i) {
            if (degree[i] == 1 && coins[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int u = queue.poll();
            --degree[u];
            --rest;
            for (int v : g[u]) {
                --degree[v];
                if (degree[v] == 1 && coins[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        /* 删除树中所有的叶子节点, 连续删除2次 */
        for (int x = 0; x < 2; ++x) {
            queue = new ArrayDeque<Integer>();
            for (int i = 0; i < n; ++i) {
                if (degree[i] == 1) {
                    queue.offer(i);
                }
            }
            while (!queue.isEmpty()) {
                int u = queue.poll();
                --degree[u];
                --rest;
                for (int v : g[u]) {
                    --degree[v];
                }
            }
        }

        return rest == 0 ? 0 : (rest - 1) * 2;
    }
}
