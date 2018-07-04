package databasic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JsonPathTest {

    @Test
    public void canWriteAndGetJsonPath() {
        JsonPath target = new JsonPath();
        target.setJsonPath("number.value");
        String result = target.getJsonPath();
        Assertions.assertEquals("number.value", result);
    }

    @Test
    public void givenNullString_throwsRuntimeException() {
        JsonPath target = new JsonPath();

        try {
            target.setJsonPath(null);
            Assertions.fail("");
        } catch (RuntimeException re) {
        }
    }

    @Test
    public void givenEmptyString_throwsRuntimeException() {
        JsonPath target = new JsonPath();

        try {
            target.setJsonPath("");
            Assertions.fail("");
        } catch (RuntimeException re) {
        }
    }

    @Test
    public void givenStringWithSpace_throwsRuntimeException() {
        JsonPath target = new JsonPath();

        try {
            target.setJsonPath(" value ");
            Assertions.fail("");
        } catch (RuntimeException re) {
        }
    }

}