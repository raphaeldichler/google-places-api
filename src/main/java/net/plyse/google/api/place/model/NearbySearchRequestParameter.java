package net.plyse.google.api.place.model;

/**
 * @author Raphael Dichler on 17.09.2022.
 */
public enum NearbySearchRequestParameter implements Parameter {

    LOCATION("location="),
    KEYWORD("keyword="),
    LANGUAGE("language="),
    MAX_PRICE("maxprice="),
    MIN_PRICE("minprice="),
    OPEN_NOW("opennow="),
    PAGE_TOKE("pagetoken="),
    RADIUS("radius="),
    RANK_BY("rankby="),
    TYPE("type=");

    private final String key;
    NearbySearchRequestParameter(String key) {
        this.key = key;
    }

    @Override
    public String getValue() {
        return key;
    }

}
