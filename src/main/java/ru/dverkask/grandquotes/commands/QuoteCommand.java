package ru.dverkask.grandquotes.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import ru.dverkask.grandquotes.api.Quote;
import ru.dverkask.grandquotes.api.map.MapConfiguration;
import ru.dverkask.grandquotes.api.map.QuoteMap;
import ru.dverkask.grandquotes.config.QuoteConfig;
import ru.dverkask.grandquotes.ui.MapImageRenderer;

import java.awt.*;
import java.util.Optional;

public class QuoteCommand implements CommandExecutor {
    @Override public boolean onCommand(@NotNull CommandSender sender,
                                       @NotNull Command command,
                                       @NotNull String label,
                                       @NotNull String[] args) {
        if (sender instanceof Player player) {
            String nickname = args[0];
            String message = null;

            if (args.length >= 2) {
                message = args[1];
            }

            Quote quote = Quote.builder()
                    .player(Bukkit.getPlayer(nickname))
                    .owner(player)
                    .text(Optional.ofNullable(message).orElse(QuoteConfig.DEFAULT_QUOTE_TEXT.value()))
                    .build();

            MapImageRenderer mapImageRenderer = new MapImageRenderer(quote);
            MapConfiguration.configureMapView(mapImageRenderer);
            QuoteMap quoteMap = new QuoteMap(MapConfiguration.mapView());
            quoteMap.giveMapToPlayer(player,
                    quoteMap.generateMap());
        }

        return true;
    }
}
