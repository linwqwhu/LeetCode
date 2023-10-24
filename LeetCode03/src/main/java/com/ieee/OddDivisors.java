package com.ieee;

import java.util.Scanner;

public class OddDivisors {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        OddDivisors od = new OddDivisors();
        while (t > 0) {
            t--;
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(od.count(b) - od.count(a - 1));
        }
    }

    public long count(int n) {
        if (n <= 0)
            return 0;
        if (n % 2 == 0) {
            return count(n / 2) + 1l * n * n / 4;
        } else {
            return count((n - 1) / 2) + 1l * (n + 1) * (n + 1) / 4;
        }
    }

}
