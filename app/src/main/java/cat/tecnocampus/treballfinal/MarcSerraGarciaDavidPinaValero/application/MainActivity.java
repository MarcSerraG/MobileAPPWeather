package cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.R;
import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.adapter.CityListAdapter;
import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.domain.City;

public class MainActivity extends AppCompatActivity {

    List<City> citiesList = new ArrayList<>();
    RecyclerView city_view;
    CityListAdapter cityListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dummycities();

        city_view = findViewById(R.id.rv_city_list);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        city_view.setLayoutManager(layoutManager);
        cityListAdapter = new CityListAdapter(citiesList);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(this,R.drawable.city_divider));
        city_view.addItemDecoration(dividerItemDecoration);
        city_view.setAdapter(cityListAdapter);
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


    private void dummycities(){
        citiesList.add(new City(6356055,"Barcelona",
                "","ES","2.12804","41.399422"));
        citiesList.add(new City( 6359304,"Madrid",
                "","ES","-3.68275","40.489349"));
    }
}