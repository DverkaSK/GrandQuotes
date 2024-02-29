package ru.dverkask.grandquotes.api;

import lombok.Builder;
import lombok.Getter;

import java.awt.*;
import java.util.UUID;

@Builder
@Getter
public class Quote {
    private Color           background;
    private UUID            uuid;
    private String          text;
    private Color           textColor;
    private Color           strokeColor;
    private QuoteDecoration font;

    @Builder
    @Getter
    public static class QuoteDecoration {
        @Builder.Default
        private String name  = "Arial";
        @Builder.Default
        private int    style = Font.PLAIN;
        @Builder.Default
        private int    size  = 8;

        public Font font() {
            return new Font(name, style, size);
        }
    }
}
