package Weather.Converters;

public class WeatherDescriptionTranslator {

    public static String descritpionTranslate (String descr) {

        switch (descr) {

            case "thunderstorm with light rain": return "Burza z lekkimi opadami deszczu";
            case "thunderstorm with rain": return "Burza z opadami deszczu";
            case "thunderstorm with heavy rain": return "Burza z ulewnym deszczem";
            case "light thunderstorm": return "Słaba burza z piorunami";
            case "thunderstorm": return "Burza z piorunami";
            case "heavy thunderstorm": return "Silna burza z piorunami";
            case "ragged thunderstorm": return "Burza z przejasnieniami";
            case "thunderstorm with light drizzle": return "Burza z lekką mżawką";
            case "thunderstorm with drizzle": return "Burza z mrzawką";
            case "thunderstorm with heavy drizzle": return "Burza z gęstą mżawką";

            case "light intensity drizzle": return "Lekka mżawka";
            case "drizzle": return "Mżawka";
            case "heavy intensity drizzle": return "Intensywna mżawka";
            case "light intensity drizzle rain": return "Lekka mżawka z deszczem";
            case "drizzle rain": return "Mżawka z deszczem";
            case "heavy intensity drizzle rain": return "Intensywna mżawka z deszczem";
            case "shower rain and drizzle": return "Przelotne opady z mżawką";
            case "heavy shower rain and drizzle": return "Przelotna ulewa z mżawką";
            case "shower drizzle": return "Przelotna mżawka";

            case "light rain": return "Lekki deszcz";
            case "moderate rain": return "Umiarkowany deszcz";
            case "heavy intensity rain": return "Intensywny deszcz";
            case "very heavy rain": return "Ulewa";
            case "extreme rain": return "Ekstremalna ulewa";
            case "freezing rain": return "Marznący deszcz";
            case "light intensity shower rain": return "Lekki, przelotny deszcz";
            case "shower rain": return "Przelotny deszcz";
            case "heavy intensity shower rain": return "Intensywny, przelotny deszcz";
            case "ragged shower rain": return "Przelotny deszcz z przejaśnieniami";

            case "light snow": return "Lekki śnieg";
            case "Snow": return "Śnieg";
            case "Heavy snow": return "Duże opady śniegu";
            case "Sleet": return "Śnieg z deszczem";
            case "Light shower sleet": return "Lekki, przelotny śnieg z deszczem";
            case "Shower sleet": return "Przelotny śnieg z deszczem";
            case "Light rain and snow": return "Lekki deszcz ze śniegiem";
            case "Rain and snow": return "Deszcz ze śniegiem";
            case "Light shower snow": return "Lekki, przelotny śnieg";
            case "Shower snow": return "Przelotny śnieg";
            case "Heavy shower snow": return "Intensywny, przelotny śnieg";

            case "mist": return "Lekka mgła";
            case "Smoke": return "Zadymienie";
            case "Haze": return "Lekka, przyziemna mgła";
            case "sand/ dust whirls": return "Wiry piasku/pyłu";
            case "fog": return "Mgła";
            case "sand": return "Piasek";
            case "dust": return "Pył";
            case "volcanic ash": return "Pył wulkaniczny";
            case "squalls": return "Szkwał";
            case "tornado": return "Tornado";

            case "clear sky": return "Czyste niebo";

            case "few clouds": return "Lekkie zachmurzenie (11-25%)";
            case "scattered clouds": return "Częściowe zachmurzenie (25-50%)";
            case "broken clouds": return "Pochmurno (51-84%)";
            case "overcast clouds": return "Całkowite zachmurzenie";
        }
        return null;
    }
}
