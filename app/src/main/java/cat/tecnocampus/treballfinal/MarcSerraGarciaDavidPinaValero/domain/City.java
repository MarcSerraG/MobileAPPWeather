package cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class City implements Serializable {
    private static final long serialVersionUID = 7526472295622776147L;

    private int id;
    private String name;
    private String state;
    private String country;
    private Coords coord;


    public City() {
    }

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

    private class Coords implements Serializable {

        @SerializedName("lon")
        private double longitude;

        @SerializedName("lat")
        private double latitude;
    }
}
