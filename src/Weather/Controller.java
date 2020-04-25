package weather;

import weather.forecastFunctions.WeatherResolver;
import weather.readers.AutoCompleteTextField;
import weather.forecastFunctions.OWMApiRepository;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML Button start = new Button();

    // CURRENT PANEL //
    @FXML Label infoCurrent = new Label();
    @FXML AnchorPane backgroundCurrentCity = new AnchorPane();
    @FXML TextField cityNameCurrent = new TextField();
    @FXML Label currentCityCityNameLabel = new Label();
    @FXML Label currentCityDateLabel = new Label();
    @FXML Label currentCityTemperatureLabelInstrciption = new Label();
    @FXML Label currentCityTemperatureLabel = new Label();
    @FXML Label currentCityHumidityLabelInstrciption = new Label();
    @FXML Label currentCityHumidityLabel = new Label();
    @FXML Label currentCityPressureLabelInstrciption = new Label();
    @FXML Label currentCityPressureLabel = new Label();
    @FXML ImageView currentCityIconWeather = new ImageView();
    @FXML Label currentCityDescriptionLabel = new Label();
    // END CURRENT CITY PANEL //

    // CURRENT FUTURE PANEL //
    @FXML Label currentDayCurrentCityRestHoursInstrciption = new Label();
    @FXML GridPane currentDayCurrentCityRestHours = new GridPane();
    @FXML GridPane dailyPanelCurrentCity = new GridPane();
    // END FUTURE PANEL //

    // TARGET PANEL //
    @FXML Label infoTarget = new Label();
    @FXML AnchorPane backgroundTargetCity = new AnchorPane();
    @FXML TextField cityNameTarget = new TextField();
    @FXML Label targetCityCityNameLabel = new Label();
    @FXML Label targetCityDateLabel = new Label();
    @FXML Label targetCityTemperatureLabelInstrciption = new Label();
    @FXML Label targetCityTemperatureLabel = new Label();
    @FXML Label targetCityHumidityLabelInstrciption = new Label();
    @FXML Label targetCityHumidityLabel = new Label();
    @FXML Label targetCityPressureLabelInstrciption = new Label();
    @FXML Label targetCityPressureLabel = new Label();
    @FXML ImageView targetCityIconWeather = new ImageView();
    @FXML Label targetCityDescriptionLabel = new Label();
    //END TARGET PANEL //

    //TARGET FUTURE PANEL//
    @FXML Label currentDayTargetCityRestHoursInstrciption = new Label();
    @FXML GridPane currentDayTargetCityRestHours = new GridPane();
    @FXML GridPane dailyPanelTargetCity = new GridPane();
    // END FUTURE PANEL //

    private WeatherResolver weatherResolver = new WeatherResolver(new OWMApiRepository());

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {

            AutoCompleteTextField.autoComplete(cityNameTarget, "src/city_names.json");
            AutoCompleteTextField.autoComplete(cityNameCurrent, "src/city_names.json");

        } catch (Exception e) {
            infoCurrent.setText("Plik źródłowy nie znaleziony. Skontaktuj się z autorem lub pobierz repozytorium ponownie");
            infoTarget.setText("Plik źródłowy nie znaleziony. Skontaktuj się z autorem lub pobierz repozytorium ponownie");
        }
    }

    public void findCurrentCity() {

        weatherResolver.resolveWeather("src/city.list.min.json", currentDayCurrentCityRestHours,
                dailyPanelCurrentCity, cityNameCurrent,
                infoCurrent, currentCityCityNameLabel, currentCityDateLabel, currentCityTemperatureLabelInstrciption,
                currentCityTemperatureLabel,
                currentCityHumidityLabelInstrciption, currentCityHumidityLabel, currentCityPressureLabelInstrciption, currentCityPressureLabel,
                currentCityIconWeather, currentCityDescriptionLabel, currentDayCurrentCityRestHoursInstrciption, backgroundCurrentCity);

    }

    public void findTargetCity() {

        weatherResolver.resolveWeather("src/city.list.min.json", currentDayTargetCityRestHours,
                dailyPanelTargetCity, cityNameTarget,
                infoTarget, targetCityCityNameLabel, targetCityDateLabel, targetCityTemperatureLabelInstrciption,
                targetCityTemperatureLabel,
                targetCityHumidityLabelInstrciption, targetCityHumidityLabel, targetCityPressureLabelInstrciption, targetCityPressureLabel,
                targetCityIconWeather, targetCityDescriptionLabel, currentDayTargetCityRestHoursInstrciption,
                backgroundTargetCity);
    }
}
