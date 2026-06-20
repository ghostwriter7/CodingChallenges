package com.rozplochowski.coding.arraystring;

/**
 * You have a long flowerbed in which some plots are planted, and some are not.
 * However, flowers cannot be planted in adjacent plots.
 * <p>
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty,
 * and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
 */
class CanPlaceFlowers {

    boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length < n) return false;
        if (n == 0) return true;

        var count = 0;

        for (var i = 0; i < flowerbed.length; i++) {
            var curr = flowerbed[i];

            if (curr == 1) i++;

            var prev = i - 1 >= 0 ? flowerbed[i - 1] : 0;
            var next = i + 1 < flowerbed.length ? flowerbed[i + 1] : 0;

            if (prev == 0 && next == 0) {
                flowerbed[i] = 1;
                count++;
            }

            if (count == n) return true;
        }

        return false;
    }
}
