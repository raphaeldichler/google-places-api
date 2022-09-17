package net.plyse.google.api.place.model;

/**
 * @author Raphael Dichler on 17.09.2022.
 */
public enum FindPlaceRequestParameter implements Parameter {

    LANGUAGE("language="),
    INPUT("input="),
    FIELDS("fields="),
    LOCATIONBIAS("locationbias="),
    INPUT_TYPE("inputtype=");

    private final String key;
    FindPlaceRequestParameter(String key) {
        this.key = key;
    }

    @Override
    public String getValue() {
        return key;
    }
}
