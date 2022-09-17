package net.plyse.google.api.place.model;

import static net.plyse.google.api.place.util.Utility.FIND_PLACE_BASE_URL;

/**
 * @author Raphael Dichler on 17.09.2022.
 */
public class FindPlaceRequest extends Request {

    public FindPlaceRequest(String input, String inputType) {
        super(FIND_PLACE_BASE_URL + Utility.OUTPUT_FORMAT + "?key=" + Utility.API_KEY);
        parameters.put(FindPlaceRequestParameter.INPUT_TYPE, inputType);
        parameters.put(FindPlaceRequestParameter.INPUT, input);
    }

    public FindPlaceRequest(String input) {
        this(input, "textquery");
    }

    /**
     * Adds a parameter to the search query. If the same {@link FindPlaceRequestParameter} is added several times, then the last one is overwritten.
     * A parameter always consists of a key and a value. This method should be used for one of the following parameters:
     * <ul>
     *     <li>{@link FindPlaceRequestParameter#INPUT}</li>
     *     <li>{@link FindPlaceRequestParameter#INPUT_TYPE}</li>
     *     <li>{@link FindPlaceRequestParameter#FIELDS}</li>
     *     <li>{@link FindPlaceRequestParameter#LANGUAGE}</li>
     *     <li>{@link FindPlaceRequestParameter#LOCATIONBIAS}</li>
     * </ul>
     * @param parameter The key in the URL
     * @param value The value in the URL
     * @return Returns the own instance
     */
    public FindPlaceRequest addParameter(FindPlaceRequestParameter parameter, String value) {
        this.parameters.put(parameter, value);
        return this;
    }

    /**
     * Adds a parameter to the search query. If the same {@link FindPlaceRequestParameter} is added several times, then the last one is overwritten.
     * A parameter always consists of a key and a value. The value is determined by the getValue() method. Can be used for custom classes.
     *
     * @param parameter The key in the URL
     * @param value The value in the URL
     * @return Returns the own instance
     */
    public FindPlaceRequest addParameter(FindPlaceRequestParameter parameter, ParameterValue value) {
        return addParameter(parameter, value.getValue());
    }


}
