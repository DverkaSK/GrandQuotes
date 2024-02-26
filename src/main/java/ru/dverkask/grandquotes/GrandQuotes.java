package ru.dverkask.grandquotes;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import ru.dverkask.grandquotes.api.Quote;
import ru.dverkask.grandquotes.events.PlayerChatListener;
import ru.dverkask.grandquotes.ui.QuoteImageRenderer;
import ru.dverkask.skinanatomy.SkinAnatomyPlugin;
import ru.dverkask.skinanatomy.api.SkinAnatomy;

import java.awt.*;
import java.util.UUID;

public final class GrandQuotes extends JavaPlugin {
    @Getter
    private static SkinAnatomy API;
    @Override
    public void onEnable() {
        Plugin skinAnatomyPlugin = Bukkit.getPluginManager().getPlugin("SkinAnatomyPlugin");

        System.out.println(skinAnatomyPlugin + " " + "mama");

        if (skinAnatomyPlugin instanceof SkinAnatomyPlugin) {
            if (skinAnatomyPlugin.isEnabled()) {
                API = SkinAnatomyPlugin.getSkinAnatomyAPI();
                System.out.println("good");
            }
        } else {
            API = null;
            System.out.println("bad");
        }

        getServer().getPluginManager().registerEvents(new PlayerChatListener(), this);
    }
}
