package ru.dverkask.grandquotes.database.config;

public class RedisDatabaseConfig implements DatabaseConfig {
    private final String connectionString;

    public RedisDatabaseConfig(String connectionString) {
        this.connectionString = connectionString;
    }

    public String getConnectionString() {
        return connectionString;
    }
}
