package net.plyse.api.google.places.connection;

import net.plyse.api.google.places.exception.NoPageTokenExistsException;
import net.plyse.api.google.places.parameter.OutputType;
import net.plyse.api.google.places.parameter.Type;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

/**
 * @author Raphael Dichler on 28.06.2022.
 */
public class TextSearchRequest extends ApiConnection implements Connection {

    private String url;
    private String query;

    private String previouslyPageToken;
    private final String pageTokenUrl;
    private boolean existsPreviousPageToken = false;

    private TextSearchRequest(String pageTokenUrl) {
        this.pageTokenUrl = pageTokenUrl;
    }

    public static void main(String[] args) throws IOException, ParseException {

        TextSearchRequest build = (TextSearchRequest) new UrlBuilder("AIzaSyApMlTlhgM7GkOPcmCNNSmjJ5qCLQMR1uU", "pizzaria")
                .addPair(Type.RESTAURANT)
                .build();


        System.out.println(build.load());
        System.out.println(build.loadNextPage());

    }


    @Override
    public String getUrl() {
        return String.format(url, query);
    }

    @Override
    public JSONObject load() throws IOException, ParseException {
        return load(getUrl());
    }

    private JSONObject load(String url) throws IOException, ParseException {
        Response response = executeSync(new Request.Builder()
                .url(url)
                .build());

        String json = response.body().string();
        loadPageToken(json);

        return (JSONObject) new JSONParser().parse(json);
    }

    public JSONObject loadNextPage() throws IOException, ParseException {
        if (existsPreviousPageToken) {
            String url = String.format(pageTokenUrl, previouslyPageToken);

            return load(url);
        }
        throw new NoPageTokenExistsException("No page token was found.");
    }

    private void loadPageToken(String json) {
        Object ob = null;
        try {
            ob = new JSONParser().parse(json);
            existsPreviousPageToken = true;
        } catch (ParseException ignored) {
            existsPreviousPageToken = false;
            throw new NoPageTokenExistsException("Could not find a page token in recent respones.");
        }
        previouslyPageToken = (String) ((JSONObject) ob).get("next_page_token");
    }

    @Override
    public void changeQuery(String query) {
        this.query = query;
    }


    public static class UrlBuilder extends PlaceSearchRequestBuilder {

        private static final String BASE_URL = "https://maps.googleapis.com/maps/api/place/textsearch/";

        public UrlBuilder(String apiKey, String query) {
            this(apiKey, OutputType.JSON, query);
        }

        public UrlBuilder(String apiKey, OutputType outputType, String query) {
            super(apiKey);
            super.connection = new TextSearchRequest(BASE_URL + outputType + "?key=" + apiKey + "&pagetoken=%s");

            ((TextSearchRequest) connection).query = query;
            super.baseUrl = BASE_URL + outputType + "?" + "query=%s&";
        }


        @Override
        protected void setUrl(String url) {
            ((TextSearchRequest) connection).url = url;
        }
    }
}
