package ru.dverkask.grandquotes.config;

import lombok.Getter;
import ru.dverkask.grandquotes.GrandQuotes;

public enum QuoteConfig {
    DEFAULT_TEXT_COLOR("default.color.textcolor"),
    DEFAULT_BACKGROUND("default.color.background"),
    DEFAULT_STROKE_COLOR("default.color.strokecolor"),
    DEFAULT_FONT_NAME("default.font.fontname"),
    DEFAULT_TEXT_STYLE("default.font.textstyle"),
    DEFAULT_FONT_SIZE("default.font.fontsize"),
    DEFAULT_QUOTE_TEXT("default.quote.text"),
    DEFAULT_QUOTE_TITLE("default.quote.title"),
    DEFAULT_QUOTE_ATTRIBUTION("default.quote.attribution");

    @Getter private final String path;
    QuoteConfig(String path) {
        this.path = path;
    }

    public static void init(GrandQuotes plugin) {

    }
}
