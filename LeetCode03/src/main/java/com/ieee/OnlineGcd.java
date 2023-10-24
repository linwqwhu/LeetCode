package com.ieee;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class OnlineGcd {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        OnlineGcd on = new OnlineGcd();

        String[] nm = in.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        String[] numStr = in.nextLine().split(" ");
        int[] nums = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(numStr[i]);
            deque.offer(nums[i]);
        }

        int ans = nums[0];
        while (deque.size() > 1) {
            ans = on.gcd(deque.poll(), deque.poll());
            deque.offer(ans);
        }

        int[][] ig = new int[m][2];

        int indexLine = 0;
        while (indexLine < m) {
            String[] igStr = in.nextLine().split(" ");
            ig[indexLine][0] = Integer.parseInt(igStr[0]) - 1;
            ig[indexLine][1] = Integer.parseInt(igStr[1]);
            indexLine++;
        }

        for (int[] i : ig) {
            nums[i[0]] = nums[i[0]] / i[1];
            ans = on.gcd(nums[i[0]], ans);
            System.out.println(ans);
        }
    }

    /**
     * 展转相除法(欧几里德算法) gcd(a,b) = gcd(b,a mod b)
     *
     * @param x
     * @param y
     * @return
     */
    private int gcd(int x, int y) {
        while (y != 0) {
            int r = x % y;
            x = y;
            y = r;
        }
        return x;
    }
}
