package org.example;

import java.util.stream.Collectors;

public class StringUtils {
    public static String toUpperCase(String input) {

        return input.chars()
                .mapToObj(c -> Character.isWhitespace(c) ? " " : Character.toString(Character.toUpperCase(c)))
                .collect(Collectors.joining());
    }
}
