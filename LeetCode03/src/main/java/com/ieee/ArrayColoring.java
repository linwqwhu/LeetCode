package com.ieee;

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * 未完成
 */
public class ArrayColoring {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        String[] nm = in.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        String[] strs = in.nextLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }


        System.out.println(nums.toString());

    }
}
