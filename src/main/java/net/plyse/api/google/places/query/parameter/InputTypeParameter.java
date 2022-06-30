package net.plyse.api.google.places.query.parameter;

import net.plyse.api.google.places.query.parameter.Parameter;

/**
 * @author Raphael Dichler on 28.06.2022.
 */
public enum InputTypeParameter implements Parameter {

    PHONE_NUMBER("phonenumber"),
    TEXT_QUERY("textquery");

    private final String type;

    InputTypeParameter(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }

    public String toUrlValue() {
        return "inputtype=" + type;
    }
}
