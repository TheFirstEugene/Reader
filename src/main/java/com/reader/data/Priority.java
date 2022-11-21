package com.reader.data;

import lombok.Getter;

public enum Priority {
    HIGH("High"),
    MEDIUM("Medium"),
    LOW("Low"),
    MAJOR("Major");

    @Getter
    private final String value;

    Priority(String open) {
        this.value = open;
    }

    @Override
    public String toString() {
        return value;
    }
}
