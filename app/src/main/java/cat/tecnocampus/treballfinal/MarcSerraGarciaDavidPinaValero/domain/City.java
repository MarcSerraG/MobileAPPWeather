package cat.tecnocampus.treballfinal.MarcSerraGarciaDavidPinaValero.domain;

import java.io.Serializable;

public class City implements Serializable {
    private static final long serialVersionUID = 7526472295622776147L;

    private int id;
    private String name;
    private String state;
    private String country;
    private String longitude;
    private String latitude;


    public City(int id, String name, String state, String country, String longitude, String latitude) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.country = country;
        this.longitude = longitude;
        this.latitude = latitude;
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

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
