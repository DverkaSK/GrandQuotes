package ru.dverkask.grandquotes.config;

import lombok.Getter;

@Getter
public enum QuoteConfig {
    DEFAULT_TEXT_COLOR(new StringConfigValue("default.color.textcolor")),
    DEFAULT_BACKGROUND(new StringConfigValue("default.color.background")),
    DEFAULT_STROKE_COLOR(new StringConfigValue("default.color.strokecolor")),
    DEFAULT_FONT_NAME(new StringConfigValue("default.font.fontname")),
    DEFAULT_TEXT_STYLE(new IntConfigValue("default.font.textstyle")),
    DEFAULT_FONT_SIZE(new IntConfigValue("default.font.fontsize")),
    DEFAULT_QUOTE_TEXT(new StringConfigValue("default.quote.text")),
    DEFAULT_QUOTE_TITLE(new StringConfigValue("default.quote.title")),
    DEFAULT_QUOTE_ATTRIBUTION(new StringConfigValue("default.quote.attribution"));

    private final ConfigValue<?> configValue;
    QuoteConfig(ConfigValue<?> configValue) {
        this.configValue = configValue;
    }
    public <T> T value() {
        ConfigValue<T> castedConfigValue = (ConfigValue<T>) this.configValue;
        return castedConfigValue.value();
    }
}
