package cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.domain;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class City implements Serializable, Parcelable {

    private int id;
    private String name;
    private String state;
    private String country;
    private Coords coord;


    public City() {
    }

    protected City(Parcel in) {
        super();
        readFromParcel(in);
    }

    public static final Creator<City> CREATOR = new Creator<City>() {
        @Override
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getLongitude() {
        return coord.longitude;
    }

    public void setLongitude(double longitude) {
        this.coord.longitude = longitude;
    }

    public double getLatitude() {
        return coord.latitude;
    }

    public void setLatitude(long latitude) {
        this.coord.latitude = latitude;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(state);
        dest.writeString(country);
    }

    public void readFromParcel(Parcel in){
        id = in.readInt();
        name = in.readString();
        state = in.readString();
        country = in.readString();
    }

    private class Coords implements Serializable {

        @SerializedName("lon")
        private double longitude;

        @SerializedName("lat")
        private double latitude;
    }
}
