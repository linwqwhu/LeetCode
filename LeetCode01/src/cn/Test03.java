package cn;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 无重复字符的最长子串 的长度
 */
public class Test03 {
    public int lengthOfLongestSubstring1(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        char[] chars = s.toCharArray();
        int ans = 0;
        for (int start = 0, end = 0; end < s.length(); ++end) {
            if (hashMap.containsKey(chars[end])) {
                start = Math.max(hashMap.get(chars[end]), start);
            }
            ans = Math.max(ans, end + 1 - start);
            hashMap.put(chars[end], end + 1);
        }
        return ans;
    }

    //滑动窗口
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;//左右指针
        int maxLength = 0;//最长子串的长度
        HashSet<Character> hashSet = new HashSet<>();
        while (right < s.length()) {
            if (!hashSet.contains(s.charAt(right))) {
                //若不包含右指针指向的数，则将其添加到set中，长度加1
                hashSet.add(s.charAt(right));
                maxLength = maxLength > hashSet.size() ? maxLength : hashSet.size();
            } else {
                //若set中包含右指针指向的数，则不断移动左指针，将左指针指向的数从set中删除，直到set中不包含右指针指向的数，
                while (hashSet.contains(s.charAt(right))) {
                    hashSet.remove(s.charAt(left));
                    left++;
                }
                //set中已不包含右指针指向的数，故需要将其添加到set中
                hashSet.add(s.charAt(right));
            }
            right++;
        }
        return maxLength;
    }

    @Test
    public void t() {
//        String s = "abcabcbb";
        String s = "pwwkew";
        int count = lengthOfLongestSubstring(s);
        System.out.println(count);
    }

}
