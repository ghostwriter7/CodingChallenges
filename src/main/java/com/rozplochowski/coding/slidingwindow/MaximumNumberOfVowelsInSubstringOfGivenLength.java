package com.rozplochowski.coding.slidingwindow;

/**
 * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
 * <p>
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 */
public class MaximumNumberOfVowelsInSubstringOfGivenLength {
    public static int maxVowels(String s, int k) {
        byte[] vowels = new byte[128];
        vowels['a'] = vowels['e'] = vowels['i'] = vowels['o'] = vowels['u'] = 1;

        var count = 0;
        for (var i = 0; i < k; i++) {
            count += vowels[s.charAt(i)];
        }

        var max = count;

        for (var i = k; i < s.length(); i++) {
            char first = s.charAt(i - k);
            char curr = s.charAt(i);

            count += vowels[curr] - vowels[first];
            max = Math.max(max, count);
        }

        return max;
    }
}
