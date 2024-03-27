package ru.dverkask.grandquotes.ui.text;

import ru.dverkask.grandquotes.api.Quote;

public record TextElement(String text, TextFormatter formatter, Quote.QuoteDecoration quoteDecoration) {
    public TextElement(String text, TextFormatter formatter, Quote.QuoteDecoration quoteDecoration) {
        this.text = text;
        this.formatter = formatter;
        this.quoteDecoration = quoteDecoration;
    }
}
