package net.plyse.google.api.place.exchange;


import java.io.IOException;

public interface DataExchange<T, K> {

    /**
     * Executes a HTTP Get request
     *
     * @param url The URL to which the request will be executed.
     * @return The answer of the request.
     */
    K getRequest(T url) throws IOException;


}
