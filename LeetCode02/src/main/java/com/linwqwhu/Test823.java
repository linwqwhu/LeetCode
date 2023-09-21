package com.linwqwhu;

import org.junit.Test;

import java.util.*;

/**
 * 823. 带因子的二叉树
 */
public class Test823 {


//    public int numFactoredBinaryTrees1(int[] arr) {
//        long res = 0;
//        Set<Integer> set = new HashSet();
//        for (int i = 0; i < arr.length; i++) {
//            set.add(arr[i]);
//        }
//        for (int i = 0; i < arr.length; i++) {
//            res += dfs(arr[i], arr, set);
//            res %= (long) (1e9 + 7);
//        }
//        return (int) res;
//    }
//
//
//    public long dfs1(int val, int[] arr, Set<Integer> set) {
//        long res = 1;
//        for (int n : arr) {
//            if (val % n == 0 && set.contains(val / n)) {
//                res += dfs(n, arr, set) * dfs(val / n, arr, set);
//            }
//        }
//        return res;
//    }

    public int numFactoredBinaryTrees(int[] arr) {

        long res = 0l;

        Arrays.sort(arr);
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            idxMap.put(arr[i], i);
        }
        long[] memo = new long[arr.length];
        Arrays.fill(memo, -1);

        for (int i = 0; i < arr.length; i++) {
            res += dfs(i, arr, memo, idxMap);
            res %= (int) (1e9 + 7);
        }
        return (int) res;
    }

    private long dfs(int i, int[] arr, long[] memo, Map<Integer, Integer> idxMap) {
        if (memo[i] != -1) {
            return memo[i];
        }
        int val = arr[i];
        long res = 1;
        for (int j = 0; j < i; j++) {
            int x = arr[j];
            if (val % x == 0 && idxMap.containsKey(val / x)) {
                res += dfs(j, arr, memo, idxMap) * dfs(idxMap.get(val / x), arr, memo, idxMap);
            }
        }
        memo[i] = res;
        return res % (long) (1e9 + 7);
    }

    @Test
    public void testNumFactoredBinaryTrees() {
        int[] arr = {2, 4};
        int i = numFactoredBinaryTrees(arr);
        System.out.println(i);

    }


}
