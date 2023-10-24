package com.ieee;

import java.util.*;

public class WordOrdering {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String order = in.nextLine();
        int n = Integer.parseInt(in.nextLine());

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put(order.charAt(i), i + 1);
            map.put((char) (order.charAt(i) - 32), i + 27);
        }

        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int len1 = s1.length(), len2 = s2.length();
                for (int i = 0; i < len1 || i < len2; i++) {
                    int num1 = i < len1 ? map.get(s1.charAt(i)) : 0;
                    int num2 = i < len2 ? map.get(s2.charAt(i)) : 0;
                    if (num1 != num2) {
                        return num1 - num2;
                    }
                }
                return 0;
            }
        });

        int index = 0;
        while (index < n) {
            queue.offer(in.nextLine());
            index++;
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
