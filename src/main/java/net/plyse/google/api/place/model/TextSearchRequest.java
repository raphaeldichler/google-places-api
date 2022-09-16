package net.plyse.google.api.place.model;

import net.plyse.google.api.place.exception.MissingParameterException;
import net.plyse.google.api.place.search.TextSearch;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents the request for a TextSearch. With the help of this class a search request can be sent to {@link TextSearch}.
 * The following parameters can be sent to the Google Places API:
 * <br> <br>
 * Required parameters
 * <ul>
 *     <li>{@link TextSearchParameter#QUERY}</li>
 * </ul>
 * Optional  parameters
 * <ul>
 *     <li>{@link TextSearchParameter#LANGUAGE}</li>
 *     <li>{@link TextSearchParameter#LOCATION}</li>
 *     <li>{@link TextSearchParameter#MAX_PRICE}</li>
 *     <li>{@link TextSearchParameter#MIN_PRICE}</li>
 *     <li>{@link TextSearchParameter#OPEN_NOW}</li>
 *     <li>{@link TextSearchParameter#PAGE_TOKE}</li>
 *     <li>{@link TextSearchParameter#RADIUS}</li>
 *     <li>{@link TextSearchParameter#REGION}</li>
 *     <li>{@link TextSearchParameter#TYPE}</li>
 * </ul>
 * More details are available at the official website of
 * <a href="https://developers.google.com/maps/documentation/places/web-service/search-text">Google-Places</a>
 * @author Raphael Dichler on 16.09.2022.
 */
public class TextSearchRequest implements Request {

    private static final String BASE_URL = "https://maps.googleapis.com/maps/api/place/textsearch/" ;

    private final String TEXT_SEARCH_BASE_URL;
    private final Map<TextSearchParameter, String> parameters = new HashMap<>();

    /**
     * Creates a basic framework, so that a valid Request and TextSearch can be made.
     * @param query Based on this query, a request is made. For example, when searching for an Italian restaurant
     *              in New York. The query would then be "Italian Restaurant in New York".
     */
    public TextSearchRequest(String query) {
        if (query == null || query.isEmpty()) {
            throw new MissingParameterException("A query is always needed for a text search.");
        }
        this.TEXT_SEARCH_BASE_URL = BASE_URL + Utility.OUTPUT_FORMAT + "&key=" + Utility.API_KEY;
        parameters.put(TextSearchParameter.QUERY, query);
    }

    @Override
    public String getUrl() {
        StringBuilder stringBuilder = new StringBuilder(this.TEXT_SEARCH_BASE_URL);

        for (Map.Entry<TextSearchParameter, String> para : parameters.entrySet()) {
            stringBuilder.append(para.getKey().toString())
                    .append(para.getValue());
        }

        return stringBuilder.toString();
    }

    /**
     * Adds a parameter to the search query. If the same TextSearchParameter is added several times, then the last one is overwritten.
     * A parameter always consists of a key and a value. This method should be used for one of the following parameters:
     * <ul>
     *     <li>{@link TextSearchParameter#QUERY}</li>
     *     <li>{@link TextSearchParameter#LANGUAGE}</li>
     *     <li>{@link TextSearchParameter#PAGE_TOKE}</li>
     *     <li>{@link TextSearchParameter#REGION}</li>
     *     <li>{@link TextSearchParameter#TYPE}</li>
     * </ul>
     * @param parameter The key in the URL
     * @param value The value in the URL
     * @return Returns the own instance
     */
    public TextSearchRequest addParameter(TextSearchParameter parameter, String value) {
        this.parameters.put(parameter, value);
        return this;
    }

    /**
     * Adds a parameter to the search query. If the same TextSearchParameter is added several times, then the last one is overwritten.
     * A parameter always consists of a key and a value. This method should be used for one of the following parameters:
     * <ul>
     *     <li>{@link TextSearchParameter#MAX_PRICE}</li>
     *     <li>{@link TextSearchParameter#MIN_PRICE}</li>
     *     <li>{@link TextSearchParameter#RADIUS}</li>
     * </ul>
     * @param parameter The key in the URL
     * @param value The value in the URL
     * @return Returns the own instance
     */
    public TextSearchRequest addParameter(TextSearchParameter parameter, int value) {
        return addParameter(parameter, Integer.toString(value));
    }

    /**
     * Adds a parameter to the search query. If the same TextSearchParameter is added several times, then the last one is overwritten.
     * A parameter always consists of a key and a value. This method should be used for one of the following parameters:
     * <ul>
     *     <li>{@link TextSearchParameter#OPEN_NOW}</li>
     * </ul>
     * @param parameter The key in the URL
     * @param value The value in the URL
     * @return Returns the own instance
     */
    public TextSearchRequest addParameter(TextSearchParameter parameter, boolean value) {
        return addParameter(parameter, Boolean.toString(value));
    }

    /**
     * Adds a parameter to the search query. If the same TextSearchParameter is added several times, then the last one is overwritten.
     * A parameter always consists of a key and a value. This method should be used for one of the following parameters:
     * <ul>
     *     <li>{@link TextSearchParameter#LOCATION}</li>
     * </ul>
     * @param parameter The key in the URL
     * @param value The value in the URL
     * @return Returns the own instance
     */
    public TextSearchRequest addParameter(TextSearchParameter parameter, LatLngLiteral value) {
        return addParameter(parameter, value.getValue());
    }

    /**
     * Adds a parameter to the search query. If the same TextSearchParameter is added several times, then the last one is overwritten.
     * A parameter always consists of a key and a value. This method can be used when you want to specify a location
     * but do not have a LatLngLiteral instance. This method should be used for one of the following parameters:
     * <ul>
     *     <li>{@link TextSearchParameter#LOCATION}</li>
     * </ul>
     * @param parameter The key in the URL
     * @param lat The lat location
     * @param lan The lan location
     * @return Returns the own instance
     */
    public TextSearchRequest addParameter(TextSearchParameter parameter, float lat, float lan) {
        return addParameter(parameter, String.format(Utility.LAT_LNG_STRING_FORMAT, lat, lan));
    }

    /**
     * Adds a parameter to the search query. If the same TextSearchParameter is added several times, then the last one is overwritten.
     * A parameter always consists of a key and a value. The value value is determined by the toString() method. Can be used for custom classes.
     *
     * @param parameter The key in the URL
     * @param value The value in the URL
     * @return Returns the own instance
     */
    public TextSearchRequest addParameter(TextSearchParameter parameter, Parameter value) {
        return addParameter(parameter, value.getValue());
    }

}
