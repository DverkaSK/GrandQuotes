package ru.dverkask.grandquotes.ui.text;

import ru.dverkask.grandquotes.ui.RenderOperation;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class TextDrawer implements RenderOperation {
    private final BufferedImage image;
    private final List<TextElement> textElements;
    public TextDrawer(BufferedImage image, TextElement... textElements) {
        this.image = image;
        this.textElements = List.of(textElements);
    }

    @Override public void render(Graphics2D graphics) {
        for (TextElement element : textElements) {
            graphics.setFont(element.decoration().font());
            graphics.setColor(element.decoration().getTextColor());

            List<String> lines = getLines(element.text(), graphics, 120);

            for (int i = 0; i < lines.size(); i++) {
                String line  = lines.get(i);
                Point  point = element.formatter().position(image, graphics, line, lines.size(), i);
                graphics.drawString(line, point.x, point.y);
            }
        }
    }

    private List<String> getLines(String text, Graphics2D graphics, int maxWidth) {
        String[] words = text.split(" ");

        FontMetrics fontMetrics = graphics.getFontMetrics();

        List<String>  lines       = new ArrayList<>();
        StringBuilder currentLine = new StringBuilder(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (fontMetrics.stringWidth(currentLine + " " + words[i]) < maxWidth) {
                currentLine.append(" ").append(words[i]);
            } else {
                lines.add(currentLine.toString());
                currentLine = new StringBuilder(words[i]);
            }
        }

        if (!currentLine.toString().isEmpty()) {
            lines.add(currentLine.toString());
        }

        return lines;
    }
}
