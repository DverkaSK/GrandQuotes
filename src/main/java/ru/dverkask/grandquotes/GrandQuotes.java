package ru.dverkask.grandquotes;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import ru.dverkask.grandquotes.commands.QuoteCommand;
import ru.dverkask.grandquotes.events.PlayerChatListener;

public final class GrandQuotes extends JavaPlugin {
    @Getter
    private static GrandQuotes instance;
    @Override
    public void onEnable() {
        saveDefaultConfig();

        instance = this;
        this.getCommand("quote").setExecutor(new QuoteCommand());
        getServer().getPluginManager().registerEvents(new PlayerChatListener(), this);
    }
}
