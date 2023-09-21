package com.linwqwhu;


import java.util.*;
import java.util.jar.JarInputStream;

/**
 * 22.括号生成
 */
public class Test22 {
    public List<String> generateParenthesis(int n) {
        Map<Integer, List<String>> map = new HashMap<>();
        map.put(0, new LinkedList<>(Arrays.asList("")));
        map.put(1, new LinkedList<>(Arrays.asList("()")));

        for (int i = 2; i <= n; i++) {
            List<String> res = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                List<String> nowList1 = map.get(j);
                List<String> nowList2 = map.get(i - 1 - j);
                for (String str1 : nowList1) {
                    for (String str2 : nowList2) {
                        res.add("(" + str1 + ")" + str2);
                    }
                }
            }
            map.put(i, res);
        }
        return map.get(n);
    }
}
