package ru.dverkask.grandquotes;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import ru.dverkask.grandquotes.api.Quote;
import ru.dverkask.grandquotes.commands.QuoteCommand;
import ru.dverkask.grandquotes.events.PlayerChatListener;
import ru.dverkask.grandquotes.ui.QuoteImageRenderer;

import java.awt.*;
import java.util.Objects;
import java.util.UUID;

public final class GrandQuotes extends JavaPlugin {
    @Override
    public void onEnable() {
        this.getCommand("quote").setExecutor(new QuoteCommand());
        getServer().getPluginManager().registerEvents(new PlayerChatListener(), this);
    }
}
