package net.plyse.api.google.places.connection;

import net.plyse.api.google.places.parameter.*;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

/**
 * @author Raphael Dichler on 28.06.2022.
 */
public class FindPlaceRequest extends ApiConnection implements Connection {

    private String url;
    private String query;

    @Override
    public String getUrl() {
        return String.format(url, query);
    }

    @Override
    public JSONObject load() throws IOException, ParseException {
        ResponseBody body = executeSync(new Request.Builder()
                .url(getUrl())
                .build()).body();

        return (JSONObject) new JSONParser().parse(body.string());
    }

    @Override
    public void changeQuery(String query) {
        this.query = query;
    }

    public static class UrlBuilder extends PlaceSearchRequestBuilder {

        private static final String BASE_URL = "https://maps.googleapis.com/maps/api/place/findplacefromtext/";

        public UrlBuilder(String apiKey, OutputType outputType, InputType inputType, String query) {
            this(apiKey, outputType, inputType, query, new FindPlaceRequest());
        }

        public UrlBuilder(String apiKey, String query) {
            this(apiKey, OutputType.JSON, InputType.TEXT_QUERY, query);
        }

        public UrlBuilder(String apiKey, OutputType outputType, InputType inputType, String query,
                          FindPlaceRequest connection) {
            super(apiKey);
            super.connection = connection;
            connection.query = query;
            super.baseUrl = BASE_URL + outputType + "?" + inputType.toUrlValue() + "&" + "input=%s&";
        }

        @Override
        protected void setUrl(String url) {
            ((FindPlaceRequest) connection).url = url;
        }

    }

}
