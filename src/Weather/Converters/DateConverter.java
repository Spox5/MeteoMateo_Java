package Weather.Converters;

public class DateConverter {

    private static String dayNameConverter(String dayName) {

        switch (dayName) {

            case "Mon": return "Poniedziałek";

            case "Tue": return "Wtorek";

            case "Wed": return "Środa";

            case "Thu": return "Czwartek";

            case "Fri": return "Piątek";

            case "Sat": return "Sobota";

            case "Sun": return "Niedziela";

        }
        return null;
    }

    private static String monthNameConverter(String monthName) {

        switch (monthName) {

            case "Jan": return "styczeń";

            case "Feb": return "luty";

            case "Mar": return "marzec";

            case "Apr": return "kwiecień";

            case "May": return "maj";

            case "Jun": return "czerwiec";

            case "Jul": return "lipiec";

            case "Aug": return "sierpień";

            case "Sep": return "wrzesień";

            case "Oct": return "październik";

            case "Nov": return "listopad";

            case "Dec": return "grudzień";
        }
        return null;
    }

    public static String dateConvert(String date) {

        String convertedDayName = dayNameConverter(date.substring(0, 3));
        String convertedMonthName = monthNameConverter(date.substring(4, 7));
        String day = date.substring(8, 10);
        String year = date.substring(24);

        String correctDate = convertedDayName + ", " + day + " " + convertedMonthName + " " + year;
        return correctDate;
    }

    
}
