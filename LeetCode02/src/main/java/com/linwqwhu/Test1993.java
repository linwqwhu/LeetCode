package com.linwqwhu;

import java.util.*;

/**
 * 1993.树上的操作
 */
public class Test1993 {

    private Map<Integer, List<Integer>> childToAncestorMap;
    private Map<Integer, List<Integer>> parentToDescendantsMap;

    private Map<Integer, Integer> lockMap;

    public Test1993(int[] parent) {
//    public LockingTree(int[] parent) {

        lockMap = new HashMap<>();
        childToAncestorMap = new HashMap<>();
        parentToDescendantsMap = new HashMap<>();

        int len = parent.length;
        //从子节点到祖先节点
        for (int child = 1; child < len; child++) {
            List<Integer> list = new ArrayList<>();
            int p = parent[child];
            while (p != -1) {
                list.add(p);
                p = parent[p];
            }
            childToAncestorMap.put(child, list);
        }

        //从父节点到后代节点
        Map<Integer, List<Integer>> parentAndChildren = new HashMap<>();
        for (int i = 1; i < len; i++) {
            List<Integer> list = parentAndChildren.getOrDefault(parent[i], new ArrayList<>());
            list.add(i);
            parentAndChildren.put(parent[i], list);
        }

        for (Integer i : parentAndChildren.keySet()) {
            Deque<Integer> deque = new ArrayDeque<>();
            for (int num : parentAndChildren.get(i)) {
                deque.add(num);
            }
            List<Integer> list = new ArrayList<>();
            while (!deque.isEmpty()) {
                int num = deque.pop();
                list.add(num);
                if (parentAndChildren.containsKey(num)) {
                    List<Integer> list1 = parentAndChildren.get(num);
                    for (int num1 : list1) {
                        deque.add(num1);
                    }
                }
            }
            parentToDescendantsMap.put(i, list);
        }
    }

    public boolean lock(int num, int user) {
        if (lockMap.containsKey(num)) {
            return false;
        }
        lockMap.put(num, user);
        return true;
    }

    public boolean unlock(int num, int user) {
        if (lockMap.containsKey(num)) {
            if (lockMap.get(num) == user) {
                lockMap.remove(num);
                return true;
            }
        }
        return false;
    }

    public boolean upgrade(int num, int user) {
        if (lockMap.containsKey(num))
            return false;

        boolean hasLockDes = false;
        List<Integer> des = parentToDescendantsMap.get(num);
        if (des != null && des.size() > 0) {
            for (Integer d : des) {
                if (lockMap.containsKey(d)) {
                    hasLockDes = true;
                    break;
                }
            }
        }
        if (!hasLockDes)
            return false;


        List<Integer> anc = childToAncestorMap.get(num);
        if (anc != null && anc.size() > 0) {
            for (Integer a : anc) {
                if (lockMap.containsKey(a)) {
                    return false;
                }
            }
        }

        des = parentToDescendantsMap.get(num);
        lockMap.put(num, user);
        if (des != null && des.size() > 0) {
            for (Integer d : des) {
                if (lockMap.containsKey(d)) {
                    lockMap.remove(d);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] parent = {-1, 4, 9, 0, 6, 1, 0, 6, 3, 1};
        Test1993 test = new Test1993(parent);

    }
}
