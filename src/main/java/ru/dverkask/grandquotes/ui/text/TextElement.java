package ru.dverkask.grandquotes.ui.text;

import ru.dverkask.grandquotes.api.Quote;

public record TextElement(String text, TextFormatter formatter, Quote.Decoration decoration) {
    public TextElement(String text, TextFormatter formatter, Quote.Decoration decoration) {
        this.text = text;
        this.formatter = formatter;
        this.decoration = decoration;
    }
}
