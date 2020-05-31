package weather.model.converters;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.emptyString;

public class WeatherDescriptionTranslatorTest {

    String con1 = "clear sky";
    String con2 = "scattered clouds";
    String con3 = "Light shower snow";
    String con4 = "ragged shower rain";
    String con5 = "light thunderstorm";

    @Test
    public void shouldTranslateConditionEngToPl() {

        //given
        //when
        //then
        assertThat(WeatherDescriptionTranslator.translateDescription(con1), is("Czyste niebo"));
        assertThat(WeatherDescriptionTranslator.translateDescription(con2), is("Częściowe zachmurzenie (25-50%)"));
        assertThat(WeatherDescriptionTranslator.translateDescription(con3), is("Lekki, przelotny śnieg"));
        assertThat(WeatherDescriptionTranslator.translateDescription(con4), is("Przelotny deszcz z przejaśnieniami"));
        assertThat(WeatherDescriptionTranslator.translateDescription(con5), is("Słaba burza z piorunami"));
    }

    @Test
    public void valueShouldBeNotNull() {

        //given
        //when
        //then
        assertThat(WeatherDescriptionTranslator.translateDescription(con1), notNullValue());
        assertThat(WeatherDescriptionTranslator.translateDescription(con1), not(emptyString()));
        assertThat(WeatherDescriptionTranslator.translateDescription(con2), notNullValue());
        assertThat(WeatherDescriptionTranslator.translateDescription(con2), not(emptyString()));
    }
}
