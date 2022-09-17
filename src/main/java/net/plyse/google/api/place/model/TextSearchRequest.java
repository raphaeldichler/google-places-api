package net.plyse.google.api.place.model;

import net.plyse.google.api.place.exception.MissingParameterException;
import net.plyse.google.api.place.search.TextSearch;

import java.util.HashMap;
import java.util.Map;

import static net.plyse.google.api.place.util.Utility.PARAMETER_SEPARATOR;
import static net.plyse.google.api.place.util.Utility.TEXT_SEARCH_BASE_URL;

/**
 * Represents the request for a TextSearch. With the help of this class a search request can be sent to {@link TextSearch}.
 * The following parameters can be sent to the Google Places API:
 * <br> <br>
 * Required parameters
 * <ul>
 *     <li>{@link RequestParameter#QUERY}</li>
 * </ul>
 * Optional  parameters
 * <ul>
 *     <li>{@link RequestParameter#LANGUAGE}</li>
 *     <li>{@link RequestParameter#LOCATION}</li>
 *     <li>{@link RequestParameter#MAX_PRICE}</li>
 *     <li>{@link RequestParameter#MIN_PRICE}</li>
 *     <li>{@link RequestParameter#OPEN_NOW}</li>
 *     <li>{@link RequestParameter#PAGE_TOKE}</li>
 *     <li>{@link RequestParameter#RADIUS}</li>
 *     <li>{@link RequestParameter#REGION}</li>
 *     <li>{@link RequestParameter#TYPE}</li>
 * </ul>
 * More details are available at the official website of
 * <a href="https://developers.google.com/maps/documentation/places/web-service/search-text">Google-Places</a>
 * @author Raphael Dichler on 16.09.2022.
 */
public class TextSearchRequest implements Request {

    private final String BASE_URL;
    private final Map<RequestParameter, String> parameters = new HashMap<>();

    /**
     * Creates a basic framework, so that a valid Request and TextSearch can be made.
     * @param query Based on this query, a request is made. For example, when searching for an Italian restaurant
     *              in New York. The query would then be "Italian Restaurant in New York".
     */
    public TextSearchRequest(String query) {
        if (query == null || query.isEmpty()) {
            throw new MissingParameterException("A query is always needed for a text search.");
        }
        this.BASE_URL = TEXT_SEARCH_BASE_URL
                + Utility.OUTPUT_FORMAT + "?key=" + Utility.API_KEY;
        parameters.put(RequestParameter.QUERY, query);
    }

    /**
     * Creates a URL based on the passed parameters (from addParameter).
     * @return Die URL mit welcher einen Request an die TextSearch API stellen kann.
     */
    @Override
    public String getUrl() {
        StringBuilder stringBuilder = new StringBuilder(this.BASE_URL).append(PARAMETER_SEPARATOR);

        for (Map.Entry<RequestParameter, String> para : parameters.entrySet()) {
            stringBuilder.append(para.getKey().toString())
                    .append(para.getValue()).append(PARAMETER_SEPARATOR);
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        return stringBuilder.toString();
    }

    /**
     * Adds a parameter to the search query. If the same TextSearchParameter is added several times, then the last one is overwritten.
     * A parameter always consists of a key and a value. This method should be used for one of the following parameters:
     * <ul>
     *     <li>{@link RequestParameter#QUERY}</li>
     *     <li>{@link RequestParameter#LANGUAGE}</li>
     *     <li>{@link RequestParameter#PAGE_TOKE}</li>
     *     <li>{@link RequestParameter#REGION}</li>
     *     <li>{@link RequestParameter#TYPE}</li>
     * </ul>
     * @param parameter The key in the URL
     * @param value The value in the URL
     * @return Returns the own instance
     */
    public TextSearchRequest addParameter(RequestParameter parameter, String value) {
        this.parameters.put(parameter, value);
        return this;
    }

    /**
     * Adds a parameter to the search query. If the same TextSearchParameter is added several times, then the last one is overwritten.
     * A parameter always consists of a key and a value. This method should be used for one of the following parameters:
     * <ul>
     *     <li>{@link RequestParameter#MAX_PRICE}</li>
     *     <li>{@link RequestParameter#MIN_PRICE}</li>
     *     <li>{@link RequestParameter#RADIUS}</li>
     * </ul>
     * @param parameter The key in the URL
     * @param value The value in the URL
     * @return Returns the own instance
     */
    public TextSearchRequest addParameter(RequestParameter parameter, int value) {
        return addParameter(parameter, Integer.toString(value));
    }

    /**
     * Adds a parameter to the search query. If the same TextSearchParameter is added several times, then the last one is overwritten.
     * A parameter always consists of a key and a value. This method should be used for one of the following parameters:
     * <ul>
     *     <li>{@link RequestParameter#OPEN_NOW}</li>
     * </ul>
     * @param parameter The key in the URL
     * @param value The value in the URL
     * @return Returns the own instance
     */
    public TextSearchRequest addParameter(RequestParameter parameter, boolean value) {
        return addParameter(parameter, Boolean.toString(value));
    }

    /**
     * Adds a parameter to the search query. If the same TextSearchParameter is added several times, then the last one is overwritten.
     * A parameter always consists of a key and a value. This method should be used for one of the following parameters:
     * <ul>
     *     <li>{@link RequestParameter#LOCATION}</li>
     * </ul>
     * @param parameter The key in the URL
     * @param value The value in the URL
     * @return Returns the own instance
     */
    public TextSearchRequest addParameter(RequestParameter parameter, LatLngLiteral value) {
        return addParameter(parameter, value.getValue());
    }

    /**
     * Adds a parameter to the search query. If the same TextSearchParameter is added several times, then the last one is overwritten.
     * A parameter always consists of a key and a value. This method can be used when you want to specify a location
     * but do not have a LatLngLiteral instance. This method should be used for one of the following parameters:
     * <ul>
     *     <li>{@link RequestParameter#LOCATION}</li>
     * </ul>
     * @param parameter The key in the URL
     * @param lat The lat location
     * @param lan The lan location
     * @return Returns the own instance
     */
    public TextSearchRequest addParameter(RequestParameter parameter, float lat, float lan) {
        return addParameter(parameter, String.format(Utility.LAT_LNG_STRING_FORMAT, lat, lan));
    }

    /**
     * Adds a parameter to the search query. If the same TextSearchParameter is added several times, then the last one is overwritten.
     * A parameter always consists of a key and a value. The value is determined by the getValue() method. Can be used for custom classes.
     *
     * @param parameter The key in the URL
     * @param value The value in the URL
     * @return Returns the own instance
     */
    public TextSearchRequest addParameter(RequestParameter parameter, Parameter value) {
        return addParameter(parameter, value.getValue());
    }

}
