package net.plyse.api.google.places.connection;

import net.plyse.api.google.places.parameter.Field;
import net.plyse.api.google.places.parameter.InputType;
import net.plyse.api.google.places.parameter.OutputType;
import net.plyse.api.google.places.parameter.Type;

/**
 * @author Raphael Dichler on 28.06.2022.
 */
public class TextSearchRequest implements Connection {

    private String url;

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public void load() {
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
            super.baseUrl = BASE_URL + outputType + "?" + "query=" + query + "&";
        }

    }
}
