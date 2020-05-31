package weather.model.readers;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import javafx.scene.control.TextField;
import weather.config.Config;
import weather.model.exception.InvalidCityNameException;

public class GetCityID {

    public static int getCityID(TextField textBox) throws InvalidCityNameException {

        int cityID;
        String path = Config.CITY_LIST_WITH_DATA;
        String cityNameFromTextBox = textBox.getText();
        String cityNameFromCityList;

        JsonArray cityList = JsonFileReader.getCitiesList(path);

        for (JsonElement city : cityList) {

            JsonObject cityInfo = (JsonObject) city;
            cityNameFromCityList = String.valueOf(cityInfo.get("name"));

            if (cityNameFromTextBox.equals("")) {

                throw new InvalidCityNameException();

            } else if (cityNameFromCityList.equals("\"" + cityNameFromTextBox + "\"")) {

                cityID = Integer.parseInt(String.valueOf(cityInfo.get("id")));
                return cityID;
            }
        }
        return 0;
    }
}
