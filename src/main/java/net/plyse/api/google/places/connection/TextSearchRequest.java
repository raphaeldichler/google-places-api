package net.plyse.api.google.places.connection;

import net.plyse.api.google.places.parameter.Field;
import net.plyse.api.google.places.parameter.InputType;
import net.plyse.api.google.places.parameter.OutputType;
import net.plyse.api.google.places.parameter.Type;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author Raphael Dichler on 28.06.2022.
 */
public class TextSearchRequest extends ApiConnection implements Connection {

    private String url;
    private String query;

    @Override
    public String getUrl() {
        return String.format(url, query);
    }

    @Override
    public Response load() throws IOException {
        return executeSync(new Request.Builder()
                .url(getUrl())
                .build());
    }

    @Override
    public void changeQuery(String query) {
        this.query = query;
    }

    public static class RequestBuilder extends PlaceSearchRequestBuilder {

        private static final String BASE_URL = "https://maps.googleapis.com/maps/api/place/textsearch/";

        public RequestBuilder(String apiKey, OutputType outputType, InputType inputType, String query) {
            this(apiKey, outputType, query, new TextSearchRequest());
        }

        public RequestBuilder(String apiKey, String query) {
            this(apiKey, OutputType.JSON, query, new TextSearchRequest());
        }

        public RequestBuilder(String apiKey, OutputType outputType, String query, TextSearchRequest connection) {
            super(apiKey);
            super.connection = connection;
            connection.query = query;
            super.baseUrl = BASE_URL + outputType + "?" + "query=%s&";
        }


        @Override
        protected void setUrl(String url) {
            ((TextSearchRequest) connection).url = url;
        }
    }
}
