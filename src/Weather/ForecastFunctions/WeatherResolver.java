package weather.forecastFunctions;

import weather.appInterface.BackgroundToday;
import weather.appInterface.WeatherRenderer;
import weather.readers.JsonFileReader;
import weather.api.Weather;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.model.HourlyWeatherForecast;

import java.io.Reader;

public class WeatherResolver {

    private final OWMApiRepository owmApiRepository;

    public WeatherResolver (OWMApiRepository owmApiRepository) {
        this.owmApiRepository = owmApiRepository;
    }

    public void resolveWeather(String filePath, GridPane currentDayRestHours, GridPane dailyPanel, TextField cityName
            , Label info, Label currentCityCityNameLabel, Label currentCityDateLabel,
                               Label currentCityTemperatureLabelDescription, Label currentCityTemperatureLabel,
                               Label currentCityHumidityLabelDescription, Label currentCityHumidityLabel,
                               Label currentCityPressureLabelDescription, Label currentCityPressureLabel,
                               ImageView currentCityIconWeather, Label currentCityDescriptionLabel,
                               Label currentDayRestHoursDescription, AnchorPane background) {

        WeatherRenderer.clearInterface(currentDayRestHours, dailyPanel);

        int cityID = getCityID(cityName, info, filePath);

        try {

            Weather weather = owmApiRepository.fetchWeatherForCity(cityID);
            HourlyWeatherForecast hourlyWeatherForecast = owmApiRepository.fetchHourlyWeatherForecast(cityID);

            WeatherRenderer.show(info, background, currentCityCityNameLabel, currentCityDateLabel,
                    currentCityTemperatureLabelDescription, currentCityTemperatureLabel,
                    currentCityHumidityLabelDescription, currentCityHumidityLabel,
                    currentCityPressureLabelDescription, currentCityPressureLabel, currentCityIconWeather,
                    currentCityDescriptionLabel, currentDayRestHoursDescription, currentDayRestHours, dailyPanel);

            WeatherForecast.weatherNow(weather, currentCityCityNameLabel, currentCityDateLabel,
                    currentCityTemperatureLabel, currentCityHumidityLabel, currentCityPressureLabel,
                    currentCityIconWeather, currentCityDescriptionLabel);

            BackgroundToday.setBackground(background, weather.cityDescription);

            WeatherForecast.currentDayRestHoursForecast(hourlyWeatherForecast, weather.cityDate, currentDayRestHours);

            WeatherForecast.forecastForNextDays(hourlyWeatherForecast, weather.cityDate, dailyPanel);

        } catch (APIException e) {

            e.printStackTrace();
            WeatherRenderer.showError("Błędna miejscowość." ,info, background, currentCityCityNameLabel,
                    currentCityDateLabel,
                    currentCityTemperatureLabelDescription, currentCityTemperatureLabel,
                    currentCityHumidityLabelDescription, currentCityHumidityLabel,
                    currentCityPressureLabelDescription, currentCityPressureLabel, currentCityIconWeather,
                    currentCityDescriptionLabel, currentDayRestHoursDescription, currentDayRestHours, dailyPanel);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            WeatherRenderer.showError("Brak/nieprawidłowy klucz API. Pobierz klucz API OpenWeatherMap." ,info, background,
                    currentCityCityNameLabel,
                    currentCityDateLabel,
                    currentCityTemperatureLabelDescription, currentCityTemperatureLabel,
                    currentCityHumidityLabelDescription, currentCityHumidityLabel,
                    currentCityPressureLabelDescription, currentCityPressureLabel, currentCityIconWeather,
                    currentCityDescriptionLabel, currentDayRestHoursDescription, currentDayRestHours, dailyPanel);

        }
    }

    private int getCityID(TextField textBox, Label info, String path) {

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
