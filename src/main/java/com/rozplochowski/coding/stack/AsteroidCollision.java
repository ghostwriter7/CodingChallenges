package com.rozplochowski.coding.stack;

import java.util.Arrays;

/**
 * We are given an array asteroids of integers representing asteroids in a row.
 * The indices of the asteroid in the array represent their relative position in space.
 *
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left).
 * Each asteroid moves at the same speed.
 *
 * Find out the state of the asteroids after all collisions.
 * If two asteroids meet, the smaller one will explode.
 * If both are the same size, both will explode.
 * Two asteroids moving in the same direction will never meet.
 */
public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {

        int[] stack = new int[asteroids.length];
        stack[0] = asteroids[0];
        int stackIndex = 0;

        for (var i = 1; i < asteroids.length; i++) {
            if (stackIndex == -1) {
                stack[++stackIndex] = asteroids[i];
                continue;
            }

            var asteroid = asteroids[i];
            var size = Math.abs(asteroid);
            var direction = asteroid > 0 ? 1 : -1;

            var prevAsteroid = stack[stackIndex];
            var prevSize = Math.abs(prevAsteroid);
            var prevDirection = prevAsteroid > 0 ? 1 : -1;

            if (direction == prevDirection || prevDirection == -1) {
                stack[++stackIndex] = asteroid;
            } else  {
                if (size < prevSize) continue;

                if (size == prevSize) {
                    stack[stackIndex--] = 0;
                    continue;
                }

                stack[stackIndex] = asteroid;

                while (stackIndex - 1 >= 0 && stack[stackIndex - 1] > 0) {
                    prevAsteroid = stack[stackIndex - 1];
                    prevSize = Math.abs(prevAsteroid);

                    if (prevSize < size) {
                        stack[--stackIndex] = asteroid;
                    } else {
                        if (prevSize == size) {
                            stackIndex -= 2;
                        } else {
                            stackIndex--;
                        }

                        break;
                    }
                }
            }
        }

        return Arrays.copyOf(stack, stackIndex + 1);
    }
}
