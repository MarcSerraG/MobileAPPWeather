package cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.factory;

import android.net.Uri;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;

import cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.domain.City;

public class CityFactory {

    public static ArrayList<City> parseAllCities(InputStream is) {

        try {

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer);

            Gson gson = new Gson();

            Type cityListType = new TypeToken<ArrayList<City>>(){}.getType();

            return gson.fromJson(json, cityListType);
        }
        catch (Exception ex) {
            Log.d("MsG", "City list in assets not found! " + ex.getMessage());
            return null; // tu confia
        }
    }

}
