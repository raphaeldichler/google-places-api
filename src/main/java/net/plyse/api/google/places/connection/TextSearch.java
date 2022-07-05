package net.plyse.api.google.places.connection;

import net.plyse.api.google.places.query.field.DataField;
import net.plyse.api.google.places.query.format.OutputType;
import net.plyse.api.google.places.query.parameter.*;

//TODO: redesign search forms
public class TextSearch implements Connection, ChangeableUrl, QueryConnection {

    private QueryParameter queryParameter;
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
    public boolean addDataField(DataField dataField) {
        return url.addDataField(dataField);
    }

    @Override
    public boolean changeDataField(DataField dataField) {
        return url.changeDataField(dataField);
    }

    @Override
    public void execute() {
        System.out.println(url);
    }

    @Override
    public void execute(String query) {
        queryParameter.setQuery(query);
        ((RequestUrl) url).setHasUrlChanged();
        execute();
    }

    public static class RequestBuilder extends PlaceSearchRequestBuilder<TextSearch, RequestBuilder> {

        private static final RequestUrl.BaseUrl BASE_URL = RequestUrl.BaseUrl.TEXT_SEARCH;

        private QueryParameter queryParameter;

        public RequestBuilder(OutputType outputType, QueryParameter query) {
            super(outputType);
            queryParameter = query;
            addParameter(query);
        }
        public RequestBuilder(String query) {
            this(OutputType.JSON, new QueryParameter(query));
        }

        @Override
        public TextSearch build() {
            TextSearch textSearch = new TextSearch(
                    new RequestUrl(BASE_URL, outputType, parameters, dataFields)
            );

            textSearch.queryParameter = this.queryParameter;

            return textSearch;
        }
    }

}
