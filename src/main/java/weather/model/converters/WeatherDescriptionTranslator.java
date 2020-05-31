package weather.model.converters;

import java.util.AbstractMap;
import java.util.Map;

public class WeatherDescriptionTranslator {

    public static Map<String, String> TRANSLATIONS = Map.ofEntries(

            new AbstractMap.SimpleEntry<>("thunderstorm with light rain", "Burza z lekkimi opadami deszczu"),
            new AbstractMap.SimpleEntry<>("thunderstorm with rain", "Burza z opadami deszczu"),
            new AbstractMap.SimpleEntry<>("thunderstorm with heavy rain", "Burza z ulewnym deszczem"),
            new AbstractMap.SimpleEntry<>("light thunderstorm", "Słaba burza z piorunami"),
            new AbstractMap.SimpleEntry<>("thunderstorm", "Burza z piorunami"),
            new AbstractMap.SimpleEntry<>("heavy thunderstorm", "Silna burza z piorunami"),
            new AbstractMap.SimpleEntry<>("ragged thunderstorm", "Burza z przejaśnieniami"),
            new AbstractMap.SimpleEntry<>("thunderstorm with light drizzle", "Burza z lekką mżawką"),
            new AbstractMap.SimpleEntry<>("thunderstorm with drizzle", "Burza z mrzawką"),
            new AbstractMap.SimpleEntry<>("thunderstorm with heavy drizzle", "Burza z gęstą mżawką"),

            new AbstractMap.SimpleEntry<>("light intensity drizzle", "Lekka mżawka"),
            new AbstractMap.SimpleEntry<>("drizzle", "Mżawka"),
            new AbstractMap.SimpleEntry<>("heavy intensity drizzle", "Intensywna mżawka"),
            new AbstractMap.SimpleEntry<>("light intensity drizzle rain", "Lekka mżawka z deszczem"),
            new AbstractMap.SimpleEntry<>("drizzle rain", "Mżawka z deszczem"),
            new AbstractMap.SimpleEntry<>("heavy intensity drizzle rain", "Intensywna mżawka z deszczem"),
            new AbstractMap.SimpleEntry<>("shower rain and drizzle", "Przelotne opady z mżawką"),
            new AbstractMap.SimpleEntry<>("heavy shower rain and drizzle", "Przelotna ulewa z mżawką"),
            new AbstractMap.SimpleEntry<>("shower drizzle", "Przelotna mżawka"),

            new AbstractMap.SimpleEntry<>("light rain", "Lekki deszcz"),
            new AbstractMap.SimpleEntry<>("moderate rain", "Umiarkowany deszcz"),
            new AbstractMap.SimpleEntry<>("heavy intensity rain", "Intensywny deszcz"),
            new AbstractMap.SimpleEntry<>("very heavy rain", "Ulewa"),
            new AbstractMap.SimpleEntry<>("extreme rain", "Ekstremalna ulewa"),
            new AbstractMap.SimpleEntry<>("freezing rain", "Marznący deszcz"),
            new AbstractMap.SimpleEntry<>("light intensity shower rain", "Lekki, przelotny deszcz"),
            new AbstractMap.SimpleEntry<>("shower rain", "Przelotny deszcz"),
            new AbstractMap.SimpleEntry<>("heavy intensity shower rain", "Intensywny, przelotny deszcz"),
            new AbstractMap.SimpleEntry<>("ragged shower rain", "Przelotny deszcz z przejaśnieniami"),

            new AbstractMap.SimpleEntry<>("light snow", "Lekki śnieg"),
            new AbstractMap.SimpleEntry<>("Snow", "Śnieg"),
            new AbstractMap.SimpleEntry<>("Heavy snow", "Duże opady śniegu"),
            new AbstractMap.SimpleEntry<>("Sleet", "Śnieg z deszczem"),
            new AbstractMap.SimpleEntry<>("Light shower sleet", "Lekki, przelotny śnieg z deszczem"),
            new AbstractMap.SimpleEntry<>("Shower sleet", "Przelotny śnieg z deszczem"),
            new AbstractMap.SimpleEntry<>("Light rain and snow", "Lekki deszcz ze śniegiem"),
            new AbstractMap.SimpleEntry<>("Rain and snow", "Deszcz ze śniegiem"),
            new AbstractMap.SimpleEntry<>("Light shower snow", "Lekki, przelotny śnieg"),
            new AbstractMap.SimpleEntry<>("Shower snow", "Przelotny śnieg"),
            new AbstractMap.SimpleEntry<>("Heavy shower snow", "Intensywny, przelotny śnieg"),

            new AbstractMap.SimpleEntry<>("mist", "Lekka mgła"),
            new AbstractMap.SimpleEntry<>("Smoke", "Zadymienie"),
            new AbstractMap.SimpleEntry<>("Haze", "Lekka, przyziemna mgła"),
            new AbstractMap.SimpleEntry<>("sand/ dust whirls", "Wiry piasku/pyłu"),
            new AbstractMap.SimpleEntry<>("fog", "Mgła"),
            new AbstractMap.SimpleEntry<>("sand", "Piasek"),
            new AbstractMap.SimpleEntry<>("dust", "Pył"),
            new AbstractMap.SimpleEntry<>("volcanic ash", "Pył wulkaniczny"),
            new AbstractMap.SimpleEntry<>("squalls", "Szkwał"),
            new AbstractMap.SimpleEntry<>("tornado", "Tornado"),

            new AbstractMap.SimpleEntry<>("clear sky", "Czyste niebo"),

            new AbstractMap.SimpleEntry<>("few clouds", "Lekkie zachmurzenie (11-25%)"),
            new AbstractMap.SimpleEntry<>("scattered clouds", "Częściowe zachmurzenie (25-50%)"),
            new AbstractMap.SimpleEntry<>("broken clouds", "Pochmurno (51-84%)"),
            new AbstractMap.SimpleEntry<>("overcast clouds", "Całkowite zachmurzenie")
    );

    public static String translateDescription(String descr) {

        return TRANSLATIONS.getOrDefault(descr, descr);
    }
}

