package net.plyse.api.google.places.query.field;

import java.util.HashSet;
import java.util.ServiceLoader;
import java.util.Set;

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

    public static void main(String[] args) {

        ServiceLoader<DataField> loader = ServiceLoader.load(DataField.class);
        for (DataField implClass : loader) {
            System.out.println(implClass.getClass().getSimpleName());
        }

    }


}
