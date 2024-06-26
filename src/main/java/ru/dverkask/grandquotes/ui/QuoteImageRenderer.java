package ru.dverkask.grandquotes.ui;

import lombok.NonNull;
import lombok.SneakyThrows;
import ru.dverkask.grandquotes.Quote;
import ru.dverkask.grandquotes.utils.ImageSpecifications;
import ru.dverkask.grandquotes.ui.text.TextDrawer;
import ru.dverkask.grandquotes.ui.text.TextElement;
import ru.dverkask.grandquotes.ui.text.TextFormatter;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class QuoteImageRenderer {
    private static final int                   IMAGE_SIZE = ImageSpecifications.IMAGE_SIZE.getProperty();
    private final        List<RenderOperation> operations;
    private final        BufferedImage         image;
    private final        Graphics2D            graphics;

    public QuoteImageRenderer(@NonNull Quote quote) {
        this.image = new BufferedImage(
                IMAGE_SIZE,
                IMAGE_SIZE,
                BufferedImage.TYPE_INT_ARGB
        );



        this.operations = List.of(
                new StrokeDrawer(quote),
                new ImageDrawer(quote),
                new TextDrawer(
                        image,
                        new TextElement(quote.getText(), TextFormatter.CENTER, Quote.Decoration.DEFAULT),
                        new TextElement(quote.getTitle(), TextFormatter.TOP, Quote.Decoration.DEFAULT),
                        new TextElement(quote.getAttribution(), TextFormatter.BOTTOM, Quote.Decoration.DEFAULT)
                )
        );

        this.graphics = image.createGraphics();
        this.graphics.setColor(quote.getBackground());
        this.graphics.fillRect(0, 0, IMAGE_SIZE, IMAGE_SIZE);
    }

    @SneakyThrows public BufferedImage draw() {
        for (RenderOperation operation : operations) {
            operation.render(graphics);
        }

        this.graphics.dispose();

        return this.image;
    }
}