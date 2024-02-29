package ru.dverkask.grandquotes.config;

import ru.dverkask.grandquotes.GrandQuotes;

public enum QuoteConfig {
    DEFAULT_TEXT_COLOR("default.textcolor"),
    DEFAULT_BACKGROUND("default.background"),
    DEFAULT_STROKE_COLOR("default.strokecolor"),
    DEFAULT_FONT_NAME("default.fontname"),
    DEFAULT_TEXT_STYLE("default.textstyle"),
    DEFAULT_FONT_SIZE("default.fontsize");

    private final String path;
    QuoteConfig(String path) {
        this.path = path;
    }

    public static void init(GrandQuotes plugin) {

    }
}
