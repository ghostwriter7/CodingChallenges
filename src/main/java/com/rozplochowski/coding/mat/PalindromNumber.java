package com.rozplochowski.coding.mat;

/**
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 */
public class PalindromNumber {

    public boolean isPalindrome(int x) {
        return String.valueOf(x).contentEquals(new StringBuilder(String.valueOf(x)).reverse());
    }

    public boolean isPalindrome2(int x) {
        var str = String.valueOf(x);
        var l = 0;
        var r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    public boolean isPalindrome3(int x) {
        var reversed = 0;
        var current = x;

        while (current > 0) {
            var reminder = current % 10;
            reversed = reversed * 10 + reminder;
            current /= 10;
        }

        return x == reversed;
    }
}
