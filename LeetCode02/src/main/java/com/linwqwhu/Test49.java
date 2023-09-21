package com.linwqwhu;

import java.util.*;

/**
 * 49. 字母异位词分组
 */
public class Test49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        int len = strs.length;
        boolean[] isAdd = new boolean[len];
        int[][] countWord = new int[len][26];

        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            for (int k = 0; k < s.length(); k++) {
                countWord[i][s.charAt(k) - 'a']++;
            }
        }

        for (int i = 0; i < len; i++) {
            if (isAdd[i])
                continue;
            List<String> temp = new ArrayList<>();
            temp.add(strs[i]);
            isAdd[i] = true;

            int[] word1 = countWord[i];

            for (int j = i + 1; j < len; j++) {
                if (isAdd[j])
                    continue;
                int[] word2 = countWord[j];

                boolean isSample = true;
                for (int k = 0; k < 26; k++) {
                    if (word2[k] != word1[k]) {
                        isSample = false;
                        break;
                    }
                }
                if (isSample) {
                    temp.add(strs[j]);
                    isAdd[j] = true;
                }
            }
            res.add(temp);
        }
        return res;
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] counts = new int[26];
            for (int i = 0; i < str.length(); i++) {
                counts[str.charAt(i) - 'a']++;
            }
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public List<List<String>> groupAnagrams3(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> singleRes = hm.getOrDefault(key, new ArrayList<String>());
            singleRes.add(str);
            hm.put(key, singleRes);
        }
        return new ArrayList<List<String>>(hm.values());
    }
}
