package ru.dverkask.grandquotes.api.database;

import ru.dverkask.grandquotes.api.Quote;

import java.util.List;

public interface DatabaseService {
    void saveQuote(Quote quote);
    Quote getQuoteById(String id);
    List<Quote> getAllQuotes();
}
