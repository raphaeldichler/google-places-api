package net.plyse.google.api.place.model;

/**
 * @author Raphael Dichler on 16.09.2022.
 */
public enum TextSearchParameter {

    /**
     *
     */
    QUERY("query="),
    LANGUAGE("language="),
    LOCATION("location="),
    MAX_PRICE("maxprice="),
    MIN_PRICE("minprice="),
    OPEN_NOW("opennow="),
    PAGE_TOKE("pagetoken="),
    RADIUS("radius="),
    REGION("region="),
    TYPE("type=");

    private final String key;
    TextSearchParameter(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return this.key;
    }
}
