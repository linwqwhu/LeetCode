package com.ieee;

import java.util.Scanner;

/**
 * 模板
 */
public class GreatestCommonDivisor {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        while (y != 0) {
            int r = x % y;
            x = y;
            y = r;
        }
        System.out.println(x);
    }
}
