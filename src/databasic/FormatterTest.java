package databasic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class FormatterTest {
    private Formatter target = new Formatter();

    @Test
    void givenNullObject_NoResults() {
        runFormatQueryTest("No results", null);
    }

    @Test
    void givenEmptyString_ReturnEmptyStringMessage() {
        runFormatQueryTest("String Contents: Empty String", "");
    }

    @Test
    void givenNonEmptyString_ReturnString() {
        runFormatQueryTest("Fish", "Fish");
    }

    @Test
    void givenChar_ReturnChar() {
        runFormatQueryTest("a", 'a');
    }

    @Test
    void givenInt_ReturnInt() {
        runFormatQueryTest("5", 5);
    }

    @Test
    void givenFloat_ReturnFloat() {
        runFormatQueryTest("3.142", 3.142);
    }

    @Test
    void givenBoolean_ReturnBoolean() {
        runFormatQueryTest("true", true);
        runFormatQueryTest("false", false);
    }

    @Test
    void givenIntArray_ReturnArray() {
        runFormatQueryTest("[1, 2, 3]", new Integer[]{1, 2, 3});
    }

    @Test
    void givenStringArray_ReturnArray() {
        runFormatQueryTest("[\"a\", \"b\", \"c\"]", new String[]{"a", "b", "c"});
    }


    @Test
    void givenMixedTypeArray_ReturnArray() {
        runFormatQueryTest("[\"a\", 2, 3.14]", new Object[]{"a", 2, 3.14});
    }

    @Test
    void givenUnicodeChar_ReturnArray() {
        runFormatQueryTest("[\"♪\", \"ツ\", \"♕\", \"∂\"]", new char[]{'♪', 'ツ', '♕', '∂'});
    }
    //TODO create test for nested JSON objects (Maps)

    private void runFormatQueryTest(String expected, Object input) {
        assertEquals(expected, target.formatQuery(input));
    }
}