package com.rozplochowski.coding.arraystring;

/**
 * Given an input string s, reverse the order of the words.
 * <p>
 * A word is defined as a sequence of non-space characters.
 * The words in s will be separated by at least one space.
 * <p>
 * Return a string of the words in reverse order concatenated by a single space.
 * Note that s may contain leading or trailing spaces or multiple spaces between two words.
 * The returned string should only have a single space separating the words.
 * Do not include any extra spaces.
 */
public class ReverseWordsInString {

    public String reverseWords(String s) {
        var sb = new StringBuilder();

        var i = s.length() - 1;

        while (i >= 0) {
            while (i >= 0 && Character.isWhitespace(s.charAt(i))) i--;

            if (i < 0) break;

            var end = i;

            while (i >= 0 && !Character.isWhitespace(s.charAt(i))) i--;

            if (!sb.isEmpty()) sb.append(' ');
            sb.append(s, i + 1, end + 1);
        }

        return sb.toString();
    }
}
