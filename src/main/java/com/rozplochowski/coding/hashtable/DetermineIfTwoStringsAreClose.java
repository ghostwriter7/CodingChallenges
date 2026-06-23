package com.rozplochowski.coding.hashtable;

import java.util.Arrays;

/**
 * Two strings are considered close if you can attain one from the other using the following operations:
 * <p>
 * <ul>
 *     <li>
 *         Operation 1: Swap any two existing characters.
 *         For example, abcde -> aecdb
 *     </li>
 *     <li>
 *         Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
 *         For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
 *     </li>
 * </ul>
 * <p>
 * You can use the operations on either string as many times as necessary.
 * <p>
 * Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
 */
public class DetermineIfTwoStringsAreClose {

    /**
     * 1. must have the same length
     * 2. must have the same unique characters
     * 3. must have the same frequency multisets
     */
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        int[] frequency1 = new int[26];
        int[] frequency2 = new int[26];

        for (var character : word1.toCharArray()) {
            frequency1[character - 'a']++;
        }

        for (var character : word2.toCharArray()) {
            frequency2[character - 'a']++;
        }

        for (var i = 0; i < 26; i++) {
            if ((frequency1[i] == 0) != (frequency2[i] == 0)) return false;
        }

        Arrays.sort(frequency1);
        Arrays.sort(frequency2);
        return Arrays.equals(frequency1, frequency2);
    }

}
