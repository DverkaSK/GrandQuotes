package ru.dverkask.grandquotes;

import org.bukkit.plugin.java.JavaPlugin;
import ru.dverkask.grandquotes.api.Quote;
import ru.dverkask.grandquotes.events.PlayerChatListener;
import ru.dverkask.grandquotes.ui.QuoteImageRenderer;

import java.awt.*;
import java.util.UUID;

public final class GrandQuotes extends JavaPlugin {
    @Override
    public void onEnable() {
        Quote quote = Quote.builder()
                .uuid(UUID.randomUUID())
                .background(Color.BLACK)
                .font(Quote.QuoteDecoration.builder()
                        .style(Font.PLAIN)
                        .size(14)
                        .name("Arial")
                        .build())
                .strokeColor(Color.WHITE)
                .text("test text")
                .build();
        QuoteImageRenderer renderer = new QuoteImageRenderer(quote);
        renderer.draw();

        getServer().getPluginManager().registerEvents(new PlayerChatListener(), this);
    }
}
