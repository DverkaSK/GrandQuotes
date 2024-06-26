package ru.dverkask.grandquotes.database;

import ru.dverkask.grandquotes.Quote;

import java.util.List;

public interface DatabaseService {
    void saveQuote(Quote quote);
    Quote getQuoteById(String id);
    List<Quote> getAllQuotes();
}
