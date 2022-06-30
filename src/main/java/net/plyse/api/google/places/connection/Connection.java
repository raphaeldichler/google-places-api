package net.plyse.api.google.places.connection;

import okhttp3.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

/**
 * @author Raphael Dichler on 28.06.2022.
 */
public interface Connection {

    String getUrl();

    JSONObject load() throws IOException, ParseException;

    void changeQuery(String query);

}
