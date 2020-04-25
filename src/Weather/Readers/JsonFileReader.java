package Weather.readers;

import javafx.scene.control.Label;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonFileReader {

    public static Reader readJsonFile(String filePath) {

        try {

            Reader file = Files.newBufferedReader(Paths.get(filePath));
            return file;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
