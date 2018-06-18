package databasic;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.File;

public class InserterTest {

    @Test
    public void canInsertFile() {
        String target = "text.txt";
        Assert.assertEquals(target, "text.txt");
    }
}