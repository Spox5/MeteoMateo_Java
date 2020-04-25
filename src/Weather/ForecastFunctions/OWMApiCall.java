package Weather.forecastFunctions;

import Weather.Config;
import Weather.converters.DateConverter;
import Weather.converters.WeatherDescriptionTranslator;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;
import net.aksingh.owmjapis.model.HourlyWeatherForecast;

public class OWMApiCall {

    OWM owm;
    CurrentWeather currentWeather;
    HourlyWeatherForecast hourlyWeatherForecast;

    OWMApiCall(int id) throws APIException {

        this.owm = new OWM(Config.getYourAPIKey());
        this.owm.setUnit(OWM.Unit.METRIC);

        this.currentWeather = getCurrentWeather(id);

        this.hourlyWeatherForecast = getHourlyWeatherForecast(id);
    }

    private CurrentWeather getCurrentWeather(int cityId) throws APIException {

        this.currentWeather = owm.currentWeatherByCityId(cityId);
        return currentWeather;
    }

    private HourlyWeatherForecast getHourlyWeatherForecast(int cityId) throws APIException {

        this.hourlyWeatherForecast = owm.hourlyWeatherForecastByCityId(cityId);

        return hourlyWeatherForecast;
    }

    public String getCurrentCityTemperature() {

        return this.currentWeather.getMainData().getTemp() + "\u00b0C";
    }

    public String getCurrentCityHumidity() {

        return this.currentWeather.getMainData().getHumidity() + "%";
    }

    public String getCurrentCityPressure() {

        return this.currentWeather.getMainData().getPressure() + " HPa";
    }

    public String getCityName() {

        return currentWeather.getCityName();
    }

    public String getCurrentIconPath() {

        return currentWeather.getWeatherList().get(0).getIconLink();
    }

    public String getCurrentCityDate() {

        return DateConverter.dateConvert(String.valueOf(currentWeather.getDateTime()));
    }

    public String getCurrentCityDescription() {

        return WeatherDescriptionTranslator.translateDescription(currentWeather.getWeatherList().get(0).getDescription());
    }

}