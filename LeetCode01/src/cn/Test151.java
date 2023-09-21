package cn;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 反转字符串中的单词
 */
public class Test151 {

    public String reverseWords1(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ) {
            while (i < s.length() && ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9'))) {
                sb.append(s.charAt(i));
                i++;
            }
            sb.append(" ");
            while (i < s.length() && s.charAt(i) == ' ') {
                i++;
            }
        }
        String[] strings = sb.toString().trim().split(" ");
        sb.delete(0, sb.length());
        for (int i = strings.length - 1; i > 0; i--) {
            sb.append(strings[i] + " ");
        }
        return sb.toString() + strings[0];
    }    public String reverseWords(String s) {
        s = s.trim();
        //正则匹配连续的空白字符作为分隔符
        List<String> list = Arrays.asList(s.split("\\s+"));
        Collections.reverse(list);
        return String.join(" ", list);
    }



    @Test
    public void t() {
        //String s = "    the sky 9is   0blue   ";
        String s = "EPY2giL";
        System.out.println(reverseWords(s));

    }
}
