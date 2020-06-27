package cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.domain;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.ArrayList;

public class CityWeather implements Serializable {
    private static final long serialVersionUID = 1236472295622776147L;

    @Expose
    private City city;

    private WeatherReport current;

    private ArrayList<WeatherReport> hourly;

    private ArrayList<WeatherReportDaily> daily;

    public CityWeather() {
    }

    public void setCity(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }

    public WeatherReport getCurrent() {
        return current;
    }

    public void setCurrent(WeatherReport current) {
        this.current = current;
    }

    public ArrayList<WeatherReport> getHourly() {
        return hourly;
    }

    public void setHourly(ArrayList<WeatherReport> hourly) {
        this.hourly = hourly;
    }

    public ArrayList<WeatherReportDaily> getDaily() {
        return daily;
    }

    public void setDaily(ArrayList<WeatherReportDaily> daily) {
        this.daily = daily;
    }
}