package cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.factory;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;

import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.domain.City;

public class CityFactory {

    public static ArrayList<City> parseAllCities() {

        try {
            Reader reader = new FileReader("/src/main/assets/city.list.json" );

            Gson gson = new Gson();

            Type cityListType = new TypeToken<ArrayList<City>>(){}.getType();

            ArrayList<City> cityList = gson.fromJson(reader, cityListType);

            return cityList;
        }
        catch (Exception ex) {
            Log.d("Files", "City list in assets not found");
            return null; // tu confia
        }
    }

}
