package ru.dverkask.grandquotes.ui;

import lombok.NonNull;
import lombok.SneakyThrows;
import ru.dverkask.grandquotes.api.Quote;
import ru.dverkask.grandquotes.ui.text.TextDrawer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class QuoteImageRenderer {
    private static final int                   IMAGE_SIZE = 128;
    private final        List<RenderOperation> operations;
    private final        BufferedImage         image;
    private final        Graphics2D            graphics;
    private final        Quote                 quote;

    public QuoteImageRenderer(@NonNull Quote quote) {
        this.quote = quote;
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

    private void drawText() {
        int           maxWidth    = 10;
        String[]      words       = quote.getText().split(" ");
        StringBuilder currentLine = new StringBuilder(words[0]);

        graphics.setFont(quote.getFont().font());

        FontMetrics fm = graphics.getFontMetrics();

        List<String> lines = new ArrayList<>();
        for (int i = 1; i < words.length; i++) {
            if (fm.stringWidth(currentLine + words[i]) < maxWidth) {
                currentLine.append(" ").append(words[i]);
            } else {
                lines.add(currentLine.toString());
                currentLine = new StringBuilder(words[i]);
            }
        }

        if (!currentLine.toString().trim().isEmpty()) {
            lines.add(currentLine.toString());
        }

        int lineNumber = 0;
        for (String line : lines) {
            int x = (image.getWidth() - fm.stringWidth(line)) / 2;
            int y = (image.getHeight() / 2) - ((lines.size() - 1) * fm.getHeight() / 2) + (lineNumber * fm.getHeight());
            graphics.drawString(line, x, y);
            lineNumber++;
        }
    }

    @SneakyThrows public void draw() {
        for (RenderOperation operation : operations) {
            operation.render(graphics);
        }
        this.graphics.dispose();

        ImageIO.write(image, "png", new File("test.png"));
    }
}
