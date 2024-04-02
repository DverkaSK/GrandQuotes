package ru.dverkask.grandquotes.ui;

import org.bukkit.entity.Player;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapPalette;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;
import org.jetbrains.annotations.NotNull;
import ru.dverkask.grandquotes.api.Quote;

public class MapImageRenderer extends MapRenderer {
    private final QuoteImageRenderer imageRenderer;

    public MapImageRenderer(Quote quote) {
        this.imageRenderer = new QuoteImageRenderer(quote);
    }

    @Override public void render(@NotNull MapView map,
                                 @NotNull MapCanvas canvas,
                                 @NotNull Player player) {
        map.setTrackingPosition(false);
        canvas.drawImage(0, 0, MapPalette.resizeImage(imageRenderer.draw()));
    }
}
