package weather.forecastFunctions;

import weather.Config;
import weather.api.Weather;
import weather.converters.DateConverter;
import weather.converters.WeatherDescriptionTranslator;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;
import net.aksingh.owmjapis.model.HourlyWeatherForecast;

public class OWMApiRepository {

    OWM owm;

    public OWMApiRepository() {

        this.owm = new OWM(Config.API_KEY);
        this.owm.setUnit(OWM.Unit.METRIC);
    }

    public Weather fetchWeatherForCity(int cityID) throws APIException {
        CurrentWeather currentWeather = owm.currentWeatherByCityId(cityID);

        return new Weather(currentWeather.getMainData().getTemp() + "\u00b0C",
                currentWeather.getMainData().getHumidity() + "%", currentWeather.getMainData().getPressure() + " HPa",
                currentWeather.getCityName(), DateConverter.convertDate(String.valueOf(currentWeather.getDateTime())),
                WeatherDescriptionTranslator.translateDescription(currentWeather.getWeatherList().get(0).getDescription()), currentWeather.getWeatherList().get(0).getIconLink());
    }

    public HourlyWeatherForecast fetchHourlyWeatherForecast(int cityID) throws APIException {
        return owm.hourlyWeatherForecastByCityId(cityID);
    }
}
