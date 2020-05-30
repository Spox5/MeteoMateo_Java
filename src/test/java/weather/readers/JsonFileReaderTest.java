package weather.readers;

import com.google.gson.JsonArray;
import org.junit.jupiter.api.Test;
import weather.Config;
import java.io.Reader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JsonFileReaderTest {

    @Test
    void fileWithCorrectPathShouldBeRead() {

        //given
        Reader reader = JsonFileReader.readJsonFile(Config.CITY_LIST_WITH_DATA);
        //when
        //then
        assertThat(reader, is(notNullValue()));
    }

    @Test
    void fileWithIncorrectPathShouldThrowException() {

        //given
        String path = null;
        //when
        //then
        assertThrows(NullPointerException.class, () -> JsonFileReader.readJsonFile(path));
        assertThrows(RuntimeException.class, () -> JsonFileReader.readJsonFile(path));
    }

    @Test
    void shouldBeAbleToLoadCitiesFromFile() {

        //given
        String path = Config.CITY_LIST_WITH_DATA;
        JsonArray citiesList;

        //when
        citiesList = JsonFileReader.getCitiesList(path);

        //then
        assertThat(citiesList.size(), equalTo(209579));
    }

    @Test
    void exceptionShouldBeThrownWhenPathIsIncorrect() {

        //given
        String path = null;

        //when
        //then
        assertThrows(NullPointerException.class, () -> JsonFileReader.getCitiesList(path));
        assertThrows(RuntimeException.class, () -> JsonFileReader.getCitiesList(path));
    }
}
