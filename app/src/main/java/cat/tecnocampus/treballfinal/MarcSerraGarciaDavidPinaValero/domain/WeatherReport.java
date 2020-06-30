package cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class WeatherReport implements Serializable {
    private static final long serialVersionUID = 1236472295622776141L;

    @SerializedName("temp")
    private double temperature;

    private int humidity;

    private ArrayList<Weather> weather;

    private class Weather implements Serializable {
        private String main;
        private String description;
        private String icon;
    }

    public WeatherReport() {
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
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
