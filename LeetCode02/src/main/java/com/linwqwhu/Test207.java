package com.linwqwhu;

import org.junit.Test;

import java.util.*;

/**
 * 207.课程表
 */
public class Test207 {

    //超时
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //建立一个有向图的邻接矩阵，起点为1，终点为-1
        int[][] adj = new int[numCourses][numCourses];
        for (int[] nums : prerequisites) {
            //判断先前是否存在反向链接
            if (adj[nums[0]][nums[1]] == -1 || nums[0] == nums[1])
                return false;
            adj[nums[0]][nums[1]] = 1;
            adj[nums[1]][nums[0]] = -1;
        }

        for (int i = 0; i < numCourses; i++) {
            for (int j = 0; j < numCourses; j++) {
                if (adj[i][j] == 1 && isCircle(adj, i, j, i))
                    return false;
            }
        }


        return true;

    }

    /**
     * 判断是否存在环
     *
     * @param adj
     * @param i
     * @param j
     * @param start
     * @return
     */
    public boolean isCircle(int[][] adj, int i, int j, int start) {
        if (j == start)
            return true;
        for (int k = 0; k < adj.length; k++) {
            if (adj[j][k] == 1 && isCircle(adj, j, k, start))
                return true;
        }
        return false;
    }

    @Test
    public void testCanFinish() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        System.out.println(list.toString());
    }

    public boolean canFinish2(int numCourses, int[][] prerequisites) {

        int[] inDegree = new int[numCourses];//入度
        Map<Integer, List<Integer>> map = new HashMap<>();//key=

        for (int[] nums : prerequisites) {
            if (nums[0] == nums[1])
                return false;
            inDegree[nums[0]]++;
            List<Integer> list;
            if (map.containsKey(nums[1])) {
                list = map.get(nums[1]);
            } else {
                list = new ArrayList<Integer>();
            }
            list.add(nums[0]);
            map.put(nums[1], list);
        }

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                deque.offer(i);
            }
        }
        while (!deque.isEmpty()) {
            List<Integer> list = map.get(deque.poll());
            if (list != null && list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    int num = list.get(i);
                    inDegree[num]--;
                    if (inDegree[num] == 0) {
                        deque.offer(num);
                    }
                }
            }
        }
        return Arrays.stream(inDegree).max().getAsInt() == 0;
    }


}
