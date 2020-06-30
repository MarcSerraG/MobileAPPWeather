package cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class WeatherReportDaily implements Serializable {

    @SerializedName("temp")
    public Temperature temperature;

    private class Temperature implements  Serializable {
        private double day;
        private double min;
        private double max;
        private double night;
    }

    private int humidity;

    private ArrayList<Weather> weather;

    private class Weather implements Serializable {
        private String main;
        private String description;
        private String icon;
    }

    public WeatherReportDaily() {
    }

    public double getTemperatureDay() {
        return temperature.day;
    }

    public double getTemperatureNight() {
        return temperature.night;
    }

    public double getTemperatureMin() {
        return temperature.min;
    }

    public double getTemperatureMax() {
        return temperature.max;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public ArrayList<Weather> getWeather() {
        return weather;
    }

    public void setWeather(ArrayList<Weather> weather) {
        this.weather = weather;
    }

    public String getMain() {
        return weather.get(0).main;
    }

    public String getDescription() {
        return weather.get(0).description;
    }

    public String getIconURL() {
        return "https://openweathermap.org/img/wn/" + weather.get(0).icon + "@2x.png";
    }
}