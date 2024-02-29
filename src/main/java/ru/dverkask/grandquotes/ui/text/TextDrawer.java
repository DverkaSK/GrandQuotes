package ru.dverkask.grandquotes.ui.text;

import lombok.RequiredArgsConstructor;
import ru.dverkask.grandquotes.api.Quote;
import ru.dverkask.grandquotes.ui.RenderOperation;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class TextDrawer implements RenderOperation {
    private final Quote         quote;
    private final BufferedImage image;
    private final TextFormatter formatter;

    @Override public void render(Graphics2D graphics) {
        List<String> lines = getLines(quote.getText(), graphics, 10);

        for (int i = 0; i < lines.size(); i++) {
            String line  = lines.get(i);
            Point  point = formatter.position(image, graphics, line, lines.size(), i);
            graphics.drawString(line, point.x, point.y);
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
