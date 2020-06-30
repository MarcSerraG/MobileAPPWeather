package cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import java.util.ArrayList;

import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.R;
import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.domain.WeatherReport;

public class CityWeatherHourFragment extends Fragment {

    private ArrayList<WeatherReport> hourlyReports;

    public CityWeatherHourFragment(){}

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        if (bundle != null)
            this.hourlyReports = (ArrayList<WeatherReport>) bundle.getSerializable("hourly");

        View view = inflater.inflate(R.layout.city_weather_hour_fragment, container, false);

        return view;
    }
}
