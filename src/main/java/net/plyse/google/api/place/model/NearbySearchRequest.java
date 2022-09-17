package net.plyse.google.api.place.model;

import net.plyse.google.api.place.exception.MissingParameterException;
import net.plyse.google.api.place.search.TextSearch;

import static net.plyse.google.api.place.util.Utility.NEARBY_SEARCH_BASE_URL;

/**
 * Represents the request for a TextSearch. With the help of this class a search request can be sent to {@link TextSearch}.
 * The following parameters can be sent to the Google Places API:
 * <br> <br>
 * Required parameters
 * <ul>
 *     <li>{@link NearbySearchRequestParameter#LOCATION}</li>
 * </ul>
 * Optional  parameters
 * <ul>
 *     <li>{@link NearbySearchRequestParameter#KEYWORD}</li>
 *     <li>{@link NearbySearchRequestParameter#LANGUAGE}</li>
 *     <li>{@link NearbySearchRequestParameter#MAX_PRICE}</li>
 *     <li>{@link NearbySearchRequestParameter#MIN_PRICE}</li>
 *     <li>{@link NearbySearchRequestParameter#OPEN_NOW}</li>
 *     <li>{@link NearbySearchRequestParameter#PAGE_TOKE}</li>
 *     <li>{@link NearbySearchRequestParameter#RADIUS}</li>
 *     <li>{@link NearbySearchRequestParameter#RANK_BY}</li>
 *     <li>{@link NearbySearchRequestParameter#TYPE}</li>
 * </ul>
 * More details are available at the official website of
 * <a href="https://developers.google.com/maps/documentation/places/web-service/search-text">Google-Places</a>
 * @author Raphael Dichler on 17.09.2022.
 */
public class NearbySearchRequest extends Request {

    /**
     * Creates a basic framework, so that a valid Request for NearbySearch can be made.
     * @param location Based on this location, a request is made. For example, when passing your current location
     *                 (e.g. New York lat and lan), then the results would be all in New York
     */
    public NearbySearchRequest(LatLngLiteral location) {
        super(NEARBY_SEARCH_BASE_URL + Utility.OUTPUT_FORMAT + "?key=" + Utility.API_KEY);
        if (location == null)
            throw new MissingParameterException("A location is always needed for a nearby search.");

        parameters.put(TextSearchRequestParameter.LOCATION, location.getValue());
    }

    public NearbySearchRequest(float lat, float lan) {
        this(new LatLngLiteral(lat, lan));
    }

    /**
     * Adds a parameter to the search query. If the same {@link NearbySearchRequestParameter} is added several times, then the last one is overwritten.
     * A parameter always consists of a key and a value. This method should be used for one of the following parameters:
     * <ul>
     *     <li>{@link NearbySearchRequestParameter#KEYWORD}</li>
     *     <li>{@link NearbySearchRequestParameter#LANGUAGE}</li>
     *     <li>{@link NearbySearchRequestParameter#PAGE_TOKE}</li>
     *     <li>{@link NearbySearchRequestParameter#RANK_BY}</li>
     *     <li>{@link NearbySearchRequestParameter#TYPE}</li>
     * </ul>
     * @param parameter The key in the URL
     * @param value The value in the URL
     * @return Returns the own instance
     */
    public NearbySearchRequest addParameter(NearbySearchRequestParameter parameter, String value) {
        this.parameters.put(parameter, value);
        return this;
    }

    /**
     * Adds a parameter to the search query. If the same {@link NearbySearchRequestParameter} is added several times, then the last one is overwritten.
     * A parameter always consists of a key and a value. This method should be used for one of the following parameters:
     * <ul>
     *     <li>{@link NearbySearchRequestParameter#MAX_PRICE}</li>
     *     <li>{@link NearbySearchRequestParameter#MIN_PRICE}</li>
     *     <li>{@link NearbySearchRequestParameter#RADIUS}</li>
     * </ul>
     * @param parameter The key in the URL
     * @param value The value in the URL
     * @return Returns the own instance
     */
    public NearbySearchRequest addParameter(NearbySearchRequestParameter parameter, int value) {
        return addParameter(parameter, Integer.toString(value));
    }

    /**
     * Adds a parameter to the search query. If the same {@link NearbySearchRequestParameter} is added several times, then the last one is overwritten.
     * A parameter always consists of a key and a value. This method should be used for one of the following parameters:
     * <ul>
     *     <li>{@link NearbySearchRequestParameter#LOCATION}</li>
     * </ul>
     * @param parameter The key in the URL
     * @param value The value in the URL
     * @return Returns the own instance
     */
    public NearbySearchRequest addParameter(NearbySearchRequestParameter parameter, LatLngLiteral value) {
        return addParameter(parameter, value.getValue());
    }

    /**
     * Adds a parameter to the search query. If the same {@link NearbySearchRequestParameter} is added several times, then the last one is overwritten.
     * A parameter always consists of a key and a value. This method can be used when you want to specify a location
     * but do not have a LatLngLiteral instance. This method should be used for one of the following parameters:
     * <ul>
     *     <li>{@link NearbySearchRequestParameter#LOCATION}</li>
     * </ul>
     * @param parameter The key in the URL
     * @param lat The lat location
     * @param lan The lan location
     * @return Returns the own instance
     */
    public NearbySearchRequest addParameter(NearbySearchRequestParameter parameter, float lat, float lan) {
        return addParameter(parameter, String.format(Utility.LAT_LNG_STRING_FORMAT, lat, lan));
    }

    /**
     * Adds a parameter to the search query. If the same {@link NearbySearchRequestParameter} is added several times, then the last one is overwritten.
     * A parameter always consists of a key and a value. The value is determined by the getValue() method. Can be used for custom classes.
     *
     * @param parameter The key in the URL
     * @param value The value in the URL
     * @return Returns the own instance
     */
    public NearbySearchRequest addParameter(NearbySearchRequestParameter parameter, ParameterValue value) {
        return addParameter(parameter, value.getValue());
    }


}
