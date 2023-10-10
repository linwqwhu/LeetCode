package com.linwqwhu;

import java.util.*;

public class Test2136 {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int len = plantTime.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            List<Integer> list = map.getOrDefault(growTime[i], new ArrayList<Integer>());
            list.add(i);
            map.put(growTime[i], list);
        }

        Arrays.sort(growTime);
        int pTime = 0;
        int needTime = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (i == len - 1 || growTime[i] != growTime[i + 1]) {
                int flowerGT = growTime[i];
                List<Integer> timesIndex = map.get(flowerGT);
                for (Integer index : timesIndex) {
                    pTime += plantTime[index];
                    needTime = Math.max(pTime + flowerGT, needTime);
                }
            }
        }
        return needTime;
    }
}
