package com.reader.data;

import lombok.Getter;

public enum Status {
    OPEN("Open"),
    IN_PROGRESS("In Progress"),
    CLOSED_COMPLETE("Closed - Complete"),
    CLOSED_REJECTED("Closed - Rejected");

    @Getter
    private final String value;

    Status(String open) {
        this.value = open;
    }

    @Override
    public String toString() {
        return value;
    }
}
