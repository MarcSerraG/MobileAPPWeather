package cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.R;

public class CityWeatherHourFragment extends Fragment {

    public CityWeatherHourFragment(){}

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.city_weather_hour_fragment, container, false);
        return view;
    }
}
