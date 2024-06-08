package com.metodos.licencias.exceptions;

public class NoResultsException extends RuntimeException {
    public NoResultsException(String message) {
        super(message);
    }
}