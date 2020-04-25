package weather.converters;

import java.util.AbstractMap;
import java.util.Map;

public class DateConverter {

    private static Map<String, String> DAYS_MAPPING = Map.of(
            "Mon", "Poniedziałek",
            "Tue", "Wtorek",
            "Wed", "Środa",
            "Thu", "Czwartek",
            "Fri", "Piątek",
            "Sat", "Sobota",
            "Sun", "Niedziela"
    );

    private static Map<String, String> MONTHS_MAPPING = Map.ofEntries(
            new AbstractMap.SimpleEntry<>("Jan", "styczeń"),
            new AbstractMap.SimpleEntry<>("Feb", "luty"),
            new AbstractMap.SimpleEntry<>("Mar", "marzec"),
            new AbstractMap.SimpleEntry<>("Apr", "kwiecień"),
            new AbstractMap.SimpleEntry<>("May", "maj"),
            new AbstractMap.SimpleEntry<>("Jun", "czerwiec"),
            new AbstractMap.SimpleEntry<>("Jul", "lipiec"),
            new AbstractMap.SimpleEntry<>("Aug", "sierpień"),
            new AbstractMap.SimpleEntry<>("Sep", "wrzesień"),
            new AbstractMap.SimpleEntry<>("Oct", "październik"),
            new AbstractMap.SimpleEntry<>("Nov", "listopad"),
            new AbstractMap.SimpleEntry<>("Dec", "grudzień")
    );

    public static String convertDate(String date) {

        String rawDay = date.substring(0, 3);
        String convertedDayName = DAYS_MAPPING.getOrDefault(rawDay, rawDay);
        String monthName = date.substring(4, 7);
        String convertedMonthName = MONTHS_MAPPING.getOrDefault(monthName, monthName);
        String day = date.substring(8, 10);
        String year = date.substring(24);

        return convertedDayName + ", " + day + " " + convertedMonthName + " " + year;
    }
}
