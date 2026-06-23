package com.rozplochowski.coding;

/**
 * You are given a string s, which contains stars *.
 * <p>
 * In one operation, you can:
 * <p>
 * Choose a star in s.
 * Remove the closest non-star character to its left, as well as remove the star itself.
 * Return the string after all stars have been removed.
 * <p>
 * Note:
 * <p>
 * The input will be generated such that the operation is always possible.
 * It can be shown that the resulting string will always be unique.
 */
public class RemovingStarsFromString {
    public static String removeStars(String s) {
        char[] chars = new char[s.length()];
        int pointer = 0;
        var star = '*';

        for (var i = 0; i < s.length(); i++) {
            var c = s.charAt(i);
            if (c == star) pointer--;
            else chars[pointer++] = c;
        }

        return new String(chars, 0, pointer);
    }
}
