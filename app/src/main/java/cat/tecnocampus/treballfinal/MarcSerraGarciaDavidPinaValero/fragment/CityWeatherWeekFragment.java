package cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.R;
import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.adapter.CityWeatherWeeklyAdapter;
import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.application.CityWeatherActivity;
import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.domain.WeatherReportDaily;

public class CityWeatherWeekFragment extends Fragment {

    private ArrayList<WeatherReportDaily> dailyReports;
    private CityWeatherWeeklyAdapter weeklyAdapter;
    private RecyclerView reportView;

    public CityWeatherWeekFragment(){}

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Bundle bundle = getArguments();

        this.dailyReports = (ArrayList<WeatherReportDaily>) bundle.getSerializable("daily");
        weeklyAdapter = new CityWeatherWeeklyAdapter(dailyReports);

        View view = inflater.inflate(R.layout.city_weather_week_fragment, container, false);

        reportView = view.findViewById(R.id.rv_daily_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        reportView.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.getContext(),DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(this.getContext(),R.drawable.city_divider));
        reportView.setAdapter(weeklyAdapter);

        return view;
    }

}
