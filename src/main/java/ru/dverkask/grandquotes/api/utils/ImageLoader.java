package ru.dverkask.grandquotes.api.utils;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

@UtilityClass
public class ImageLoader {
    @SneakyThrows public static BufferedImage loadImage(String url) {
        BufferedImage image = ImageIO.read(new URL(url));

        BufferedImage copy = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D    g2d  = copy.createGraphics();
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();

        return copy;
    }
}
