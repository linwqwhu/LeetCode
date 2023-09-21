package com.linwqwhu;

import org.junit.Test;

import java.util.*;

/**
 * 630.课程表III
 */
public class Test630 {
    public int scheduleCourse(int[][] courses) {
        //对二维数组的第二列排序
        Arrays.sort(courses, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int currentTotalTime = 0;
        int len = courses.length;
        List<Integer> learnCourseTime = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            int[] course = courses[i];
            if (currentTotalTime + course[0] <= course[1]) {
                currentTotalTime += course[0];
                learnCourseTime.add(course[0]);
                continue;
            }

            if (learnCourseTime.size() > 0) {
                learnCourseTime.sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1 - o2;
                    }
                });
                int max = learnCourseTime.get(learnCourseTime.size() - 1);
                if (max > course[0] && currentTotalTime - max + course[0] <= course[1]) {
                    currentTotalTime += course[0] - max;
                    learnCourseTime.remove(learnCourseTime.size() - 1);
                    learnCourseTime.add(course[0]);
                }
            }
        }
        return learnCourseTime.size();
    }

    @Test
    public void testScheduleCourse() {

        int[][] test = {{7, 17}, {3, 12}, {10, 20}, {9, 10}, {5, 20}, {10, 19}, {4, 18}};
        int res = scheduleCourse(test);
        System.out.println(res);
    }

    public int scheduleCourse2(int[][] courses) {
        //对二维数组的第二列排序
        Arrays.sort(courses, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int currentTotalTime = 0;
        PriorityQueue<Integer> learnCourseTime = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;//头为最大的
            }
        });

        for (int[] course : courses) {

            if (currentTotalTime + course[0] <= course[1]) {
                currentTotalTime += course[0];
                learnCourseTime.offer(course[0]);
                continue;
            }

            if (!learnCourseTime.isEmpty() && learnCourseTime.peek() > course[0]) {
                currentTotalTime += course[0] - learnCourseTime.poll();
                learnCourseTime.offer(course[0]);
            }
        }
        return learnCourseTime.size();
    }
}
