package ru.dverkask.grandquotes.database.config;

import lombok.Getter;

public record SQLiteDatabaseConfig(String path) implements DatabaseConfig {
}
