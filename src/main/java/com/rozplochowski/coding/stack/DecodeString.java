package com.rozplochowski.coding.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Given an encoded string, return its decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
 * Note that k is guaranteed to be a positive integer.
 * <p>
 * You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc.
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k.
 * For example, there will not be input like 3a or 2[4].
 * <p>
 * The test cases are generated so that the length of the output will never exceed 10^5.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 * <p>
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 * <p>
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 */
public class DecodeString {
    private static final char CLOSE_BRACKET = ']';
    private static final char OPEN_BRACKET = '[';

    private static final String OPEN_BRACKET_STR = "[";
    private static final String CLOSE_BRACKET_STR = "]";

    public static String decodeString(String s) {
        Object[] stack = new Object[s.length()];
        int writeAt = 0;

        for (var i = 0; i < s.length(); i++) {
            var c = s.charAt(i);

            if (c == CLOSE_BRACKET) {
                var last = (String) stack[--writeAt];
                writeAt -= 2;
                var count = (Integer) stack[writeAt];
                var str = last.repeat(count);
                if (writeAt == 0 || stack[writeAt - 1].equals(OPEN_BRACKET_STR)) {
                    stack[writeAt++] = str;
                } else {
                    stack[writeAt - 1] += str;
                }

            } else if (c == OPEN_BRACKET) {

                stack[writeAt++] = OPEN_BRACKET_STR;

            } else {
                var last = writeAt > 0 ? stack[writeAt - 1] : null;

                if (last == null || last.equals(OPEN_BRACKET_STR) || last.equals(CLOSE_BRACKET_STR)) {
                    stack[writeAt++] = Character.isDigit(c) ? Integer.valueOf(c - '0') : Character.toString(c);
                } else {
                    var isDigit = c >= '0' && c <= '9';
                    if (isDigit && last instanceof Integer lastInt) {
                        stack[writeAt - 1] = lastInt * 10 + (c - '0');
                    } else if (!isDigit && last instanceof String lastStr) {
                        stack[writeAt - 1] = lastStr + c;
                    } else {
                        stack[writeAt++] = isDigit ? Integer.valueOf(c - '0') : Character.toString(c);
                    }
                }
            }

        }

        var sb = new StringBuilder();
        for (var i = 0; i < writeAt; i++) {
            sb.append(stack[i]);
        }
        return sb.toString();
    }
}
