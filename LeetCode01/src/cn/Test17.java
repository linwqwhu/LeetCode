package cn;

import org.junit.Test;

import java.util.*;

/**
 * 电话号码的字母组合
 */
public class Test17 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }

        String[] maps = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (char digit : digits.toCharArray()) {
            String s = maps[digit - '0'];
            if (res.size() == 0) {
                for (char c : s.toCharArray()) {
                    res.add(c + "");
                }
            } else {
                List<String> list = new ArrayList<>();
                for (int i = 0; i < res.size(); i++) {
                    for (char c : s.toCharArray()) {
                        list.add(res.get(i) + c);
                    }
                }
                res = list;
            }
        }
        return res;
    }


    @Test
    public void testLetterCombinations() {

    }

    public List<String> letterCombinations2(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }

        String[] maps = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        Queue<String> queue = new ArrayDeque<>();

        for (char digit : digits.toCharArray()) {
            for (char c : maps[digit - '0'].toCharArray()) {
            }
        }

        return res;
    }

    public void dfs(String s, Deque<Character> stack, List<String> res) {
        if (s == null || s.length() == 0) {
            res.add(stack.toString());
            return;
        }

    }
}
