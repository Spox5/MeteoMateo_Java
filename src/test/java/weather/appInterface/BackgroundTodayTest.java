package weather.appInterface;

import javafx.scene.layout.AnchorPane;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class BackgroundTodayTest {

    AnchorPane background = new AnchorPane();

    @ParameterizedTest
    @ValueSource(strings = {"Burza z lekkimi opadami deszczu", "Burza z opadami deszczu", "Burza z ulewnym deszczem"})
    public void backgroundShouldBeSet(String description) {

        BackgroundToday.setBackground(background, description);

        assertThat(background.getStyle(), is("-fx-background-color: #383a42"));
    }

}