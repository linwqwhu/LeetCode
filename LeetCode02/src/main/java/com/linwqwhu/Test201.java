package com.linwqwhu;

import org.junit.Test;

import java.time.Period;
import java.util.*;

/**
 * 210.课程表II
 */
public class Test201 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] pre : prerequisites) {
            if (pre[0] == pre[1])
                return new int[0];
            List<Integer> list;
            if (map.containsKey(pre[1])) {
                list = map.get(pre[1]);
            } else {
                list = new ArrayList<>();
            }
            list.add(pre[0]);
            inDegree[pre[0]]++;
            map.put(pre[1], list);
        }

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                deque.offer(i);
            }
        }

        int k = 0;
        int[] res = new int[numCourses];

        while (!deque.isEmpty()) {
            int num = deque.poll();
            res[k++] = num;
            List<Integer> numList = map.get(num);
            if (numList != null && numList.size() > 0) {
                for (int course : numList) {
                    if (--inDegree[course] == 0) {
                        deque.offer(course);
                    }
                }
            }
        }


        return k == numCourses ? res : new int[0];
    }

    @Test
    public void testFindOrder() {
        int i = 1;
        System.out.println(new int[0]);
    }

}
