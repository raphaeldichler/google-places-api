package net.plyse.api.google.places.connection;

import okhttp3.Response;

import java.io.IOException;

/**
 * @author Raphael Dichler on 28.06.2022.
 */
public interface Connection {

    String getUrl();

    Response load() throws IOException;

    void changeQuery(String query);

}
