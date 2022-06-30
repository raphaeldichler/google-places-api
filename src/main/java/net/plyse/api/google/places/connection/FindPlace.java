package net.plyse.api.google.places.connection;

import net.plyse.api.google.places.connection.RequestUrl.BaseUrl;
import net.plyse.api.google.places.query.format.OutputType;
import net.plyse.api.google.places.query.parameter.DataFieldParameter;
import net.plyse.api.google.places.query.parameter.Parameter;

import static net.plyse.api.google.places.connection.RequestUrl.BaseUrl.*;

public class FindPlace implements Connection, Url {

    private Url url;

    private FindPlace(Url url) {
        this.url = url;
    }

    @Override
    public void execute() {
        System.out.println(url);
    }

    @Override
    public String getUrl() {
        return url.getUrl();
    }

    @Override
    public boolean addParameter(Parameter parameter) {
        return url.addParameter(parameter);
    }

    @Override
    public boolean changeParameter(Parameter parameter) {
        return url.changeParameter(parameter);
    }

    public static class RequestBuilder extends PlaceSearchRequestBuilder<FindPlace, RequestBuilder> {

        private static final BaseUrl BASE_URL = FIND_PLACE;
        private final OutputType outputType;
        public RequestBuilder(OutputType outputType) {
            this.outputType = outputType;
        }
        @Override
        public FindPlace build() {
            parameters.add(new DataFieldParameter(dataFields));
            return new FindPlace(
                    new RequestUrl(BASE_URL, outputType, parameters)
            );
        }

    }


}
