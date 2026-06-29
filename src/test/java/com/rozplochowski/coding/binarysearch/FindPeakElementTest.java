package com.rozplochowski.coding.binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FindPeakElementTest {

    @ParameterizedTest
    @MethodSource("cases")
    void shouldFindPeakIndex(int[] input, List<Integer> possiblePeaks) {
        var sut = new FindPeakElement();
        var actual = sut.findPeakElement(input);
        assertTrue(possiblePeaks.contains(actual));
    }

    private static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 1}, List.of(2)),
                Arguments.of(new int[]{1, 2, 1, 3, 5, 6, 4}, List.of(5)),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, List.of(9))
        );
    }

}