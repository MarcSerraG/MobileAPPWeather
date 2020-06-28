package cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.domain;

import com.google.gson.annotations.SerializedName;

public class WeatherReportDaily extends WeatherReport {

    @SerializedName("temp")
    public Temperature temperature;

    private class Temperature {
        private double day;
        private double min;
        private double max;
        private double night;
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
}