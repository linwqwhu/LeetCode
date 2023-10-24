package com.ieee;

import java.util.Map;
import java.util.Scanner;

public class SortingPartition {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        int ans = 1;
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            if (max <= nums[i]) {
                int min = nums[i];
                for (int k = i; k < n; k++) {
                    min = Math.min(min, nums[k]);
                }
                if (min > max) {
                    ans++;
                }
                max = nums[i];
            }
        }
        System.out.println(ans);
    }
}

