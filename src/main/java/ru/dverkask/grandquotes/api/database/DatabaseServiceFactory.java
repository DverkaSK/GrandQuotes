package ru.dverkask.grandquotes.api.database;

public class DatabaseServiceFactory {
    public static DatabaseService createService(DatabaseType type) {
        switch (type) {
            case SQLITE -> {
                return new SQLiteDatabaseService();
            }

            case REDIS ->  {
                return new RedisDatabaseService();
            }

            default -> throw new IllegalArgumentException("Unsupported database type: " + type);
        }
    }
}
