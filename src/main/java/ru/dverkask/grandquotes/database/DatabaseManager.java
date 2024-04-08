package ru.dverkask.grandquotes.database;

import ru.dverkask.grandquotes.Quote;
import ru.dverkask.grandquotes.database.config.DatabaseConfig;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private final List<DatabaseService> databaseServices = new ArrayList<>();

    public void addDatabaseService(DatabaseType type, DatabaseConfig config) {
        this.databaseServices.add(DatabaseServiceFactory.createService(type, config));
    }

    public void saveQuote(Quote quote) {
        for(DatabaseService service : databaseServices) {
            service.saveQuote(quote);
        }
    }
}
