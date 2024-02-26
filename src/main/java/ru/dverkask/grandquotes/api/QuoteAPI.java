package ru.dverkask.grandquotes.api;

import ru.dverkask.grandquotes.ui.QuoteImageRenderer;

import java.awt.*;
import java.util.UUID;

public class QuoteAPI {
    public static void main(String[] args) {
        Quote quote = Quote.builder()
                .background(Color.BLACK)
                .uuid(UUID.randomUUID())
                .text("test")
                .textColor(Color.WHITE)
                .font(Quote.QuoteDecoration.builder()
                        .style(Font.PLAIN)
                        .size(8)
                        .name("Minecraft RUS")
                        .build())
                .build();

        QuoteImageRenderer renderer = new QuoteImageRenderer(quote);

        renderer.draw();
    }
}
