package weather.model.converters;

import java.util.AbstractMap;
import java.util.Map;
import java.time.LocalDate;

public class DateConverter {

    private static final Map<String, String> DAYS_MAPPING = Map.of(
            "Mon", "Poniedziałek",
            "Tue", "Wtorek",
            "Wed", "Środa",
            "Thu", "Czwartek",
            "Fri", "Piątek",
            "Sat", "Sobota",
            "Sun", "Niedziela"
    );

    private static final Map<String, String> MONTHS_MAPPING = Map.ofEntries(
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



        //String rawDay = LocalDate.parse(date).getDayOfWeek().toString();
        int dayFirstLetter = 0;
        int dayLastLetter = 3;
        String rawDay = date.substring(dayFirstLetter, dayLastLetter);
        String convertedDayName = DAYS_MAPPING.getOrDefault(rawDay, rawDay);

        int monthFirstLetter = 4;
        int monthLastLetter = 7;
        String monthName = date.substring(monthFirstLetter, monthLastLetter);
        String convertedMonthName = MONTHS_MAPPING.getOrDefault(monthName, monthName);

        int dayFirstNumber = 8;
        int dayLastNumber = 10;
        String day = date.substring(dayFirstNumber, dayLastNumber);

        int yearFirstNumber = 25;
        String year = date.substring(yearFirstNumber);

        return convertedDayName + ", " + day + " " + convertedMonthName + " " + year;
    }
}
