package com.ieee;

import java.sql.Array;
import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * 模板
 */
public class WordPermutation {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        Map<String, Integer> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        int index = 0;
        while (index < n) {
            index++;
            String str = in.nextLine();
            list.add(str);
            map.put(str, index);
        }
        Collections.sort(list);
        for (int i = 0; i < n; i++) {
            int k = map.get(list.get(i));
            System.out.print(k + " ");
        }
    }
}
