package Weather.forecastFunctions;

import Weather.Interface.BackgroundToday;
import Weather.Interface.Interface;
import Weather.readers.JsonFileReader;
import com.google.gson.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import net.aksingh.owmjapis.api.APIException;

import java.io.*;

public class FindCity {

    public static void findCity(String filePath, GridPane currentDayRestHours, GridPane dailyPanel, TextField cityName,
                                Label info, Label currentCityCityNameLabel, Label currentCityDateLabel,
                                Label currentCityTemperatureLabelInstrciption, Label currentCityTemperatureLabel,
                                Label currentCityHumidityLabelInstrciption, Label currentCityHumidityLabel,
                                Label currentCityPressureLabelInstrciption, Label currentCityPressureLabel,
                                ImageView currentCityIconWeather, Label currentCityDescriptionLabel,
                                Label currentDayRestHoursInstrciption, AnchorPane background) {

        Interface.clearInterface(currentDayRestHours, dailyPanel);

        int cityID = FindCity.getCityID(cityName, info, filePath);

        try {

            Interface.show(info, background, currentCityCityNameLabel, currentCityDateLabel,
                    currentCityTemperatureLabelInstrciption, currentCityTemperatureLabel,
                    currentCityHumidityLabelInstrciption, currentCityHumidityLabel,
                    currentCityPressureLabelInstrciption, currentCityPressureLabel, currentCityIconWeather,
                    currentCityDescriptionLabel, currentDayRestHoursInstrciption, currentDayRestHours, dailyPanel);

            OWMApiCall owm = new OWMApiCall(cityID);

            WeatherForecast.weatherNow(owm, currentCityCityNameLabel, currentCityDateLabel,
                    currentCityTemperatureLabel, currentCityHumidityLabel, currentCityPressureLabel,
                    currentCityIconWeather, currentCityDescriptionLabel);

            BackgroundToday.setBackground(background, owm.getCurrentCityDescription());

            WeatherForecast.currentDayRestHoursForecast(owm, currentDayRestHours);

            WeatherForecast.forecastForNextDays(owm, dailyPanel);

        } catch (APIException e) {
            System.out.println("dfs");
            e.printStackTrace();
            Interface.showError("Błędna miejscowość." ,info, background, currentCityCityNameLabel,
                    currentCityDateLabel,
                    currentCityTemperatureLabelInstrciption, currentCityTemperatureLabel,
                    currentCityHumidityLabelInstrciption, currentCityHumidityLabel,
                    currentCityPressureLabelInstrciption, currentCityPressureLabel, currentCityIconWeather,
                    currentCityDescriptionLabel, currentDayRestHoursInstrciption, currentDayRestHours, dailyPanel);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            Interface.showError("Brak/nieprawidłowy klucz API. Pobierz klucz API OpenWeatherMap." ,info, background,
                    currentCityCityNameLabel,
                    currentCityDateLabel,
                    currentCityTemperatureLabelInstrciption, currentCityTemperatureLabel,
                    currentCityHumidityLabelInstrciption, currentCityHumidityLabel,
                    currentCityPressureLabelInstrciption, currentCityPressureLabel, currentCityIconWeather,
                    currentCityDescriptionLabel, currentDayRestHoursInstrciption, currentDayRestHours, dailyPanel);
        }
    }

    public static int getCityID(TextField textBox, Label info, String path) {

        int cityID;
        String cityNameFromTextBox = textBox.getText();
        String cityNameFromCityList;
        JsonParser jsonParser = new JsonParser();

        Reader reader = JsonFileReader.readJsonFile(path);

        Object obj = jsonParser.parse(reader);
        JsonArray cityList = (JsonArray) obj;

        for (JsonElement city : cityList) {

            JsonObject cityInfo = (JsonObject) city;
            cityNameFromCityList = String.valueOf(cityInfo.get("name"));

            if (cityNameFromTextBox.equals("")) {

                info.setText("Wpisz nazwę miejscowości.");

            } else if (cityNameFromCityList.equals("\"" + cityNameFromTextBox + "\"")) {

                cityID = Integer.parseInt(String.valueOf(cityInfo.get("id")));
                return cityID;

            } else {
                info.setText("Nie ma takiej miejscowści w bazie danych. Wpisz ponownie.");
            }
        }
        return 0;
    }
}