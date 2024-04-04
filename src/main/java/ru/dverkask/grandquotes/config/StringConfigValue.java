package ru.dverkask.grandquotes.config;

import ru.dverkask.grandquotes.GrandQuotes;

public class StringConfigValue extends ConfigValue<String> {
    public StringConfigValue(String path) {
        super(path);
    }

    @Override public String value() {
        return GrandQuotes.getInstance().getConfig().getString(path);
    }
}
