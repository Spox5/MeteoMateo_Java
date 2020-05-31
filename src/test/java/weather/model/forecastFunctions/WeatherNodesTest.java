package weather.model.forecastFunctions;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import net.aksingh.owmjapis.model.CurrentWeather;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import weather.testRepositories.OWMRepositoryStub;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@ExtendWith(ApplicationExtension.class)
class WeatherNodesTest {

    AnchorPane backgroundCurrentCity;
    Label currentCityCityNameLabel;
    Label currentCityDateLabel;
    Label currentCityTemperatureLabel;
    Label currentCityHumidityLabel;
    Label currentCityPressureLabel;
    ImageView currentCityIconWeather;
    Label currentCityDescriptionLabel;
    GridPane currentDayCurrentCityRestHours;
    GridPane dailyPanel;

    @Start
    private void start(Stage stage) {


        backgroundCurrentCity = new AnchorPane();
        currentCityCityNameLabel = new Label();
        currentCityDateLabel = new Label();
        currentCityDateLabel = new Label();
        currentCityTemperatureLabel = new Label();
        currentCityHumidityLabel = new Label();
        currentCityPressureLabel = new Label();
        currentCityIconWeather = new ImageView();
        currentCityDescriptionLabel = new Label();
        currentDayCurrentCityRestHours = new GridPane();
        dailyPanel = new GridPane();

        stage.setScene(new Scene(new StackPane(), 100, 100));
        stage.show();
    }


    @Test
    public void shouldReturnCorrectValuesToNodesForCurrentWeather() {

        CurrentWeather currentWeather = OWMRepositoryStub.getCurrentWeather();

        WeatherNodes.getWeatherNowData(currentWeather, backgroundCurrentCity, currentCityCityNameLabel,
                currentCityDateLabel, currentCityTemperatureLabel, currentCityHumidityLabel, currentCityPressureLabel,
                currentCityIconWeather, currentCityDescriptionLabel);

        assertThat(backgroundCurrentCity.getStyle(), equalTo("-fx-background-color: #faf734"));
        assertThat(currentCityCityNameLabel.getText(), equalTo("Mountain View"));
        assertThat(currentCityDateLabel.getText(), equalTo("Środa, 12 czerwiec 2019"));
        assertThat(currentCityTemperatureLabel.getText(), equalTo("29.71°C"));
        assertThat(currentCityHumidityLabel.getText(), equalTo("53.0%"));
        assertThat(currentCityPressureLabel.getText(), equalTo("1013.0 HPa"));
        assertThat(currentCityIconWeather.getImage(), is(notNullValue()));
        assertThat(currentCityDescriptionLabel.getText(), equalTo("Czyste niebo"));
    }
}