package net.plyse.api.google.places.connection;

import net.plyse.api.google.places.query.format.OutputType;
import net.plyse.api.google.places.query.parameter.*;

public class TextSearch implements Connection, ChangeableUrl{

    private final Url url;

    private TextSearch(Url url) {
        this.url = url;
    }

    @Override
    public boolean addParameter(Parameter parameter) {
        return url.addParameter(parameter);
    }

    @Override
    public boolean changeParameter(Parameter parameter) {
        return url.changeParameter(parameter);
    }

    @Override
    public void execute() {
        System.out.println(url);
    }


    public static class RequestBuilder extends PlaceSearchRequestBuilder<TextSearch, RequestBuilder> {

        private static final RequestUrl.BaseUrl BASE_URL = RequestUrl.BaseUrl.TEXT_SEARCH;

        public RequestBuilder(OutputType outputType, QueryParameter query) {
            super(outputType);
            addParameter(query);
        }
        public RequestBuilder(String query) {
            this(OutputType.JSON, new QueryParameter(query));
        }

        @Override
        public TextSearch build() {
            if (!dataFields.isEmpty()) {
                addParameter(new DataFieldParameter(dataFields));
            }
            return new TextSearch(
                    new RequestUrl(BASE_URL, outputType, parameters)
            );
        }
    }

}
