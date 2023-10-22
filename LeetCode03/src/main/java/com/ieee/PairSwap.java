package com.ieee;

import java.util.*;
import java.lang.*;
import java.io.*;

public class PairSwap {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        String[] s1 = in.nextLine().split(" ");
        int n = Integer.parseInt(s1[0]), k = Integer.parseInt(s1[1]);
        String[] s2 = in.nextLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s2[i]);
        }
        int index = 0;
        String str = Arrays.toString(nums);
        for (int i = 0; i < n - k; i++) {
            int j = i + k;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            String newStr = Arrays.toString(nums);
            if (newStr.compareTo(str) < 0) {
                str = newStr;
                index = i;
            }
            nums[j] = nums[i];
            nums[i] = temp;
        }

        int temp = nums[index];
        nums[index] = nums[index + k];
        nums[index + k] = temp;

        for (int i = 0; i < n - 1; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.print(nums[n - 1]);
    }
}
