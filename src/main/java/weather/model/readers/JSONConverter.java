package weather.model.readers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class JSONConverter {

    public Map<String, Integer> getCitiesMapFromJSON(String source) throws FileNotFoundException {

        try {
            Map<String, Integer> citiesMap =
                    new TreeMap<>();

            JsonReader reader = new JsonReader(new InputStreamReader(getClass().getResourceAsStream(source)));
            Gson gson = new GsonBuilder().create();
            City[] cities = gson.fromJson(reader, City[].class);

            for (City city : cities) {
                citiesMap.put(city.getName() + "," + city.getCountry(), city.getId());
            }

            return citiesMap;
        } catch (NullPointerException | JsonSyntaxException e) {
            throw new FileNotFoundException();
        }
    }
}
