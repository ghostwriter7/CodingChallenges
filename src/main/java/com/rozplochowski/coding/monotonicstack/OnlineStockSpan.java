package com.rozplochowski.coding.monotonicstack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.
 * <p>
 * The span of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward) for which the stock price was less than or equal to the price of that day.
 * <p>
 * For example, if the prices of the stock in the last four days is [7,2,1,2] and the price of the stock today is 2, then the span of today is 4 because starting from today, the price of the stock was less than or equal 2 for 4 consecutive days.
 * Also, if the prices of the stock in the last four days is [7,34,1,2] and the price of the stock today is 8, then the span of today is 3 because starting from today, the price of the stock was less than or equal 8 for 3 consecutive days.
 * Implement the StockSpanner class:
 * <p>
 * StockSpanner() Initializes the object of the class.
 * int next(int price) Returns the span of the stock's price given that today's price is price.
 *
 */
public class OnlineStockSpan {
    public static class StockSpanner {
        private final List<Integer> prices = new ArrayList<>();
        private final Deque<Integer> stack = new ArrayDeque<>();

        public int next(int price) {
            prices.add(price);

            while (!stack.isEmpty() && prices.get(stack.peekFirst()) <= price) {
                stack.pop();
            }

            var answer = stack.isEmpty() ? prices.size() : prices.size() - stack.peekFirst() - 1;

            stack.push(prices.size() - 1);

            return answer;
        }
    }
}
