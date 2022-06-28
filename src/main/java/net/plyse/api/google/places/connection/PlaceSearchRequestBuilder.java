package net.plyse.api.google.places.connection;

import net.plyse.api.google.places.exception.InvalidRequestParameter;
import net.plyse.api.google.places.parameter.RequestField;
import net.plyse.api.google.places.parameter.RequestPair;

import java.util.Set;

import static net.plyse.api.google.places.parameter.Field.*;

/**
 * @author Raphael Dichler on 28.06.2022.
 */
public abstract class PlaceSearchRequestBuilder extends RequestBuilder {

    private static final Set<RequestField> INVALID_FIELDS =
            Set.of(ADDRESS_COMPONENT, ADDRESS, FORMATTED_PHONE_NUMBER, INTERNATIONAL_PHONE_NUMBER,
                    REVIEWS, TYPE, URL, UTC_OFFSET, VICINITY, WEBSITE);

    public PlaceSearchRequestBuilder(String apiKey) {
        super(apiKey);
    }

    @Override
    public RequestBuilder addField(RequestField parameter) {
        if (INVALID_FIELDS.contains(parameter)) {
            throw new InvalidRequestParameter("Place search does not support the field: " + parameter.toUrlValue());
        }

        super.fields.add(parameter);
        return this;
    }

    @Override
    public RequestBuilder addPair(RequestPair pair) {
        super.pairs.add(pair);
        return this;
    }

}
