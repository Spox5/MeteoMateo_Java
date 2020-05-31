package weather.model.api;

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

    public CurrentWeather fetchWeatherForCity(int cityID) throws APIException {

         return owm.currentWeatherByCityId(cityID);
    }

    public HourlyWeatherForecast fetchHourlyWeatherForecast(int cityID) throws APIException {
        return owm.hourlyWeatherForecastByCityId(cityID);
    }
}
