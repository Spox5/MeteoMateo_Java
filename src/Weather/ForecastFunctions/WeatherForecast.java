package Weather.forecastFunctions;

import Weather.converters.DateConverter;
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


public class WeatherForecast {

    public static void weatherNow(OWMApiCall owm, Label currentCityCityNameLabel, Label currentCityDateLabel,
                                  Label currentCityTemperatureLabel, Label currentCityHumidityLabel,
                                  Label currentCityPressureLabel, ImageView currentCityIconWeather,
                                  Label currentCityDescriptionLabel) {

        currentCityCityNameLabel.setText(owm.getCityName());
        currentCityDateLabel.setText(owm.getCurrentCityDate());

        currentCityTemperatureLabel.setText(owm.getCurrentCityTemperature());
        currentCityHumidityLabel.setText(owm.getCurrentCityHumidity());
        currentCityPressureLabel.setText(owm.getCurrentCityPressure());
        currentCityIconWeather.setImage(new Image(owm.getCurrentIconPath()));
        currentCityDescriptionLabel.setText(owm.getCurrentCityDescription());
    }

    public static void forecastForNextDays(OWMApiCall owm, GridPane dailyPanel) {

        int rowIndexDate = 0;
        int rowIndexWeather = 1;
        int column = 0;

        for (int i = 0; i < owm.hourlyWeatherForecast.getDataList().size(); ++i) {

            if (!DateConverter.dateConvert(String.valueOf(owm.hourlyWeatherForecast.getDataList().get(i).getDateTime())).equals(owm.getCurrentCityDate())) {

                switch (owm.hourlyWeatherForecast.getDataList().get(i).getDateTimeText().substring(11,13)) {

                    case "06":
                        VBox dailyDate = new VBox();
                        dailyDate.setSpacing(15);

                        dailyDate.setAlignment(Pos.CENTER);
                        Separator sep = new Separator();

                        Label dayDate = new Label();
                        dayDate.setFont(Font.font("Arial", FontWeight.BOLD, 15));
                        dayDate.setText(DateConverter.dateConvert(String.valueOf(owm.hourlyWeatherForecast.getDataList().get(i).getDateTime())));

                        GridPane.setHalignment(dayDate, HPos.CENTER);
                        dailyDate.getChildren().addAll(sep, dayDate);
                        dailyPanel.add(dailyDate, 0, rowIndexDate, 5, 1);

                        column = 0;
                        getDataForNextDays(owm, dailyPanel, column, rowIndexWeather, i);
                        column = column + 1;
                        break;

                    case "09":
                    case "12":
                    case "15":
                        getDataForNextDays(owm, dailyPanel, column, rowIndexWeather, i);
                        column = column + 1;
                        break;

                    case "18":
                        getDataForNextDays(owm, dailyPanel, column, rowIndexWeather, i);
                        column = column + 1;

                        rowIndexWeather = rowIndexWeather + 2;
                        rowIndexDate = rowIndexDate + 2;
                        break;
                }
            }
        }
    }

    public static void getDataForNextDays(OWMApiCall owm, GridPane dailyPanel, int columnIndex, int rowIndexWeather, int i) {

        VBox hourData = new VBox();
        hourData.setPadding(new Insets(5, 0, 15, 0));
        hourData.setAlignment(Pos.CENTER);

        Image icon = new Image(owm.hourlyWeatherForecast.getDataList().get(i).getWeatherList().get(0).getIconLink());
        ImageView hourlyIcon = new ImageView();

        Label currentDayHour = new Label();

        Label currentDayHourTemperature = new Label();

        currentDayHour.setText(owm.hourlyWeatherForecast.getDataList().get(i).getDateTimeText().substring(11, 16));

        hourlyIcon.setImage(icon);

        currentDayHourTemperature.setText(owm.hourlyWeatherForecast.getDataList().get(i).getMainData().getTemp() + "\u00b0C");

        hourData.getChildren().addAll(currentDayHour, hourlyIcon, currentDayHourTemperature);

        dailyPanel.add(hourData, columnIndex, rowIndexWeather);
    }

    public static void currentDayRestHoursForecast(OWMApiCall owm, GridPane currentDayRestHoursForecastPanel) {

        int column = 0;

        for (int i = 0; i < owm.hourlyWeatherForecast.getDataList().size(); ++i) {

            if (DateConverter.dateConvert(String.valueOf(owm.hourlyWeatherForecast.getDataList().get(i).getDateTime())).equals(owm.getCurrentCityDate())) {

                switch (owm.hourlyWeatherForecast.getDataList().get(i).getDateTimeText().substring(11,13)) {
                    case "06":
                    case "09":
                    case "12":
                    case "15":
                    case "18":
                        getDataForNextDays(owm, currentDayRestHoursForecastPanel, column, 0, i);
                        column = column + 1;
                        break;
                }
            }
        }
    }
}