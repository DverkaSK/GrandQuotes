package ru.dverkask.grandquotes.ui;

import lombok.RequiredArgsConstructor;
import ru.dverkask.grandquotes.api.Quote;
import ru.dverkask.grandquotes.api.utils.ImageSpecifications;

import java.awt.*;

@RequiredArgsConstructor
public class StrokeDrawer implements RenderOperation {
    private final Quote quote;
    private final int   IMAGE_SIZE = ImageSpecifications.IMAGE_SIZE.getProperty();

    @Override public void render(Graphics2D graphics) {
        graphics.setColor(quote.getStrokeColor());
        graphics.drawRect(1, 1, IMAGE_SIZE - 3, IMAGE_SIZE - 3);
    }
}
