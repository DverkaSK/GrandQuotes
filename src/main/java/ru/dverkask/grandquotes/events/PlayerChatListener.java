package ru.dverkask.grandquotes.events;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerChatListener implements Listener {
    @EventHandler public void onPlayerChat(AsyncChatEvent e) {
        Player player = e.getPlayer();
        String nickname = player.getName();

        Component message = e.message();

        ClickEvent clickEvent = ClickEvent.clickEvent(
                ClickEvent.Action.SUGGEST_COMMAND, "/quote " + nickname + " " +
                        PlainTextComponentSerializer.plainText().serialize(message)
        );
        message = message.clickEvent(clickEvent);

        e.message(message);
    }
}
