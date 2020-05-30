package weather.readers;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonFileReader {

    public static Reader readJsonFile(String filePath) {

        try {

            return Files.newBufferedReader(Paths.get(JsonFileReader.class.getResource(filePath).toURI()));
            //return Files.newBufferedReader(Paths.get(filePath));

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static JsonArray getCitiesList(String path) {

        Reader reader = readJsonFile(path);
        JsonParser jsonParser = new JsonParser();
        Object obj = jsonParser.parse(reader);
        JsonArray cityList = (JsonArray) obj;
        return  cityList;
    }
}
