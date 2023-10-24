package com.ieee;

import java.lang.*;
import java.util.*;

/**
 * 模板
 */
public class CircularSubarrays {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String[] nk = in.nextLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        String[] numsStr = in.nextLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(numsStr[i]);
        }

        int cost = 0;
        if (k < n) {
            boolean[] visited = new boolean[n];
            //nums[i] 与nums[i +k]的值要一样
            for (int i = 0; i < n; i++) {
                List<Integer> list = new ArrayList<>();
                if (visited[i]) continue;

                int j = i;
                while (!visited[j]) {
                    list.add(nums[j]);
                    visited[j] = true;
                    j = (j + k) % n;
                }

                Collections.sort(list);
                int mid = list.get(list.size() / 2);
                for (int num : list) {
                    cost += Math.abs(num - mid);
                }
            }

        }
        System.out.println(cost);
    }
}
