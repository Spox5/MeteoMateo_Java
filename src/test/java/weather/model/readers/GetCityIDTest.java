package weather.model.readers;

import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import weather.model.exception.InvalidCityNameException;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ApplicationExtension.class)
class GetCityIDTest {

    private TextField cityName;

    @Start
    private void start(Stage stage) {

        cityName = new TextField();
        cityName.setId("city");
        stage.setScene(new Scene(new StackPane(cityName), 100, 100));
        stage.show();
    }

    @BeforeEach
    public void init(FxRobot robot) {
        robot.clickOn("#city");
    }

    @Test
    public void shouldReturnCorrectCityID(FxRobot robot) throws InvalidCityNameException {

        //get
        robot.write("Warszawa");

        //when
        int cityID = GetCityID.getCityID(cityName);

        // then:
        FxAssert.verifyThat(cityID, is(6695624));
        assertEquals(6695624, cityID);

    }

    @Test
    public void shouldThrowExceptionIfCityIsInvalid(FxRobot robot) {

        //get
        robot.write("");

        //when
        // then:
        assertThrows(InvalidCityNameException.class, () -> GetCityID.getCityID(cityName));
    }
}