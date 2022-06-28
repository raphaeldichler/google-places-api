package net.plyse.api.google.places.connection;

import net.plyse.api.google.places.parameter.InputType;
import net.plyse.api.google.places.parameter.OutputType;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author Raphael Dichler on 28.06.2022.
 */
public class FindPlaceRequest extends ApiConnection implements Connection {

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
    public Response load() throws IOException {
        return executeSync(new Request.Builder()
                .url(url)
                .build());
    }

    public static class RequestBuilder extends PlaceSearchRequestBuilder {

        private static final String BASE_URL = "https://maps.googleapis.com/maps/api/place/findplacefromtext/";

        public RequestBuilder(String apiKey, OutputType outputType, InputType inputType, String query) {
            this(apiKey, outputType, inputType, query, new FindPlaceRequest());
        }

        public RequestBuilder(String apiKey, String query) {
            this(apiKey, OutputType.JSON, InputType.TEXT_QUERY, query);
        }

        public RequestBuilder(String apiKey, OutputType outputType, InputType inputType, String query,
                              FindPlaceRequest connection) {
            super(apiKey);
            super.connection = connection;
            super.baseUrl = BASE_URL + outputType + "?" + inputType.toUrlValue() + "&" + "input=" + query + "&";
        }

        private String changeQuery(String newQuery) {


            return "";
        }

    }

}
