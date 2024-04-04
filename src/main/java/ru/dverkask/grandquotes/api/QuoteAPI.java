package ru.dverkask.grandquotes.api;

import ru.dverkask.grandquotes.api.database.DatabaseService;
import ru.dverkask.grandquotes.api.database.DatabaseServiceFactory;
import ru.dverkask.grandquotes.api.database.DatabaseType;

public class QuoteAPI {
    private DatabaseService databaseService;
    public QuoteAPI(DatabaseType type) {
        this.databaseService = DatabaseServiceFactory.createService(type);
    }

    public QuoteAPI() {
        this(DatabaseType.SQLITE);
    }
    /*
        TODO Add Redis/SQLite support; instance for api; save each quote
    */
}
