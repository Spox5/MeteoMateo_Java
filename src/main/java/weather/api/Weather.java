package weather.api;

import net.aksingh.owmjapis.model.CurrentWeather;

public class Weather {

    private CurrentWeather currentWeather;

    public final String temperature;
    public final String humidity;
    public final String pressure;
    public final String city;
    public final String cityDate;
    public final String cityDescription;
    public final String iconPath;

    public Weather(String temperature, String humidity, String pressure, String city, String cityDate, String cityDescription, String iconPath) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.city = city;
        this.cityDate = cityDate;
        this.cityDescription = cityDescription;
        this.iconPath = iconPath;
    }
}