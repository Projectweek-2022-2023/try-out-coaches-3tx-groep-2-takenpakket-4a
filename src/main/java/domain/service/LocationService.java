package domain.service;

import domain.model.Location;
import util.DbConnectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class LocationService {

    private final Connection connection;

    private final String schema;

    public LocationService() {
        this.connection = DbConnectionService.getDbConnection();
        this.schema = DbConnectionService.getSchema();
    }

    public void addLocation(Location location) {
        String query = String.format("insert into %s.gpx (lat,lon) values (?,?)", schema);
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setDouble(1, location.getLat());
            preparedStatement.setDouble(2, location.getLon());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }



    public ArrayList<Location> getAllLocations() {
        ArrayList<Location> locations = new ArrayList<>();
        String sql = String.format("SELECT * from %s.gpx", schema);
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                double lat = result.getDouble("lat");
                double lon = result.getDouble("lon");
                locations.add(new Location( lat, lon));
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return locations;
    }


    private Connection getConnection() {
        return this.connection;
    }
}
