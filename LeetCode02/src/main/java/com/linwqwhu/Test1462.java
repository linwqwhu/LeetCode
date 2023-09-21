package com.linwqwhu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1462.课程表IV
 */
public class Test1462 {

    //超时
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> answer = new ArrayList<>();

        //构建邻接矩阵
        int len = prerequisites.length;
        int[][] adj = new int[numCourses][numCourses];
        for (int[] pre : prerequisites) {
            adj[pre[0]][pre[1]] = 1;
            adj[pre[1]][pre[0]] = -1;
        }
        for (int[] query : queries) {
            answer.add(dfs(adj, query[0], query[1]));
        }
        return answer;

    }

    public boolean dfs(int[][] adj, int start, int end) {
        if (start == end) {
            return true;
        }
        boolean flag = false;
        for (int j = 0; j < adj.length && !flag; j++) {
            if (adj[start][j] == 1) {
                flag = flag || dfs(adj, j, end);
            }
        }
        return flag;
    }


    public List<Boolean> checkIfPrerequisite2(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> answer = new ArrayList<>();

        //构建邻接矩阵
        boolean[][] adj = new boolean[numCourses][numCourses];
        for (int[] pre : prerequisites) {
            adj[pre[0]][pre[1]] = true;
        }
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    adj[i][j] |= adj[i][k] && adj[k][j];
                }
            }
        }
        for (int[] query : queries) {
            answer.add(adj[query[0]][query[1]]);
        }
        return answer;
    }
}
