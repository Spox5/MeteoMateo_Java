package Weather.appInterface;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class WeatherRenderer {

    public static void show(Label info, AnchorPane background, Label currentCityCityNameLabel,
                              Label currentCityDateLabel, Label currentCityTemperatureLabelInstrciption,
                              Label currentCityTemperatureLabel, Label currentCityHumidityLabelInstrciption,
                              Label currentCityHumidityLabel, Label currentCityPressureLabelInstrciption,
                              Label currentCityPressureLabel, ImageView currentCityIconWeather,
                              Label currentCityDescriptionLabel, Label currentDayRestHoursInstrciption,
                              GridPane currentDayRestHours, GridPane dailyPanel) {

        info.setVisible(false);
        background.setVisible(true);
        currentCityCityNameLabel.setVisible(true);
        currentCityDateLabel.setVisible(true);
        currentCityTemperatureLabelInstrciption.setVisible(true);
        currentCityTemperatureLabel.setVisible(true);
        currentCityHumidityLabelInstrciption.setVisible(true);
        currentCityHumidityLabel.setVisible(true);
        currentCityPressureLabelInstrciption.setVisible(true);
        currentCityPressureLabel.setVisible(true);
        currentCityIconWeather.setVisible(true);
        currentCityDescriptionLabel.setVisible(true);

        currentDayRestHoursInstrciption.setVisible(true);
        currentDayRestHours.setVisible(true);
        dailyPanel.setVisible(true);
    }

    public static void showError(String infoText, Label info, AnchorPane background, Label currentCityCityNameLabel,
                                  Label currentCityDateLabel, Label currentCityTemperatureLabelInstrciption,
                                  Label currentCityTemperatureLabel, Label currentCityHumidityLabelInstrciption,
                                  Label currentCityHumidityLabel, Label currentCityPressureLabelInstrciption,
                                  Label currentCityPressureLabel, ImageView currentCityIconWeather,
                                  Label currentCityDescriptionLabel, Label currentDayRestHoursInstrciption,
                                  GridPane currentDayRestHours, GridPane dailyPanel) {

        info.setText(infoText);
        info.setVisible(true);
        background.setVisible(false);
        currentCityCityNameLabel.setVisible(false);
        currentCityDateLabel.setVisible(false);
        currentCityTemperatureLabelInstrciption.setVisible(false);
        currentCityTemperatureLabel.setVisible(false);
        currentCityHumidityLabelInstrciption.setVisible(false);
        currentCityHumidityLabel.setVisible(false);
        currentCityPressureLabelInstrciption.setVisible(false);
        currentCityPressureLabel.setVisible(false);
        currentCityIconWeather.setVisible(false);
        currentCityDescriptionLabel.setVisible(false);

        currentDayRestHoursInstrciption.setVisible(false);
        currentDayRestHours.setVisible(false);
        dailyPanel.setVisible(false);
    }

    public static void clearInterface(GridPane today, GridPane restDays) {

        today.getChildren().clear();
        restDays.getChildren().clear();
    }

}
