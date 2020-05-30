package weather;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

@ExtendWith(ApplicationExtension.class)
public class ControllerTest {

    @Start
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MainMenu.fxml"));
        primaryStage.setTitle("MeteoMateo");
        primaryStage.setScene(new Scene(root, 1100, 400));
        primaryStage.show();
    }

    @Test
    public void shouldBeAbleToShowMessageThatCurrentCityNameFieldIsEmpty(FxRobot robot) {

        //given
        //when
        robot.clickOn("#currentOK");

        //then
        verifyThat("#infoCurrent", hasText("Wpisz nazwę miejscowości."));
    }

    @Test
    public void shouldBeAbleToShowMessageThatTargetCityNameFieldIsEmpty(FxRobot robot) {

        //given
        //when
        robot.clickOn("#targetOK");

        //then
        verifyThat("#infoTarget", hasText("Wpisz nazwę miejscowości."));
    }

    @Test
    public void shouldBeAbleToShowMessageThatCurrentCityNameFieldIsInvalid(FxRobot robot) {

        String cityName = "a";
        robot.clickOn("#cityNameCurrent");
        robot.write(cityName);
        robot.clickOn("#currentOK");

        //then
        verifyThat("#infoCurrent", hasText("Błędna miejscowość."));
    }

    @Test
    public void shouldBeAbleToShowMessageThatTargetCityNameFieldIsInvalid(FxRobot robot) {

        String cityName = "a";
        robot.clickOn("#cityNameTarget");
        robot.write(cityName);
        robot.clickOn("#targetOK");

        //then
        verifyThat("#infoTarget", hasText("Błędna miejscowość."));
    }
}
