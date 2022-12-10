package domain.service;

import util.DbConnectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ImageService {
    private final Connection connection;
    private final String schema;

    public ImageService() {
        this.connection = DbConnectionService.getDbConnection();
        this.schema = DbConnectionService.getSchema();
    }

    public void addImage(String filename) {
        String query = String.format("insert into %s.images (filename) values (?)", schema);
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, filename);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public ArrayList<String> getAllImages() {
        ArrayList<String> images = new ArrayList<>();
        String sql = String.format("SELECT * from %s.images", schema);
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String name = result.getString("filename");
                images.add(name);
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return images;
    }

    private Connection getConnection() {
        return this.connection;
    }
}


