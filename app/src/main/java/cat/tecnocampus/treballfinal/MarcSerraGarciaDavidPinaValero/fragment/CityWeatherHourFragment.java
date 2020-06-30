package cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.R;
import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.adapter.CityWeatherHourlyAdapter;
import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.domain.City;
import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.domain.WeatherReport;

public class CityWeatherHourFragment extends Fragment {

    private WeatherReport weatherReport;
    private ArrayList<WeatherReport> weatherHourly;
    private City city;

    private TextView currentDescription, currentCityName, currentTemperature;
    private TextView longitud, latitud, humidity;
    private ImageView weatherImage;
    private RecyclerView viewHourly;
    private CityWeatherHourlyAdapter cityWeatherHourlyAdapter;

    public CityWeatherHourFragment(){}

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        this.weatherReport = (WeatherReport) getArguments().getSerializable("current");
        this.weatherHourly = (ArrayList<WeatherReport>) getArguments().getSerializable("hourly");
        this.city = (City) getArguments().getSerializable("city");

        View view = inflater.inflate(R.layout.city_weather_hour_fragment, container, false);

        currentDescription = view.findViewById(R.id.tv_current_description);
        currentCityName = view.findViewById(R.id.tv_current_city);
        currentTemperature = view.findViewById(R.id.tv_current_temperature);
        latitud = view.findViewById(R.id.tv_current_latitude);
        longitud = view.findViewById(R.id.tv_current_longitude);
        humidity = view.findViewById(R.id.tv_current_humidity);
        viewHourly = view.findViewById(R.id.rv_city_weather_hourly);

        weatherImage = view.findViewById(R.id.im_current_weather);

        currentDescription.setText(weatherReport.getDescription().toUpperCase());
        currentCityName.setText(""+city.getName());
        currentTemperature.setText(""+(int)weatherReport.getTemperature()+" ºC");
        latitud.setText("Lat. "+String.format("%.2f", city.getLatitude()));
        longitud.setText("Lon. "+String.format("%.2f", city.getLongitude()));
        humidity.setText(""+weatherReport.getHumidity()+" %");

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.getContext(),DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(this.getContext(),R.drawable.city_divider));

        Glide.with(view.getContext())
                .load(weatherReport.getIconURL())
                .into(weatherImage);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        viewHourly.setLayoutManager(layoutManager);
        cityWeatherHourlyAdapter = new CityWeatherHourlyAdapter(weatherHourly);
        viewHourly.addItemDecoration(dividerItemDecoration);
        viewHourly.setAdapter(cityWeatherHourlyAdapter);

        return view;
    }
}
