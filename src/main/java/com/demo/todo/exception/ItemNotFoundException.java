package com.demo.todo.exception;

public class ItemNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 4898374304560643759L;

    public ItemNotFoundException(String message) {
        super(message);
    }

    public ItemNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
