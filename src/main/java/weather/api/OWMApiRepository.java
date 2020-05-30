package weather.api;

import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;
import net.aksingh.owmjapis.model.HourlyWeatherForecast;

public class OWMApiRepository {

    OWM owm;
    String apiKey;

    public OWMApiRepository(String apiKey) {

        this.apiKey = apiKey;
        this.owm = new OWM(apiKey);
        this.owm.setUnit(OWM.Unit.METRIC);
    }

    public OWMApiRepository() {

    }

    public CurrentWeather fetchWeatherForCity(int cityID) throws APIException {

        /*return new Weather(currentWeather.getMainData().getTemp() + "\u00b0C",
                currentWeather.getMainData().getHumidity() + "%", currentWeather.getMainData().getPressure() + " HPa",
                currentWeather.getCityName(), DateConverter.convertDate(String.valueOf(currentWeather.getDateTime())),
                WeatherDescriptionTranslator.translateDescription(currentWeather.getWeatherList().get(0)
                .getDescription()), currentWeather.getWeatherList().get(0).getIconLink());*/
         return owm.currentWeatherByCityId(cityID);
    }

    public HourlyWeatherForecast fetchHourlyWeatherForecast(int cityID) throws APIException {
        return owm.hourlyWeatherForecastByCityId(cityID);
    }
}
