package weather.model.appInterface;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class WeatherRenderer {

    private final Label info;
    private final AnchorPane background;
    private final Label currentCityCityNameLabel;
    private final Label currentCityDateLabel;
    private final Label currentCityTemperatureLabelInstrciption;
    private final Label currentCityTemperatureLabel;
    private final Label currentCityHumidityLabelInstrciption;
    private final Label currentCityHumidityLabel;
    private final Label currentCityPressureLabelInstrciption;
    private final Label currentCityPressureLabel;
    private final ImageView currentCityIconWeather;
    private final Label currentCityDescriptionLabel;
    private final Label currentDayRestHoursInstrciption;
    private final GridPane currentDayRestHours;
    private final GridPane dailyPanel;

    public WeatherRenderer(Label info, AnchorPane background, Label currentCityCityNameLabel,
                           Label currentCityDateLabel, Label currentCityTemperatureLabelInstrciption,
                           Label currentCityTemperatureLabel, Label currentCityHumidityLabelInstrciption,
                           Label currentCityHumidityLabel, Label currentCityPressureLabelInstrciption,
                           Label currentCityPressureLabel, ImageView currentCityIconWeather,
                           Label currentCityDescriptionLabel, Label currentDayRestHoursInstrciption,
                           GridPane currentDayRestHours, GridPane dailyPanel) {

        this.info = info;
        this.background = background;
        this.currentCityCityNameLabel = currentCityCityNameLabel;
        this.currentCityDateLabel = currentCityDateLabel;
        this.currentCityTemperatureLabelInstrciption = currentCityTemperatureLabelInstrciption;
        this.currentCityTemperatureLabel = currentCityTemperatureLabel;
        this.currentCityHumidityLabelInstrciption = currentCityHumidityLabelInstrciption;
        this.currentCityHumidityLabel = currentCityHumidityLabel;
        this.currentCityPressureLabelInstrciption = currentCityPressureLabelInstrciption;
        this.currentCityPressureLabel = currentCityPressureLabel;
        this.currentCityIconWeather = currentCityIconWeather;
        this.currentCityDescriptionLabel = currentCityDescriptionLabel;
        this.currentDayRestHoursInstrciption = currentDayRestHoursInstrciption;
        this.currentDayRestHours = currentDayRestHours;
        this.dailyPanel = dailyPanel;
    }

    public void show() {

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

    public void showError(String infoText) {

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
}
