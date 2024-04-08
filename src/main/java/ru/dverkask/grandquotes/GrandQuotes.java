package ru.dverkask.grandquotes;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import ru.dverkask.grandquotes.commands.QuoteCommand;
import ru.dverkask.grandquotes.database.DatabaseManager;
import ru.dverkask.grandquotes.database.DatabaseType;
import ru.dverkask.grandquotes.database.config.SQLiteDatabaseConfig;
import ru.dverkask.grandquotes.events.PlayerChatListener;

import java.io.File;
import java.io.IOException;

public final class GrandQuotes extends JavaPlugin {
    @Getter
    private static GrandQuotes instance;
    @Getter
    private final DatabaseManager databaseManager = new DatabaseManager();
    @Override
    public void onEnable() {
        instance = this;

        this.saveDefaultConfig();
        this.saveDatabaseFile();

        this.getCommand("quote").setExecutor(new QuoteCommand());
        this.getServer().getPluginManager().registerEvents(new PlayerChatListener(), this);
    }

    private void saveDatabaseFile() {
        File databaseFile = new File(this.getDataFolder().getPath(), "test.db");
        if (!databaseFile.exists()) {
            try {
                databaseFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        this.databaseManager.addDatabaseService(DatabaseType.SQLITE, new SQLiteDatabaseConfig("test.db"));
    }
}
