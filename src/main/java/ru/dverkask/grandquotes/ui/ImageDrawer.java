package ru.dverkask.grandquotes.ui;

import lombok.RequiredArgsConstructor;
import ru.dverkask.grandquotes.api.Quote;
import ru.dverkask.grandquotes.api.utils.ImageLoader;
import ru.dverkask.grandquotes.api.utils.ImageSpecifications;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

@RequiredArgsConstructor
public class ImageDrawer implements RenderOperation {
    private final Quote quote;
    private final int IMAGE_SIZE = ImageSpecifications.IMAGE_SIZE.getProperty();
    @Override public void render(Graphics2D graphics) {
        String displayName = quote.getPlayer().getName();

        BufferedImage head = ImageLoader.loadImage("https://cravatar.eu/avatar/" + displayName);
        BufferedImage resizedHead = resizeImage(head, 32, 32);

        int x = 3;
        int y = IMAGE_SIZE - resizedHead.getHeight() - 3;

        graphics.drawImage(resizedHead, x, y, null);
        graphics.drawRect(x - 2, IMAGE_SIZE - resizedHead.getHeight() - 5, resizedHead.getWidth() + 3, resizedHead.getHeight() + 3);
    }

    private BufferedImage resizeImage(BufferedImage source, int width, int height) {
        final AffineTransform at = new AffineTransform();
        at.scale((double) width / source.getWidth(), (double) height / source.getHeight());
        final AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);

        return scaleOp.filter(
                source, new BufferedImage(width, height, source.getType())
        );
    }
}
