package net.plyse.api.google.places.query.field;

public enum AtmosphereData implements DataField {

    PRICE_LEVEL("price_level"),
    RATING("rating"),
    REVIEWS("reviews"),
    USER_RATINGS_TOTAL("user_ratings_total");
    private final String type;

    AtmosphereData(String type) {
        this.type = type;
    }

    @Override
    public String toUrlValue() {
        return type;
    }

}
