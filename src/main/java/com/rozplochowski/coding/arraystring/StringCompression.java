package com.rozplochowski.coding.arraystring;

/**
 * Given an array of characters chars, compress it using the following algorithm:
 * <p>
 * Begin with an empty string s. For each group of consecutive repeating characters in chars:
 * <p>
 * If the group's length is 1, append the character to s.
 * Otherwise, append the character followed by the group's length.
 * The compressed string s should not be returned separately, but instead, be stored in the input character array chars.
 * Note that group lengths that are 10 or longer will be split into multiple characters in chars.
 * <p>
 * After you are done modifying the input array, return the new length of the array.
 * <p>
 * You must write an algorithm that uses only constant extra space.
 * <p>
 * Note: The characters in the array beyond the returned length do not matter and should be ignored.
 */
public class StringCompression {
    public static int compress(char[] chars) {
        if (chars.length == 0) return 0;
        if (chars.length == 1) return 1;

        char group = chars[0];
        int count = 1;
        int newLength = 0;

        for (var i = 1; i <= chars.length; i++) {
            if (i == chars.length || chars[i] != group) {
                if (count == 1) {
                    chars[newLength] = group;
                    newLength++;
                } else {
                    var strCount = String.valueOf(count);
                    chars[newLength] = group;
                    strCount.getChars(0, strCount.length(), chars, newLength + 1);
                    newLength += 1 + strCount.length();
                    count = 1;
                }
                if (i == chars.length) break;
                group = chars[i];
            } else {
                count++;
            }
        }

        return newLength;
    }
}
