package weather.model.converters;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DateConverterTest {

    String con1 = "Wed May 13 22:55:13 CEST 2020";
    String con2 = "Mon Feb 15 22:55:13 CEST 2020";
    String con3 = "Sun Apr 30 22:55:13 CEST 2020";

    @Test
    void convertDayNameFromEnglishToPolish() {

        //given
        String date1 = "Środa, 13 maj 2020";
        String date2 = "Poniedziałek, 15 luty 2020";
        String date3 = "Niedziela, 30 kwiecień 2020";

        //when
        //then
        assertThat(DateConverter.convertDate(con1), is(date1));
        assertThat(DateConverter.convertDate(con2), is(date2));
        assertThat(DateConverter.convertDate(con3), is(date3));
    }

    @Test
    public void valueShouldBeNotNull() {

        //given
        //when
        //then
        assertThat(WeatherDescriptionTranslator.translateDescription(con1), notNullValue());
        assertThat(WeatherDescriptionTranslator.translateDescription(con1), not(emptyString()));
    }
}
