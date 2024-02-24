package ru.dverkask.grandquotes.ui;

import lombok.NonNull;
import ru.dverkask.grandquotes.GrandQuotes;
import ru.dverkask.grandquotes.api.Quote;
import ru.dverkask.skinanatomy.api.SkinAnatomy;
import ru.dverkask.skinanatomy.api.SkinAnatomyAPI;

import java.awt.*;
import java.awt.image.BufferedImage;

public class QuoteImageGenerator {
    private static final int           IMAGE_SIZE = 128;
    private final        BufferedImage bufferedImage;
    private final        Graphics2D    graphics;
    private final        Quote         quote;
    private final        SkinAnatomy   api        = GrandQuotes.getAPI();

    public QuoteImageGenerator(@NonNull Quote quote) {
        this.quote = quote;
        this.bufferedImage = new BufferedImage(
                IMAGE_SIZE,
                IMAGE_SIZE,
                BufferedImage.TYPE_INT_ARGB
        );

        this.graphics = bufferedImage.createGraphics();
        this.graphics.setColor(quote.getBackground());
        this.graphics.fillRect(0, 0, IMAGE_SIZE, IMAGE_SIZE);
    }

    public void drawText(int x, int y) {

    }

    public void drawHead() {

    }

    public void drawStroke() {
        graphics.setColor(quote.getStrokeColor());
        graphics.drawRect(1, 1, bufferedImage.getWidth() - 3, bufferedImage.getHeight() - 3);
    }
}
