package net.plyse.google.api.place.model;

import net.plyse.google.api.place.exception.MissingParameterException;
import net.plyse.google.api.place.search.TextSearch;

import static net.plyse.google.api.place.util.Utility.TEXT_SEARCH_BASE_URL;

/**
 * Represents the request for a TextSearch. With the help of this class a search request can be sent to {@link TextSearch}.
 * The following parameters can be sent to the Google Places API:
 * <br> <br>
 * Required parameters
 * <ul>
 *     <li>{@link TextSearchRequestParameter#QUERY}</li>
 * </ul>
 * Optional  parameters
 * <ul>
 *     <li>{@link TextSearchRequestParameter#LANGUAGE}</li>
 *     <li>{@link TextSearchRequestParameter#LOCATION}</li>
 *     <li>{@link TextSearchRequestParameter#MAX_PRICE}</li>
 *     <li>{@link TextSearchRequestParameter#MIN_PRICE}</li>
 *     <li>{@link TextSearchRequestParameter#OPEN_NOW}</li>
 *     <li>{@link TextSearchRequestParameter#PAGE_TOKE}</li>
 *     <li>{@link TextSearchRequestParameter#RADIUS}</li>
 *     <li>{@link TextSearchRequestParameter#REGION}</li>
 *     <li>{@link TextSearchRequestParameter#TYPE}</li>
 * </ul>
 * More details are available at the official website of
 * <a href="https://developers.google.com/maps/documentation/places/web-service/search-text">Google-Places</a>
 * @author Raphael Dichler on 16.09.2022.
 */
public class TextSearchRequest extends Request {

    /**
     * Creates a basic framework, so that a valid Request for TextSearch can be made.
     * @param query Based on this query, a request is made. For example, when searching for an Italian restaurant
     *              in New York. The query would then be "Italian Restaurant in New York".
     */
    public TextSearchRequest(String query) {
        super(TEXT_SEARCH_BASE_URL + Utility.OUTPUT_FORMAT + "?key=" + Utility.API_KEY);
        if (query == null || query.isEmpty())
            throw new MissingParameterException("A query is always needed for a text search.");
        parameters.put(TextSearchRequestParameter.QUERY, query);
    }

    /**
     * Adds a parameter to the search query. If the same {@link TextSearchRequestParameter} is added several times, then the last one is overwritten.
     * A parameter always consists of a key and a value. This method should be used for one of the following parameters:
     * <ul>
     *     <li>{@link TextSearchRequestParameter#QUERY}</li>
     *     <li>{@link TextSearchRequestParameter#LANGUAGE}</li>
     *     <li>{@link TextSearchRequestParameter#PAGE_TOKE}</li>
     *     <li>{@link TextSearchRequestParameter#REGION}</li>
     *     <li>{@link TextSearchRequestParameter#TYPE}</li>
     * </ul>
     * @param parameter The key in the URL
     * @param value The value in the URL
     * @return Returns the own instance
     */
    public TextSearchRequest addParameter(TextSearchRequestParameter parameter, String value) {
        this.parameters.put(parameter, value);
        return this;
    }

    /**
     * Adds a parameter to the search query. If the same {@link TextSearchRequestParameter} is added several times, then the last one is overwritten.
     * A parameter always consists of a key and a value. This method should be used for one of the following parameters:
     * <ul>
     *     <li>{@link TextSearchRequestParameter#MAX_PRICE}</li>
     *     <li>{@link TextSearchRequestParameter#MIN_PRICE}</li>
     *     <li>{@link TextSearchRequestParameter#RADIUS}</li>
     * </ul>
     * @param parameter The key in the URL
     * @param value The value in the URL
     * @return Returns the own instance
     */
    public TextSearchRequest addParameter(TextSearchRequestParameter parameter, int value) {
        return addParameter(parameter, Integer.toString(value));
    }

    /**
     * Adds a parameter to the search query. If the same {@link TextSearchRequestParameter} is added several times, then the last one is overwritten.
     * A parameter always consists of a key and a value. This method should be used for one of the following parameters:
     * <ul>
     *     <li>{@link TextSearchRequestParameter#OPEN_NOW}</li>
     * </ul>
     * @param parameter The key in the URL
     * @param value The value in the URL
     * @return Returns the own instance
     */
    public TextSearchRequest addParameter(TextSearchRequestParameter parameter, boolean value) {
        return addParameter(parameter, Boolean.toString(value));
    }

    /**
     * Adds a parameter to the search query. If the same {@link TextSearchRequestParameter} is added several times, then the last one is overwritten.
     * A parameter always consists of a key and a value. This method should be used for one of the following parameters:
     * <ul>
     *     <li>{@link TextSearchRequestParameter#LOCATION}</li>
     * </ul>
     * @param parameter The key in the URL
     * @param value The value in the URL
     * @return Returns the own instance
     */
    public TextSearchRequest addParameter(TextSearchRequestParameter parameter, LatLngLiteral value) {
        return addParameter(parameter, value.getValue());
    }

    /**
     * Adds a parameter to the search query. If the same {@link TextSearchRequestParameter} is added several times, then the last one is overwritten.
     * A parameter always consists of a key and a value. This method can be used when you want to specify a location
     * but do not have a LatLngLiteral instance. This method should be used for one of the following parameters:
     * <ul>
     *     <li>{@link TextSearchRequestParameter#LOCATION}</li>
     * </ul>
     * @param parameter The key in the URL
     * @param lat The lat location
     * @param lan The lan location
     * @return Returns the own instance
     */
    public TextSearchRequest addParameter(TextSearchRequestParameter parameter, float lat, float lan) {
        return addParameter(parameter, String.format(Utility.LAT_LNG_STRING_FORMAT, lat, lan));
    }

    /**
     * Adds a parameter to the search query. If the same {@link TextSearchRequestParameter} is added several times, then the last one is overwritten.
     * A parameter always consists of a key and a value. The value is determined by the getValue() method. Can be used for custom classes.
     *
     * @param parameter The key in the URL
     * @param value The value in the URL
     * @return Returns the own instance
     */
    public TextSearchRequest addParameter(TextSearchRequestParameter parameter, ParameterValue value) {
        return addParameter(parameter, value.getValue());
    }

}
