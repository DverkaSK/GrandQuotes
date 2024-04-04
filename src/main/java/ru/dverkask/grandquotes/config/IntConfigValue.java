package ru.dverkask.grandquotes.config;

import ru.dverkask.grandquotes.GrandQuotes;

public class IntConfigValue extends ConfigValue<Integer> {
    public IntConfigValue(String path) {
        super(path);
    }

    @Override public Integer value() {
        return GrandQuotes.getInstance().getConfig().getInt(path);
    }
}
