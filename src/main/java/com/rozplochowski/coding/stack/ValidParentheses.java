package com.rozplochowski.coding.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {

    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>(s.length());

        for (var c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();

                if ((top == '(' && c != ')') || (top == '[' && c != ']') || (top == '{' && c != '}'))
                    return false;
            }
        }

        return stack.isEmpty();
    }
}
