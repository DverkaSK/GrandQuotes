package ru.dverkask.grandquotes;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import ru.dverkask.grandquotes.events.PlayerChatListener;
import ru.dverkask.skinanatomy.SkinAnatomyPlugin;
import ru.dverkask.skinanatomy.api.SkinAnatomy;

public final class GrandQuotes extends JavaPlugin {
    @Getter
    private static SkinAnatomy API;
    @Override
    public void onEnable() {
        SkinAnatomyPlugin skinAnatomyPlugin = (SkinAnatomyPlugin) Bukkit.getPluginManager().getPlugin("SkinAnatomyPlugin");
        if (skinAnatomyPlugin != null && skinAnatomyPlugin.isEnabled())
            API = SkinAnatomyPlugin.getSkinAnatomyAPI();

        getServer().getPluginManager().registerEvents(new PlayerChatListener(), this);
    }
}
