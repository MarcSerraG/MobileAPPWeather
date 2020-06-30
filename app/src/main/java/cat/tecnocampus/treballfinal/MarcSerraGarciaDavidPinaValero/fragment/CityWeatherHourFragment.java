package cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.bumptech.glide.Glide;

import java.util.ArrayList;

import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.R;
import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.domain.City;
import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.domain.CityWeather;
import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.domain.WeatherReport;

public class CityWeatherHourFragment extends Fragment {

    private WeatherReport weatherReport;
    private City city;

    private TextView maxTemperature, minTemperature, currentCityName, currentTemperature;
    private TextView longitud, latitud, humidity;
    private ImageView weatherImage;

    public CityWeatherHourFragment(){}

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        this.weatherReport = (WeatherReport) getArguments().getSerializable("current");
        this.city = (City) getArguments().getSerializable("city");

        View view = inflater.inflate(R.layout.city_weather_hour_fragment, container, false);

        maxTemperature = view.findViewById(R.id.tv_max_temperature);
        minTemperature = view.findViewById(R.id.tv_min_temperature);
        currentCityName = view.findViewById(R.id.tv_current_city);
        currentTemperature = view.findViewById(R.id.tv_current_temperature);
        latitud = view.findViewById(R.id.tv_current_latitude);
        longitud = view.findViewById(R.id.tv_current_longitude);
        humidity = view.findViewById(R.id.tv_current_humidity);

        weatherImage = view.findViewById(R.id.im_current_weather);
        //maxTemperature.setText("");
        //minTemperature.setText("");
        currentCityName.setText(""+city.getName());
        currentTemperature.setText(""+(int)weatherReport.getTemperature()+" ºC");
        latitud.setText(""+city.getLatitude());
        longitud.setText(""+city.getLongitude());
        humidity.setText(""+weatherReport.getHumidity());

        Glide.with(view.getContext())
                .load(weatherReport.getIconURL())
                .into(weatherImage);

        return view;
    }
}
