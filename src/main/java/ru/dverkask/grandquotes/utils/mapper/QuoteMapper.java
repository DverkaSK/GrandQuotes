package ru.dverkask.grandquotes.utils.mapper;

import org.bukkit.Bukkit;
import org.jooq.Record;
import ru.dverkask.grandquotes.Quote;
import ru.dverkask.grandquotes.utils.ColorUtils;

public final class QuoteMapper {
    private QuoteMapper() {

    }

    public static Quote mapRecordToQuote(final Record record) {
        return Quote.builder()
                .player(Bukkit.getPlayer(record.get("target", String.class))) // Обработка не найденных игроков
                .owner(Bukkit.getPlayer(record.get("owner", String.class))) // То же самое
                .text(record.get("text", String.class))
                .title(record.get("title", String.class))
                .attribution(record.get("attribution", String.class))
                .background(ColorUtils.fromHexString(record.get("background_color_hex", String.class)))
                .strokeColor(ColorUtils.fromHexString(record.get("stroke_color_hex", String.class)))
                .build();
    }
}
