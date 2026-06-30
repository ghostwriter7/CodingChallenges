package com.rozplochowski.coding.trie;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchSuggestionSystemTest {

    @ParameterizedTest
    @MethodSource("cases")
    void shouldReturnSuggestedProducts(String[] products, String searchWord, List<List<String>> expected) {
        SearchSuggestionSystem system = new SearchSuggestionSystem();
        List<List<String>> actual = system.suggestedProducts(products, searchWord);
        assertEquals(expected, actual);
    }

    private static Object[][] cases() {
        return new Object[][]{
                {new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse", List.of(
                        List.of("mobile", "moneypot", "monitor"),
                        List.of("mobile", "moneypot", "monitor"),
                        List.of("mouse", "mousepad"),
                        List.of("mouse", "mousepad"),
                        List.of("mouse", "mousepad")
                )},
                {new String[]{"havana"}, "havana", List.of(
                        List.of("havana"),
                        List.of("havana"),
                        List.of("havana"),
                        List.of("havana"),
                        List.of("havana"),
                        List.of("havana")
                )}
        };
    }

}