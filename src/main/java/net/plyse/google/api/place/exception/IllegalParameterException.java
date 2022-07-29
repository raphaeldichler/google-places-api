package net.plyse.google.api.place.exception;

/**
 * Thrown to indicate a parameter is not valid for a certain request.
 *
 * @author Raphael Dichler on 17.07.2022.
 */
public class IllegalParameterException extends RuntimeException {

    public IllegalParameterException() {
    }

    public IllegalParameterException(String message) {
        super(message);
    }

}
