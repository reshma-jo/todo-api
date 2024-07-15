package com.demo.todo.exception;

public class ExcelGenerationException extends RuntimeException {
    private static final long serialVersionUID = 3870445146065495015L;

    public ExcelGenerationException(String message) {
        super(message);
    }

    public ExcelGenerationException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
