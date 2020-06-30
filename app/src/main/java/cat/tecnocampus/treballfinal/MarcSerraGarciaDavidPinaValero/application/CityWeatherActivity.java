package cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.application;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.R;
import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.domain.City;
import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.domain.CityWeather;
import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.fragment.CityWeatherHourFragment;
import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.fragment.CityWeatherWeekFragment;

public class CityWeatherActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private City city;
    private CityWeather cityWeather;
    private Fragment hourlyFragment;
    private Fragment weeklyFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_city_activity);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(this);

        Intent intent = getIntent();
        if (intent.hasExtra("cityWeather")) {
            this.cityWeather = (CityWeather) intent.getSerializableExtra("cityWeather");
            this.city = cityWeather.getCity();
        }
        else finish();

        Bundle bundle = new Bundle();
        if (hourlyFragment == null) hourlyFragment = new CityWeatherHourFragment();
        bundle.putSerializable("hourly", cityWeather.getHourly());
        bundle.putSerializable("current",cityWeather.getCurrent());
        bundle.putSerializable("city", city);
        hourlyFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,hourlyFragment).commit();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Bundle bundle = new Bundle();

        switch (item.getItemId()){
            case R.id.mi_city_hour:
                if (hourlyFragment == null) hourlyFragment = new CityWeatherHourFragment();
                bundle.putSerializable("hourly", cityWeather.getHourly());
                bundle.putSerializable("current",cityWeather.getCurrent());
                bundle.putSerializable("city", city);
                hourlyFragment.setArguments(bundle);
                return loadFragment(hourlyFragment);
            case R.id.mi_city_week:
                if (weeklyFragment == null) weeklyFragment = new CityWeatherWeekFragment();
                bundle.putSerializable("daily", cityWeather.getDaily());
                weeklyFragment.setArguments(bundle);
                return loadFragment(weeklyFragment);
        }
        return loadFragment(hourlyFragment);
    }

    private boolean loadFragment(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
