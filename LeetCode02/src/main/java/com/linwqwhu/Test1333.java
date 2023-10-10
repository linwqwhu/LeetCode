package com.linwqwhu;

import org.junit.Test;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 1333.餐厅过滤器
 */
public class Test1333 {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        int len = restaurants.length;
        boolean vegan = veganFriendly == 0 ? false : true;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[1] == o1[1])
                    return o2[0] - o1[0];
                return o2[1] - o1[1];
            }
        });
        for (int[] restaurant : restaurants) {
            if ((restaurant[2] == 1 || !vegan) && restaurant[3] <= maxPrice && restaurant[4] <= maxDistance) {
                queue.offer(restaurant);
            }
        }
        List<Integer> res = new LinkedList<>();
        while (!queue.isEmpty()) {
            res.add(queue.poll()[0]);
        }
        return res;
    }

    @Test
    public void testFilterRestaurants() {
        int[][] restaurants = {
                {77484, 13400, 1, 4010, 2926},
                {3336, 85138, 0, 49966, 89979},
                {28391, 55328, 0, 69158, 29058},
                {57395, 64988, 0, 45312, 30261}
        };
        int veganFriendly = 0;
        int maxPrice = 99739;
        int maxDistance = 60242;

        List<Integer> res = filterRestaurants(restaurants, veganFriendly, maxPrice, maxDistance);
        System.out.println(res.toString()); //true:[57395,28391,77484]
    }
}
