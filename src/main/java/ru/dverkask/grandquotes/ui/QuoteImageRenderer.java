package ru.dverkask.grandquotes.ui;

import lombok.NonNull;
import lombok.SneakyThrows;
import ru.dverkask.grandquotes.api.Quote;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class QuoteImageRenderer {
    private static final int           IMAGE_SIZE = 128;
    private final        BufferedImage image;
    private final        Graphics2D    graphics;
    private final        Quote         quote;

    public QuoteImageRenderer(@NonNull Quote quote) {
        this.quote = quote;
        this.image = new BufferedImage(
                IMAGE_SIZE,
                IMAGE_SIZE,
                BufferedImage.TYPE_INT_ARGB
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

    @SneakyThrows private void drawHead(UUID uuid) {
        BufferedImage head = loadImage("https://cravatar.eu/avatar/" + uuid);
        BufferedImage resizedHead = resizeImage(head, 32, 32);

        drawImageWithBorder(resizedHead, 3, IMAGE_SIZE - resizedHead.getHeight() - 3);
    }

    @SneakyThrows private BufferedImage loadImage(String url) {
        BufferedImage image = ImageIO.read(new URL(url));

        BufferedImage copy = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = copy.createGraphics();
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();

        return copy;
    }

    private BufferedImage resizeImage(BufferedImage source, int width, int height) {
        AffineTransform at = new AffineTransform();
        at.scale((double) width / source.getWidth(), (double) height / source.getHeight());
        AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);

        return scaleOp.filter(
                source, new BufferedImage(width, height, source.getType())
        );
    }

    private void drawImageWithBorder(BufferedImage image, int x, int y) {
        this.graphics.drawImage(image, x, y, null);
        this.graphics.drawRect(x - 1, y - 3, image.getWidth() + 3, image.getHeight() + 3);
    }

    private void drawStroke() {
        this.graphics.setColor(quote.getStrokeColor());
        this.graphics.drawRect(1, 1, image.getWidth() - 3, image.getHeight() - 3);
    }

    @SneakyThrows public void draw() {
        drawStroke();
        drawText();
        drawHead(quote.getUuid());

        this.graphics.dispose();

        ImageIO.write(image, "png", new File("test.png"));
    }
}
