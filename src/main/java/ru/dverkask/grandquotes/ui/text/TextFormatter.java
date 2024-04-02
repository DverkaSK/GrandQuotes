package ru.dverkask.grandquotes.ui.text;

import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.awt.image.BufferedImage;

public enum TextFormatter {
    TOP {
        @Override public Point position(@NotNull BufferedImage image,
                                        @NotNull Graphics2D graphics,
                                        @NotNull String line, int totalLines, int lineIndex) {
            int x = (image.getWidth() - graphics.getFontMetrics().stringWidth(line)) / 2;
            int y = graphics.getFontMetrics().getHeight() * (lineIndex + 1) + 3;
            return new Point(x, y);
        }
    },
    CENTER {
        @Override public Point position(@NotNull BufferedImage image,
                                        @NotNull Graphics2D graphics,
                                        @NotNull String line, int totalLines, int lineIndex) {
            int x = (image.getWidth() - graphics.getFontMetrics().stringWidth(line)) / 2;
            int y = (image.getHeight() / 2) - ((totalLines - 1) * graphics.getFontMetrics().getHeight() / 2)
                    + (lineIndex * graphics.getFontMetrics().getHeight());
            return new Point(x, y);
        }
    },
    BOTTOM {
        @Override public Point position(@NotNull BufferedImage image,
                                        @NotNull Graphics2D graphics,
                                        @NotNull String line, int totalLines, int lineIndex) {
            int x = (image.getWidth() - graphics.getFontMetrics().stringWidth(line)) / 2 + 20;
            int ascent = graphics.getFontMetrics().getAscent();
            int y = image.getHeight() - (ascent + (totalLines - lineIndex - 1)
                    * graphics.getFontMetrics().getHeight() + 3);
            return new Point(x, y);
        }
    };

    public abstract Point position(@NotNull BufferedImage image, @NotNull Graphics2D graphics, @NotNull String line, int totalLines, int lineIndex);
}
