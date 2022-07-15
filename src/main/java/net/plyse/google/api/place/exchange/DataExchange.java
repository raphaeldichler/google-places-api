package net.plyse.google.api.place.exchange;

import java.net.URL;

public interface DataExchange {

    /**
     * Executes a HTTP Get request
     *
     * @param url The URL to which the request will be executed.
     * @return The answer of the request.
     */
    String getRequest(URL url);


}
