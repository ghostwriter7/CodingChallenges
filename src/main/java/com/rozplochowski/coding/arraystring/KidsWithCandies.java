package com.rozplochowski.coding.arraystring;

/**
 * There are n kids with candies.
 * You are given an integer array candies, where each candies[i] represents the number of candies the ith kid has,
 * and an integer extraCandies, denoting the number of extra candies that you have.
 * <p>
 * Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies, they will have the greatest number of candies among all the kids, or false otherwise.
 * Note that multiple kids can have the greatest number of candies.
 */
class KidsWithCandies {

    boolean[] kidsWithCandies(int[] candies, int extraCandies) {
        var maxCandies = 0;
        for (var candy : candies) {
            maxCandies = Math.max(maxCandies, candy);
        }

        var result = new boolean[candies.length];
        for (var i = 0; i < candies.length; i++) {
            result[i] = candies[i] + extraCandies >= maxCandies;
        }

        return result;
    }
}
