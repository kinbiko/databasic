package databasic;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AutoIdGenerator {

    DatabasicId generate() {
        String fileContents = read("currentid");
        long idLong = findId(fileContents);
        long incrementedId = incrementId(idLong);
        write(incrementedId);
        return new DatabasicId(incrementedId);
    }

    private String read(String path) {
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(path));
            return new String(encoded, Charset.defaultCharset());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private long findId(String fileContents) {
        return Long.parseLong(fileContents);
    }

    private long incrementId(long idLong) {
        return idLong + 2;
    }

    private void write(long incrementedId) {
        String incrementIdString = "" + incrementedId;
        try {
            Files.write(Paths.get("currentid"), incrementIdString.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}