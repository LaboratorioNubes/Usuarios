package isi.dan.laboratorios.danmsusuarios.exceptions;

import org.springframework.http.HttpStatus;

public class DataNotFoundException extends ApiException {
    public DataNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
