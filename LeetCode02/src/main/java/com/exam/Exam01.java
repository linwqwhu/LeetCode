package com.exam;

import org.junit.Test;

import java.util.*;

public class Exam01 {
    public int exam01() {
        Scanner scanner = new Scanner(System.in);
        String nm = scanner.nextLine();
        String[] nmSplit = nm.split(" ");
        int n = Integer.parseInt(nmSplit[0]);
        int m = Integer.parseInt(nmSplit[1]);

        String[] colors = scanner.nextLine().split(" ");
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < colors.length; i++) {
            String s = colors[i];
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(i + 1);
        }
        List<List<Integer>> mapList = new ArrayList<>(map.values());
//        List<List<Integer>> mapList = new ArrayList<>();

        System.out.println(mapList);

        boolean[][] adj = new boolean[m + 1][m + 1];
        //n-1行
        int k = n - 1;
        while (k > 0) {
            String[] edge = scanner.nextLine().split(" ");
            int i = Integer.parseInt(edge[0]);
            int j = Integer.parseInt(edge[1]);
            adj[i][j] = true;
            adj[j][i] = true;
            k--;
        }
        System.out.println("--------");
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                System.out.print(adj[i][j] + "\t");
            }
            System.out.println();
        }
        int res = -1;
        for (List<Integer> list : mapList) {
            if (list.size() < 2) {
                continue;
            }
            for (int i = 0; i < list.size() - 1; i++) {
                for (int j = 0; j < list.size(); j++) {
                    int d = getDistance(adj, list.get(i), list.get(j));
                    res = res < d ? d : res;
                }
            }
        }
        return res;
    }

    public int getDistance(boolean[][] adj, int node1, int node2) {
        int n = adj.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node1);
        visited[node1] = true;
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == node2) {
                    return distance;
                }
                for (int j = 0; j < n; j++) {
                    if (adj[curr][j] && !visited[j]) {
                        visited[j] = true;
                        queue.offer(j);
                    }
                }
            }
            distance++;
        }
        return -1;
    }

    @Test
    public void test() {
        int i = exam01();
        System.out.println(i);
    }

    public static void main(String[] args) {
        Exam01 exam01 = new Exam01();

        int i = exam01.exam01();
        System.out.println(i);

    }


}
