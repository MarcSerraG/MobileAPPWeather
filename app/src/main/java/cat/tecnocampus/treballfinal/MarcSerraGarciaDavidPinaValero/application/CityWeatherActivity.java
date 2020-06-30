package cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.application;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.R;
import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.domain.City;
import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.domain.CityWeather;
import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.fragment.CityWeatherHourFragment;

public class CityWeatherActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private City city;
    private CityWeather cityWeather;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_city_activity);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new CityWeatherHourFragment()).commit();

        Intent intent = getIntent();
        if (intent.hasExtra("cityWeather")) {
            this.cityWeather = (CityWeather) intent.getSerializableExtra("cityWeather");
            this.city = cityWeather.getCity();
        }
        else finish();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()){
            case R.id.mi_city_hour:
                fragment = new CityWeatherHourFragment();
                break;
            case R.id.mi_city_week:
                break;
        }
        return loadFragment(fragment);
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
