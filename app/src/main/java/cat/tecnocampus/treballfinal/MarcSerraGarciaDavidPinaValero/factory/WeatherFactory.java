package cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.factory;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.R;
import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.domain.City;
import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.domain.CityWeather;

public class WeatherFactory {

    public static CityWeather getWeatherCity(City city, RequestQueue queue) {

        String url = "https://api.openweathermap.org/data/2.5/onecall?lat="
                + city.getLatitude() + "&lon=" + city.getLongitude()
                + "&units=metric&exclude=minutely&appid=254664b1b8774ecd5419099bf817ced7";
        final String[] requestResponse = new String[1];

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                requestResponse[0] = response;
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                requestResponse[0] = String.valueOf(R.string.error_weather_factory);
            }
        });

        Gson gson = new Gson();
        CityWeather cityWeather = gson.fromJson(requestResponse[0], CityWeather.class);

        return cityWeather;
    }

}
