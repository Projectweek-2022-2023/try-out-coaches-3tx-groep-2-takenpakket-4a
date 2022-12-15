package domain.model;

public class Location {
    private double lat;
    private double lon;

    public Location(double lat, double lon) {
        this.setLatitude(lat);
        this.setLongitude(lon);
    }
    public Location() {
    }




    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLatitude(double latitude) {
        this.lat = latitude;
    }

    public void setLongitude(double longitude) {
        this.lon = longitude;
    }
}
