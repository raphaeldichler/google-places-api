package net.plyse.api.google.places.exchange;


/**
 * Interface to get the data via requests from the Api.
 *
 * @author Raphael Dichler on 28.06.2022.
 */
public interface DataExchangeStrategy {

    /**
     * Performs a GET-Request to the API.
     *
     * @param url The "Uniform Resource Locator" for the API request.
     * @return The answer of the GET-Request
     */
    void getRequest(URL url);

}
