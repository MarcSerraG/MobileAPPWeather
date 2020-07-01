package cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import java.util.ArrayList;

import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.R;
import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.adapter.CityListAdapter;
import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.adapter.ClickInterface;
import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.domain.City;
import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.domain.CityWeather;
import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.factory.CityFactory;

public class MainActivity extends AppCompatActivity implements ClickInterface {

    ArrayList<City> citiesList = new ArrayList<>();
    RecyclerView city_view;
    CityListAdapter cityListAdapter;
    RelativeLayout mRelativeLayout;
    ClickInterface listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        city_view = findViewById(R.id.rv_city_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listener = this;
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        city_view.setLayoutManager(layoutManager);
        mRelativeLayout = findViewById(R.id.loadingPanel);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(this, R.drawable.city_divider));
        city_view.addItemDecoration(dividerItemDecoration);
        city_view.setAdapter(cityListAdapter);
        new PrepareData().execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.city_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.city_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                cityListAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private ArrayList<City> loadCities(){
        try {
            citiesList = CityFactory.parseAllCities(getAssets().open("city.list.json"));
        } catch (Exception ex) {}
        return  citiesList;
    }

    @Override
    public void recyclerviewOnClick(int position) {
        final City city = citiesList.get(position);

        String url = "https://api.openweathermap.org/data/2.5/onecall?lat="
                + city.getLatitude() + "&lon=" + city.getLongitude()
                + "&units=metric&exclude=minutely&appid=254664b1b8774ecd5419099bf817ced7";

        Log.d("MsG", "Tried to get URL: " + url);

        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("MsG", "onResponse: " + response);

                Gson gson = new Gson();
                CityWeather cityWeather = gson.fromJson(response, CityWeather.class);
                Log.d("MsG", "cityWeather is null? " + (cityWeather == null));
                cityWeather.setCity(city);

                Intent intent = new Intent(MainActivity.this, CityWeatherActivity.class);
                intent.putExtra("cityWeather", cityWeather);
                intent.putExtra("hourFragment", true);
                startActivity(intent);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle(getString(R.string.error_exclamation));
                alertDialog.setMessage(getString(R.string.url_request_error));
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
        });

        queue.add(stringRequest);

    }

    private class PrepareData extends AsyncTask<Void, Void, Void> {
        private ArrayList<City> acityArray;
        protected void onPreExecute(Void param) {
        }

        protected Void doInBackground(Void... param) {
            acityArray = loadCities();
            return null;
        }

        protected void onPostExecute(Void param) {
            cityListAdapter = new CityListAdapter(acityArray, listener);
            cityListAdapter.notifyDataSetChanged();
            city_view.setAdapter(cityListAdapter);
            findViewById(R.id.loadingPanel).setVisibility(View.GONE);
        }
    }

}