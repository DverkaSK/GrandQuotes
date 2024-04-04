package ru.dverkask.grandquotes.config;

import lombok.Getter;

public abstract class ConfigValue<T> {
    protected final String path;

    public ConfigValue(String path) {
        this.path = path;
    }

    public abstract T value();
}
