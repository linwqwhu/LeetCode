package cn;

import org.junit.Test;

/**
 * 最后一个单词的长度
 */
public class Test58 {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int count = 0;
        int len = s.length() - 1;
        while (len >= 0 && s.charAt(len--) != ' ') {
            count++;
        }
        return count;
    }

    @Test
    public void t() {
        System.out.println(lengthOfLastWord("Hello World   "));
    }
}
