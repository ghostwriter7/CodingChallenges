package com.rozplochowski.coding;

/**
 * You are given two strings word1 and word2.
 * Merge the strings by adding letters in alternating order, starting with word1.
 * If a string is longer than the other, append the additional letters onto the end of the merged string.
 * Return the merged string.
 */
class MergeStringsAlternately {
    String mergeAlternately(String word1, String word2) {
        var length = Math.max(word1.length(), word2.length());
        var sb = new StringBuilder(word1.length() + word2.length());

        for (var i = 0; i < length; i++) {
            if (i < word1.length()) {
                sb.append(word1.charAt(i));
            }

            if (i < word2.length()) {
                sb.append(word2.charAt(i));
            }
        }

        return sb.toString();
    }
}
