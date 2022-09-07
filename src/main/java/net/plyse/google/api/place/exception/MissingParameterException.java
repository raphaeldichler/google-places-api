package net.plyse.google.api.place.exception;

public class MissingParameterException extends RuntimeException {

    public MissingParameterException() {
    }

    public MissingParameterException(String message) {
        super(message);
    }

}
