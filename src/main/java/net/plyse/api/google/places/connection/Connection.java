package net.plyse.api.google.places.connection;

import okhttp3.Response;

import java.io.IOException;

/**
 * @author Raphael Dichler on 28.06.2022.
 */
public interface Connection {

    void setUrl(String url);

    String getUrl();

    Response load() throws IOException;

}
