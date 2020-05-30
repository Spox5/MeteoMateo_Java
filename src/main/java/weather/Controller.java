package weather;

import net.aksingh.owmjapis.api.APIException;
import weather.appInterface.WeatherRenderer;
import weather.exception.InvalidCityNameException;
import weather.readers.AutoCompleteTextField;
import weather.api.OWMApiRepository;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import weather.readers.GetCityID;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML Button currentOK = new Button();

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

    private OWMApiRepository owmApiRepository;
    private TodayWeatherNodes todayWeatherCurrentNodes;
    private TodayWeatherNodes todayWeatherTargetNodes;
    private WeatherRenderer weatherCurrentRenderer;
    private WeatherRenderer weatherTargetRenderer;

    public Controller() {
        owmApiRepository = new OWMApiRepository(Config.API_KEY);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            setCurrentNodesValues();
            setTargetNodesValues();
            setCurrentNodesToRender();
            setTargetNodesToRender();

            AutoCompleteTextField.autoComplete(cityNameTarget, Config.CITIES_NAMES);
            AutoCompleteTextField.autoComplete(cityNameCurrent, Config.CITIES_NAMES);

        } catch (Exception e) {
            infoCurrent.setText("Plik źródłowy nie znaleziony. Skontaktuj się z autorem lub pobierz repozytorium ponownie");
            infoTarget.setText("Plik źródłowy nie znaleziony. Skontaktuj się z autorem lub pobierz repozytorium ponownie");
        }
    }

    public void findCurrentCity() {

        try {
            WeatherRenderer.clearInterface(currentDayCurrentCityRestHours, dailyPanelCurrentCity);
            weatherCurrentRenderer.show();
            todayWeatherCurrentNodes.setNodesValues(owmApiRepository, GetCityID.getCityID(cityNameCurrent));

        } catch (APIException e) {
            e.printStackTrace();
            weatherCurrentRenderer.showError("Błędna miejscowość.");

        } catch (InvalidCityNameException e) {
            e.printStackTrace();
            weatherCurrentRenderer.showError("Wpisz nazwę miejscowości.");

        } catch (IllegalArgumentException e) {
            weatherCurrentRenderer.showError("Brak/nieprawidłowy klucz API. Pobierz klucz API OpenWeatherMap.");
        }
    }

    public void findTargetCity() {

        try {
            WeatherRenderer.clearInterface(currentDayTargetCityRestHours, dailyPanelTargetCity);
            weatherTargetRenderer.show();
            todayWeatherTargetNodes.setNodesValues(owmApiRepository, GetCityID.getCityID(cityNameTarget));
        } catch (APIException e) {
            e.printStackTrace();
            weatherTargetRenderer.showError("Błędna miejscowość.");

        } catch (InvalidCityNameException e) {
            e.printStackTrace();
            weatherTargetRenderer.showError("Wpisz nazwę miejscowości.");

        } catch (IllegalArgumentException e) {
            weatherTargetRenderer.showError("Brak/nieprawidłowy klucz API. Pobierz klucz API OpenWeatherMap.");
        }
    }

    public void setCurrentNodesValues() {

        todayWeatherCurrentNodes = new TodayWeatherNodes(backgroundCurrentCity,
                currentCityCityNameLabel, currentCityDateLabel,
                currentCityTemperatureLabel,
                currentCityHumidityLabel,
                currentCityPressureLabel, currentCityIconWeather, currentCityDescriptionLabel,
                currentDayCurrentCityRestHours, dailyPanelCurrentCity);
    }

    public void setTargetNodesValues() {

        todayWeatherTargetNodes = new TodayWeatherNodes(backgroundTargetCity,
                targetCityCityNameLabel, targetCityDateLabel,
                targetCityTemperatureLabel,
                targetCityHumidityLabel,
                targetCityPressureLabel, targetCityIconWeather, targetCityDescriptionLabel,
                currentDayTargetCityRestHours, dailyPanelTargetCity);
    }

    public void setCurrentNodesToRender() {

        weatherCurrentRenderer = new WeatherRenderer(infoCurrent, backgroundCurrentCity,
                currentCityCityNameLabel, currentCityDateLabel,
                currentCityTemperatureLabelInstrciption, currentCityTemperatureLabel,
                currentCityHumidityLabelInstrciption, currentCityHumidityLabel, currentCityPressureLabelInstrciption,
                currentCityPressureLabel, currentCityIconWeather, currentCityDescriptionLabel,
                currentDayCurrentCityRestHoursInstrciption, currentDayCurrentCityRestHours, dailyPanelCurrentCity);
    }

    public void setTargetNodesToRender() {

        weatherTargetRenderer = new WeatherRenderer(infoTarget, backgroundTargetCity,
                targetCityCityNameLabel, targetCityDateLabel,
                targetCityTemperatureLabelInstrciption, targetCityTemperatureLabel,
                targetCityHumidityLabelInstrciption, targetCityHumidityLabel, targetCityPressureLabelInstrciption,
                targetCityPressureLabel, targetCityIconWeather, targetCityDescriptionLabel,
                currentDayTargetCityRestHoursInstrciption, currentDayTargetCityRestHours, dailyPanelTargetCity);
    }
}
