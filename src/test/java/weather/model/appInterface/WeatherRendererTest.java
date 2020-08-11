package weather.model.appInterface;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import weather.controller.Controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@ExtendWith(ApplicationExtension.class)
class WeatherRendererTest {

    Label info;
    AnchorPane background;
    Label currentCityCityNameLabel;
    Label currentCityDateLabel;
    Label currentCityTemperatureLabelInstrciption;
    Label currentCityTemperatureLabel;
    Label currentCityHumidityLabelInstrciption;
    Label currentCityHumidityLabel;
    Label currentCityPressureLabelInstrciption;
    Label currentCityPressureLabel;
    ImageView currentCityIconWeather;
    Label currentCityDescriptionLabel;
    Label currentDayRestHoursInstrciption;
    GridPane currentDayRestHours;
    GridPane dailyPanel;

    WeatherRenderer weatherRenderer;

    @Start
    private void start(Stage stage) {

        info = new Label();
        background = new AnchorPane();
        currentCityCityNameLabel = new Label();
        currentCityDateLabel = new Label();
        currentCityTemperatureLabelInstrciption = new Label();
        currentCityTemperatureLabel = new Label();
        currentCityHumidityLabelInstrciption = new Label();
        currentCityHumidityLabel = new Label();
        currentCityPressureLabelInstrciption = new Label();
        currentCityPressureLabel = new Label();
        currentCityIconWeather = new ImageView();
        currentCityDescriptionLabel = new Label();
        currentDayRestHoursInstrciption = new Label();
        currentDayRestHours = new GridPane();
        dailyPanel = new GridPane();

        stage.setScene(new Scene(new StackPane(), 100, 100));
        stage.show();
    }

    @Test
    public void infoNodeShouldBeInvisible() {

        //given
        setCurrentNodesToRender();

        //when
        weatherRenderer.show();

        //then
        assertThat(info.isVisible(), is(false));
    }

    @Test
    public void allNodesShouldBeVisible() {

        //given
        setCurrentNodesToRender();

        //when
        weatherRenderer.show();

        //then
        assertThat(background.isVisible(), is(true));
        assertThat(currentCityCityNameLabel.isVisible(), is(true));
        assertThat(currentCityDateLabel.isVisible(), is(true));
        assertThat(currentCityTemperatureLabelInstrciption.isVisible(), is(true));
        assertThat(currentCityTemperatureLabel.isVisible(), is(true));
        assertThat(currentCityHumidityLabelInstrciption.isVisible(), is(true));
        assertThat(currentCityHumidityLabel.isVisible(), is(true));
        assertThat(currentCityPressureLabelInstrciption.isVisible(), is(true));
        assertThat(currentCityPressureLabel.isVisible(), is(true));
        assertThat(currentCityIconWeather.isVisible(), is(true));
        assertThat(currentCityDescriptionLabel.isVisible(), is(true));
        assertThat(currentDayRestHoursInstrciption.isVisible(), is(true));
        assertThat(currentDayRestHours.isVisible(), is(true));
        assertThat(dailyPanel.isVisible(), is(true));
    }


    @Test
    public void onlyInfoLabelWithMessageShouldBeVisible() {

        //given
        setCurrentNodesToRender();

        //when
        weatherRenderer.showError("Wystąpił błąd");

        //then
        assertThat(info.getText(), is("Wystąpił błąd"));
        assertThat(info.isVisible(), is(true));
        assertThat(background.isVisible(), is(false));
        assertThat(currentCityCityNameLabel.isVisible(), is(false));
        assertThat(currentCityDateLabel.isVisible(), is(false));
        assertThat(currentCityTemperatureLabelInstrciption.isVisible(), is(false));
        assertThat(currentCityTemperatureLabel.isVisible(), is(false));
        assertThat(currentCityHumidityLabelInstrciption.isVisible(), is(false));
        assertThat(currentCityHumidityLabel.isVisible(), is(false));
        assertThat(currentCityPressureLabelInstrciption.isVisible(), is(false));
        assertThat(currentCityPressureLabel.isVisible(), is(false));
        assertThat(currentCityIconWeather.isVisible(), is(false));
        assertThat(currentCityDescriptionLabel.isVisible(), is(false));
        assertThat(currentDayRestHoursInstrciption.isVisible(), is(false));
        assertThat(currentDayRestHours.isVisible(), is(false));
        assertThat(dailyPanel.isVisible(), is(false));
    }

    @Test
    public void gridPanesShouldBeClear() {

        setCurrentNodesToRender();
        Controller contr = new Controller();
        contr.clearInterface();

        assertThat(currentDayRestHours.getChildren(), is(empty()));
        assertThat(dailyPanel.getChildren(), is(empty()));
    }

    public void setCurrentNodesToRender() {

        weatherRenderer = new WeatherRenderer(info, background,
                currentCityCityNameLabel, currentCityDateLabel,
                currentCityTemperatureLabelInstrciption, currentCityTemperatureLabel,
                currentCityHumidityLabelInstrciption, currentCityHumidityLabel, currentCityPressureLabelInstrciption,
                currentCityPressureLabel, currentCityIconWeather, currentCityDescriptionLabel,
                currentDayRestHoursInstrciption, currentDayRestHours, dailyPanel);
    }

}