package weather.readers;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonFileReader {

    public static Reader readJsonFile(String filePath) {

        try {

            return Files.newBufferedReader(Paths.get(filePath));

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
