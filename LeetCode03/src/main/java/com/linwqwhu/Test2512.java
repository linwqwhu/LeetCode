package com.linwqwhu;

import java.util.*;

/**
 * 2512.奖励最顶尖的K名学生
 */
public class Test2512 {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback,
                                     String[] report, int[] student_id, int k) {
        int len = student_id.length;

        int[][] scores = new int[len][2];
        Set<String> positive = new HashSet<>();
        for (String feedback : positive_feedback) {
            positive.add(feedback);
        }
        Set<String> negative = new HashSet<>();
        for (String feedback : negative_feedback) {
            negative.add(feedback);
        }

        for (int i = 0; i < len; i++) {
            String[] words = report[i].split(" ");
            int score = 0;
            for (String word : words) {
                if (positive.contains(word))
                    score += 3;
                else if (negative.contains(word))
                    score -= 1;
            }
            scores[i][0] = student_id[i];
            scores[i][1] = score;
        }
        Arrays.sort(scores, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1])
                    return o1[0] - o2[0];
                return o2[1] - o1[1];
            }
        });
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            res.add(scores[i][0]);
        }
        return res;
    }
}
