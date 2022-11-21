package com.reader.exception;

import java.io.IOException;

public class NoValidValueException extends IOException {
    public NoValidValueException(String message) {
        super(message);
    }
}
