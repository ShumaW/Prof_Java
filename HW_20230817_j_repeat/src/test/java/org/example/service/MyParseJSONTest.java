package org.example.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyParseJSONTest {

    String filePath1 = "src/test/resources/null.json";

    String filePath2 = "src/test/resources/empty.json";

    @Test
    void parseNullExceptionTest() {
        assertThrows(RuntimeException.class, () -> MyParseJSON.parse(filePath1));
    }

    @Test
    void parseEmptyExceptionTest() {
        assertThrows(RuntimeException.class, () -> MyParseJSON.parse(filePath2));
    }
}