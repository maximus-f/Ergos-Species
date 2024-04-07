package com.ergoscraft.species.storage.mysql;

import com.ergoscraft.species.Ergos_Species;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.*;
import java.util.UUID;

public class MySQLWrapper {
    private final HikariDataSource dataSource;

    public MySQLWrapper(String url, String username, String password) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        dataSource = new HikariDataSource(config);

        createSpeciesTable();
        createSwapTable();
    }

    private void createSpeciesTable() {
        try (Connection connection = dataSource.getConnection()) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Species ("
                    + "id VARCHAR(36) PRIMARY KEY,"
                    + "species VARCHAR(255)"
                    + ")";
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(createTableSQL);
            }
        } catch (SQLException e) {
            Ergos_Species.log(e.getMessage());
        }
    }

    private void createSwapTable() {
        try (Connection connection = dataSource.getConnection()) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Swaps ("
                    + "id VARCHAR(36) PRIMARY KEY,"
                    + "swaps TINYINT"
                    + ")";
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(createTableSQL);
            }
        } catch (SQLException e) {
            Ergos_Species.log(e.getMessage());
        }
    }

    public void setSpecies(UUID id, String species) {
        try (Connection connection = dataSource.getConnection()) {
            if (getSpecies(id) != null) {
                updateSpecies(id, species, connection);
            } else {
                insertSpecies(id, species, connection);
            }
        } catch (SQLException e) {
            Ergos_Species.log(e.getMessage());
        }
    }

    public String getSpecies(UUID id) {
        try (Connection connection = dataSource.getConnection()) {
            String query = "SELECT species FROM Species WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, id.toString());
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getString("species");
                    }
                }
            }
        } catch (SQLException e) {
            Ergos_Species.log(e.getMessage());
        }
        return null;
    }

    private void insertSpecies(UUID id, String species, Connection connection) throws SQLException {
        String query = "INSERT INTO Species (id, species) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id.toString());
            statement.setString(2, species);
            statement.executeUpdate();
        } catch (SQLException e){
            Ergos_Species.log(e.getMessage());
        }
    }

    private void updateSpecies(UUID id, String species, Connection connection) throws SQLException {
        String query = "UPDATE Species SET species = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, species);
            statement.setString(2, id.toString());
            statement.executeUpdate();
        } catch (SQLException e){
            Ergos_Species.log(e.getMessage());
        }
    }

    public void setSwaps(UUID id, int swaps) {
        try (Connection connection = dataSource.getConnection()) {
            if (getSwaps(id) != null) {
                updateSwaps(id, swaps, connection);
            } else {
                insertSwaps(id, swaps, connection);
            }
        } catch (SQLException e) {
            Ergos_Species.log(e.getMessage());
        }
    }

    public Integer getSwaps(UUID id) {
        try (Connection connection = dataSource.getConnection()) {
            String query = "SELECT swaps FROM Swaps WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, id.toString());
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getInt("swaps");
                    }
                }
            }
        } catch (SQLException e) {
            Ergos_Species.log(e.getMessage());
        }
        return null;
    }

    private void insertSwaps(UUID id, int swaps, Connection connection) throws SQLException {
        String query = "INSERT INTO Swaps (id, swaps) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id.toString());
            statement.setInt(2, swaps);
            statement.executeUpdate();
        } catch (SQLException e) {
            Ergos_Species.log(e.getMessage());
        }
    }

    private void updateSwaps(UUID id, int swaps, Connection connection) throws SQLException {
        String query = "UPDATE Swaps SET swaps = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, swaps);
            statement.setString(2, id.toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            Ergos_Species.log(e.getMessage());
        }
    }

    public void shutdown() {
        if (dataSource != null) {
            dataSource.close();
        }
    }
}