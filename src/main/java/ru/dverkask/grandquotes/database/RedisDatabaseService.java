package ru.dverkask.grandquotes.database;

import ru.dverkask.grandquotes.Quote;

import java.util.List;

public class RedisDatabaseService implements DatabaseService {
    public RedisDatabaseService(String connection) {

    }
    @Override public void saveQuote(Quote quote) {

    }

    @Override public Quote getQuoteById(String id) {
        return null;
    }

    @Override public List<Quote> getAllQuotes() {
        return null;
    }
}
