package com.rozplochowski.coding.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days
 * you have to wait after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 */
public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] answers = new int[temperatures.length];

        Deque<Integer> stack = new ArrayDeque<>();
        stack.offer(0);
        
        for (var i = 0; i < temperatures.length; i++) {
            var value = temperatures[i];

            while (!stack.isEmpty() && value > temperatures[stack.peek()]) {
                var day = stack.poll();
                answers[day] = i - day;
            }

            stack.push(i);
        }

        return answers;
    }
}
