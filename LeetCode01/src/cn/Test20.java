package cn;

import org.junit.Test;

import java.util.Stack;

/**
 * 有效的括号
 */
public class Test20 {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '[') {
                stack.push(']');
            } else if (ch == '{') {
                stack.push('}');
            } else {
                if (stack.empty() || stack.pop() != ch) {
                    return false;
                }
            }
        }
        return  stack.empty();
    }

    @Test
    public void t() {

        String str = "(){}";

        System.out.println(isValid(str));
    }

}
