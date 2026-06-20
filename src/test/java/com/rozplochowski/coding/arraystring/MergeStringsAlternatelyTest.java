package com.rozplochowski.coding.arraystring;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MergeStringsAlternatelyTest {

    @ParameterizedTest
    @MethodSource("parameters")
    void shouldMergeStrings(List<String> list) {
        var expected = list.get(2);

        var actual = new MergeStringsAlternately().mergeAlternately(list.get(0), list.get(1));

        assertEquals(expected, actual);
    }

    static Stream<List<String>> parameters() {
        return Stream.of(
                List.of("", "", ""),
                List.of(" ", " ", "  "),
                List.of("ab", "cd", "acbd"),
                List.of("a", "abc", "aabc"),
                List.of("abc", "c", "acbc")
        );
    }

}