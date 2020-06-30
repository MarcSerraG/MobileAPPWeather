package cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.R;
import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.domain.WeatherReportDaily;

public class CityWeatherWeekFragment extends Fragment {

    private ArrayList<WeatherReportDaily> dailyReports;

    public CityWeatherWeekFragment(){}

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        if (bundle != null) {
            this.dailyReports = (ArrayList<WeatherReportDaily>) bundle.getSerializable("daily");
        }

        View view = inflater.inflate(R.layout.city_weather_week_fragment, container, false);
        return view;
    }

}
