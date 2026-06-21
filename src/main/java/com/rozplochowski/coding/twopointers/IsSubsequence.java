package com.rozplochowski.coding.twopointers;

/**
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * <p>
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters.
 * (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 */
public class IsSubsequence {

    public static boolean isSubsequence(String s, String t) {
        if (t.length() < s.length()) return false;
        if (s.isEmpty()) return true;

        var sIdx = 0;
        var tIdx = 0;

        var matchCount = 0;

        var current = s.charAt(sIdx);
        while (tIdx < t.length()) {
            if (current == t.charAt(tIdx)) {
                if (++matchCount == s.length()) return true;
                current = s.charAt(++sIdx);
            }
            tIdx++;
        }

        return false;
    }
}
