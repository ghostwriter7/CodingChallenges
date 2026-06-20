package com.rozplochowski.coding;

/**
 * For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t
 * (i.e., t is concatenated with itself one or more times).
 * <p>
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 */
class GreatestCommonDivisorOfStrings {

    String compute(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) return "";
        var gcd = gcd(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            var temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

}
