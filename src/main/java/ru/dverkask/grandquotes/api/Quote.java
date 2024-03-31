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
    private String text = QuoteConfig.DEFAULT_QUOTE_TEXT.value();
    @Builder.Default
    private String title = QuoteConfig.DEFAULT_QUOTE_TITLE.value();
    @Builder.Default
    private String attribution = QuoteConfig.DEFAULT_QUOTE_ATTRIBUTION.value();
    @Builder.Default
    private Color  background = Color.decode(QuoteConfig.DEFAULT_BACKGROUND.value());
    @Builder.Default
    private Color  strokeColor = Color.decode(QuoteConfig.DEFAULT_STROKE_COLOR.value());


    @Builder
    @Getter
    public static class Decoration {
        public static final Decoration DEFAULT   = Decoration.builder().build();
        @Builder.Default
        private             String     name      = QuoteConfig.DEFAULT_FONT_NAME.value();
        @Builder.Default
        private             int        style     = QuoteConfig.DEFAULT_TEXT_STYLE.value();
        @Builder.Default
        private             int        size      = QuoteConfig.DEFAULT_FONT_SIZE.value();
        @Builder.Default
        private             Color      textColor = Color.decode(QuoteConfig.DEFAULT_TEXT_COLOR.value());

        public Font font() {
            return new Font(name, style, size);
        }
    }
}
