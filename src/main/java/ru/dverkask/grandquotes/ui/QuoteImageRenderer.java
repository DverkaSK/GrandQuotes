package ru.dverkask.grandquotes.ui;

import lombok.NonNull;
import lombok.SneakyThrows;
import ru.dverkask.grandquotes.api.Quote;
import ru.dverkask.grandquotes.api.utils.ImageSpecifications;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
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
                new StrokeDrawer(quote)
        );

        this.graphics = image.createGraphics();
        this.graphics.setColor(quote.getBackground());
        this.graphics.fillRect(0, 0, IMAGE_SIZE, IMAGE_SIZE);
    }

    @SneakyThrows public void draw() {
        for (RenderOperation operation : operations) {
            operation.render(graphics);
        }
        this.graphics.dispose();

        ImageIO.write(image, "png", new File("test.png"));
    }
}
