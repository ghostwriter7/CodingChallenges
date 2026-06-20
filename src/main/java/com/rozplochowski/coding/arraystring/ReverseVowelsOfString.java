package com.rozplochowski.coding.arraystring;

import java.util.Arrays;

/**
 * Given a string s, reverse only all the vowels in the string and return it.
 * <p>
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
 * <p>
 * Example 2:
 * Input: s = "leetcode"
 * Output: "leotcede"
 */
class ReverseVowelsOfString {

    private static final boolean[] VOWELS = new boolean[128];

    static {
        VOWELS['a'] = VOWELS['e'] = VOWELS['i'] = VOWELS['o'] = VOWELS['u'] = true;
        VOWELS['A'] = VOWELS['E'] = VOWELS['I'] = VOWELS['O'] = VOWELS['U'] = true;
    }

    String reverseVowels(String s) {
        char[] chars = Arrays.copyOf(s.toCharArray(), s.length());

        var l = 0;
        var r = s.length() - 1;

        while (l < r) {
            var current = chars[l];

            if (current < VOWELS.length && VOWELS[current]) {
                for (var j = r; j > l; j--) {
                    var next = s.charAt(j);
                    if (next < VOWELS.length && VOWELS[next]) {
                        chars[l] = next;
                        chars[j] = current;
                        r = j - 1;
                        break;
                    }
                }
            }

            l++;
        }

        return new String(chars);
    }
}
