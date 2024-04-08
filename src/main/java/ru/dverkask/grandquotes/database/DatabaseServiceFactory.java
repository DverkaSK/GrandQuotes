package ru.dverkask.grandquotes.database;

import ru.dverkask.grandquotes.GrandQuotes;
import ru.dverkask.grandquotes.database.config.DatabaseConfig;
import ru.dverkask.grandquotes.database.config.RedisDatabaseConfig;
import ru.dverkask.grandquotes.database.config.SQLiteDatabaseConfig;

import java.io.File;
import java.io.IOException;

public class DatabaseServiceFactory {
    public static DatabaseService createService(DatabaseType type, DatabaseConfig config) {
        switch (type) {
            case SQLITE -> {
                SQLiteDatabaseConfig sqliteConfig = (SQLiteDatabaseConfig) config;
                return new SQLiteDatabaseService(sqliteConfig.path());
            }

            case REDIS ->  {
                RedisDatabaseConfig redisConfig = (RedisDatabaseConfig) config;
                return new RedisDatabaseService(redisConfig.getConnectionString());
            }

            default -> throw new IllegalArgumentException("Unsupported database type: " + type);
        }
    }
}
