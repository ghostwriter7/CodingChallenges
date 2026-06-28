package com.rozplochowski.coding.binarysearch;

public class GuessNumber {
    private final int answer;

    public GuessNumber(int answer) {
        this.answer = answer;
    }

    public int guessNumber(int n) {
        var lo = 1;
        var hi = n;
        var mid = lo + (hi - lo) / 2;

        while (lo < hi) {
            var choice = guess(mid);
            if (choice == 0) return mid;
            else if (choice == -1) hi = mid;
            else lo = mid + 1;

            mid = lo + (hi - lo) / 2;
        }

        return mid;
    }

    private int guess(int n) {
        if (n == answer) return 0;
        return n > answer ? -1 : 1;
    }
}
