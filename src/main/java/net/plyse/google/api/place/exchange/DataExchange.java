package net.plyse.google.api.place.exchange;


import java.io.IOException;

public interface DataExchange {

    /**
     * Executes a HTTP Get request
     *
     * @param url The URL to which the request will be executed.
     * @return The answer of the request.
     */
    String executeGetRequest(String url) throws IOException;


}
