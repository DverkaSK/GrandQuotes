package ru.dverkask.grandquotes.api.utils;

import lombok.Getter;

@Getter
public enum ImageSpecifications {
    IMAGE_SIZE(128),
    ;

    private final int property;
    ImageSpecifications(int property) {
        this.property = property;
    }
}
