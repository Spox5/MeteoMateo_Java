package weather.forecastFunctions;

import weather.converters.DateConverter;
import weather.api.Weather;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import net.aksingh.owmjapis.model.HourlyWeatherForecast;

public class WeatherForecast {

    public static void weatherNow (Weather weather, Label currentCityCityNameLabel, Label currentCityDateLabel,
                                   Label currentCityTemperatureLabel, Label currentCityHumidityLabel,
                                   Label currentCityPressureLabel, ImageView currentCityIconWeather,
                                   Label currentCityDescriptionLabel) {

        currentCityCityNameLabel.setText(weather.city);
        currentCityDateLabel.setText(weather.cityDate);
        currentCityTemperatureLabel.setText(weather.temperature);
        currentCityHumidityLabel.setText(weather.humidity);
        currentCityPressureLabel.setText(weather.pressure);
        currentCityIconWeather.setImage(new Image(weather.iconPath));
        currentCityDescriptionLabel.setText(weather.cityDescription);
    }

    public static void currentDayRestHoursForecast(HourlyWeatherForecast hourlyWeatherForecast, String city, GridPane currentDayRestHoursForecastPanel) {

        int column = 0;

        for (int i = 0; i < hourlyWeatherForecast.getDataList().size(); ++i) {

            if (DateConverter.convertDate(String.valueOf(hourlyWeatherForecast.getDataList().get(i).getDateTime())).equals(city)) {

                String substring = hourlyWeatherForecast.getDataList().get(i).getDateTimeText().substring(11, 13);
                if ("06".equals(substring) || "09".equals(substring) || "12".equals(substring) || "15".equals(substring) || "18".equals(substring)) {
                    getDataForNextDays(hourlyWeatherForecast, currentDayRestHoursForecastPanel, column, 0, i);
                    column = column + 1;
                }
            }
        }
    }

    public static void forecastForNextDays(HourlyWeatherForecast hourlyWeatherForecast, String city,
                                           GridPane dailyPanel) {
        int rowIndexDate = 0;
        int rowIndexWeather = 1;
        int column = 0;

        for (int i = 0; i < hourlyWeatherForecast.getDataList().size(); ++i) {

            if (!DateConverter.convertDate(String.valueOf(hourlyWeatherForecast.getDataList().get(i).getDateTime())).equalsIgnoreCase(city)) {

                String substring = hourlyWeatherForecast.getDataList().get(i).getDateTimeText().substring(11, 13);
                if ("06".equals(substring)) {
                    VBox dailyDate = new VBox();
                    dailyDate.setSpacing(15);

                    dailyDate.setAlignment(Pos.CENTER);
                    Separator sep = new Separator();

                    Label dayDate = new Label();
                    dayDate.setFont(Font.font("Arial", FontWeight.BOLD, 15));
                    dayDate.setText(DateConverter.convertDate(String.valueOf(hourlyWeatherForecast.getDataList().get(i).getDateTime())));

                    GridPane.setHalignment(dayDate, HPos.CENTER);
                    dailyDate.getChildren().addAll(sep, dayDate);
                    dailyPanel.add(dailyDate, 0, rowIndexDate, 5, 1);

                    column = 0;
                    getDataForNextDays(hourlyWeatherForecast, dailyPanel, column, rowIndexWeather, i);
                    column = column + 1;
                } else if ("09".equals(substring) || "12".equals(substring) || "15".equals(substring)) {
                    getDataForNextDays(hourlyWeatherForecast, dailyPanel, column, rowIndexWeather, i);
                    column = column + 1;
                } else if ("18".equals(substring)) {
                    getDataForNextDays(hourlyWeatherForecast, dailyPanel, column, rowIndexWeather, i);
                    column = column + 1;

                    rowIndexWeather = rowIndexWeather + 2;
                    rowIndexDate = rowIndexDate + 2;
                }
            }
        }
    }

    public static void getDataForNextDays(HourlyWeatherForecast hourlyWeatherForecast, GridPane dailyPanel, int columnIndex, int rowIndexWeather, int i) {

        VBox hourData = new VBox();
        hourData.setPadding(new Insets(5, 0, 15, 0));
        hourData.setAlignment(Pos.CENTER);

        Image icon = new Image(hourlyWeatherForecast.getDataList().get(i).getWeatherList().get(0).getIconLink());
        ImageView hourlyIcon = new ImageView();

        Label currentDayHour = new Label();

        Label currentDayHourTemperature = new Label();

        currentDayHour.setText(hourlyWeatherForecast.getDataList().get(i).getDateTimeText().substring(11, 16));

        hourlyIcon.setImage(icon);

        currentDayHourTemperature.setText(hourlyWeatherForecast.getDataList().get(i).getMainData().getTemp() + "\u00b0C");

        hourData.getChildren().addAll(currentDayHour, hourlyIcon, currentDayHourTemperature);

        dailyPanel.add(hourData, columnIndex, rowIndexWeather);
    }
}
