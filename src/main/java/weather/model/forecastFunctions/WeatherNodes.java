package weather.model.forecastFunctions;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.model.CurrentWeather;
import net.aksingh.owmjapis.model.HourlyWeatherForecast;
import weather.model.api.OWMApiRepository;
import weather.model.appInterface.BackgroundToday;
import weather.model.converters.DateConverter;
import weather.model.converters.WeatherDescriptionTranslator;

public class WeatherNodes {

   private AnchorPane backgroundCurrentCity;
   private Label currentCityCityNameLabel;
   private Label currentCityDateLabel;
   private Label currentCityTemperatureLabel;
   private Label currentCityHumidityLabel;
   private Label currentCityPressureLabel;
   private ImageView currentCityIconWeather;
   private Label currentCityDescriptionLabel;
   private GridPane currentDayCurrentCityRestHours;
   private GridPane dailyPanel;

    public WeatherNodes(AnchorPane backgroundCurrentCity,
                        Label currentCityCityNameLabel, Label currentCityDateLabel,
                        Label currentCityTemperatureLabel, Label currentCityHumidityLabel,
                        Label currentCityPressureLabel, ImageView currentCityIconWeather,
                        Label currentCityDescriptionLabel, GridPane currentDayCurrentCityRestHours,
                        GridPane dailyPanel) {

        this.backgroundCurrentCity = backgroundCurrentCity;
        this.currentCityCityNameLabel = currentCityCityNameLabel;
        this.currentCityDateLabel = currentCityDateLabel;
        this.currentCityTemperatureLabel = currentCityTemperatureLabel;
        this.currentCityHumidityLabel = currentCityHumidityLabel;
        this.currentCityPressureLabel = currentCityPressureLabel;
        this.currentCityIconWeather = currentCityIconWeather;
        this.currentCityDescriptionLabel = currentCityDescriptionLabel;
        this.currentDayCurrentCityRestHours = currentDayCurrentCityRestHours;
        this.dailyPanel = dailyPanel;
    }

    public void setNodesValues(OWMApiRepository owmApiRepository, Integer cityID) throws APIException {

        CurrentWeather currentWeather = owmApiRepository.fetchWeatherForCity(cityID);
        HourlyWeatherForecast hourlyWeatherForecast = owmApiRepository.fetchHourlyWeatherForecast(cityID);

        getWeatherNowData(currentWeather, backgroundCurrentCity, currentCityCityNameLabel, currentCityDateLabel,
                currentCityTemperatureLabel, currentCityHumidityLabel, currentCityPressureLabel,
                currentCityIconWeather, currentCityDescriptionLabel);

        getWeatherTodayLaterData(hourlyWeatherForecast, DateConverter.convertDate(String.valueOf(currentWeather.getDateTime())), currentDayCurrentCityRestHours);

        getWeatherNextDaysData(hourlyWeatherForecast, DateConverter.convertDate(String.valueOf(currentWeather.getDateTime())), dailyPanel);

    }

    public static void getWeatherNowData(CurrentWeather currentWeather,
                                         AnchorPane backgroundCurrentCity, Label currentCityCityNameLabel,
                                         Label currentCityDateLabel,
                                         Label currentCityTemperatureLabel,
                                         Label currentCityHumidityLabel, Label currentCityPressureLabel,
                                         ImageView currentCityIconWeather, Label currentCityDescriptionLabel) {

        BackgroundToday.setBackground(backgroundCurrentCity,
                WeatherDescriptionTranslator.translateDescription(currentWeather.getWeatherList().get(0).getDescription()));
        currentCityCityNameLabel.setText(currentWeather.getCityName());
        currentCityDateLabel.setText(DateConverter.convertDate(String.valueOf(currentWeather.getDateTime())));
        currentCityTemperatureLabel.setText(currentWeather.getMainData().getTemp() + "\u00b0C");
        currentCityHumidityLabel.setText(currentWeather.getMainData().getHumidity() + "%");
        currentCityPressureLabel.setText(currentWeather.getMainData().getPressure() + " HPa");
        currentCityIconWeather.setImage(new Image(currentWeather.getWeatherList().get(0).getIconLink()));
        currentCityDescriptionLabel.setText(WeatherDescriptionTranslator.translateDescription(currentWeather.getWeatherList().get(0)
                .getDescription()));
    }

    public static void getWeatherTodayLaterData(HourlyWeatherForecast hourlyWeatherForecast, String city, GridPane currentDayRestHoursForecastPanel) {

        int column = 0;

        for (int i = 0; i < hourlyWeatherForecast.getDataList().size(); ++i) {

            if (DateConverter.convertDate(String.valueOf(hourlyWeatherForecast.getDataList().get(i).getDateTime())).equals(city)) {

                String substring = hourlyWeatherForecast.getDataList().get(i).getDateTimeText().substring(11, 13);
                if ("06".equals(substring) || "09".equals(substring) || "12".equals(substring) || "15".equals(substring) || "18".equals(substring)) {
                    getWeatherOneNextDayData(hourlyWeatherForecast, currentDayRestHoursForecastPanel, column, 0, i);
                    column = column + 1;
                }
            }
        }
    }

    public static void getWeatherNextDaysData(HourlyWeatherForecast hourlyWeatherForecast, String city,
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
                    getWeatherOneNextDayData(hourlyWeatherForecast, dailyPanel, column, rowIndexWeather, i);
                    column = column + 1;
                } else if ("09".equals(substring) || "12".equals(substring) || "15".equals(substring)) {
                    getWeatherOneNextDayData(hourlyWeatherForecast, dailyPanel, column, rowIndexWeather, i);
                    column = column + 1;
                } else if ("18".equals(substring)) {
                    getWeatherOneNextDayData(hourlyWeatherForecast, dailyPanel, column, rowIndexWeather, i);
                    column = column + 1;

                    rowIndexWeather = rowIndexWeather + 2;
                    rowIndexDate = rowIndexDate + 2;
                }
            }
        }
    }

    public static void getWeatherOneNextDayData(HourlyWeatherForecast hourlyWeatherForecast, GridPane dailyPanel, int columnIndex, int rowIndexWeather, int i) {

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
