package cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.factory;

import android.net.Uri;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;

import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.domain.City;

public class CityFactory {

    public static ArrayList<City> parseAllCities(InputStream is) {

        try {
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new InputStreamReader(is));
            Type cityListType = new TypeToken<ArrayList<City>>(){}.getType();
            return gson.fromJson(reader, cityListType);
        }
        catch (Exception ex) {
            Log.d("MsG", "City list in assets not found! " + ex.getMessage());
            return null; // tu confia
        }
    }

}
