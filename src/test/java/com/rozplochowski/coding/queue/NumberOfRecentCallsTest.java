package com.rozplochowski.coding.queue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfRecentCallsTest {

    @ParameterizedTest
    @MethodSource("cases")
    void shouldReturnNumberOfRequestsInPast3000Milliseconds(int[] requests, int[] expectedResponses) {
        var counter = new NumberOfRecentCalls.RecentCounter();
        for (int i = 0; i < requests.length; i++) {
            assertEquals(expectedResponses[i], counter.ping(requests[i]));
        }
    }

    private static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(new int[]{1, 100}, new int[]{1, 2}),
                Arguments.of(new int[]{3, 3001, 3002, 3003, 3004, 3005}, new int[]{1, 2, 3, 4, 4, 5})
        );
    }

}