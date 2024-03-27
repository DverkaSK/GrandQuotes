package ru.dverkask.grandquotes.api;

import lombok.Builder;
import lombok.Getter;
import org.bukkit.entity.Player;
import ru.dverkask.grandquotes.config.QuoteConfig;

import java.awt.*;

@Builder
@Getter
public class Quote {
    private Player player;
    private Player owner;
    @Builder.Default
    private String text = QuoteConfig.DEFAULT_TEXT_COLOR.getPath();
    private String title;
    private String attribution;
    private Color  background;
    private Color  strokeColor;


    @Builder
    @Getter
    public static class QuoteDecoration {
        @Builder.Default
        private String name  = "Minecraft Rus";
        @Builder.Default
        private int    style = Font.PLAIN;
        @Builder.Default
        private int    size  = 8;
        @Builder.Default
        private Color  textColor = Color.WHITE;

        public Font font() {
            return new Font(name, style, size);
        }
    }
}
