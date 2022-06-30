package net.plyse.api.google.places.connection;

import net.plyse.api.google.places.connection.RequestUrl.BaseUrl;
import net.plyse.api.google.places.query.parameter.InputParameter;
import net.plyse.api.google.places.query.parameter.InputTypeParameter;
import net.plyse.api.google.places.query.format.OutputType;
import net.plyse.api.google.places.query.parameter.DataFieldParameter;
import net.plyse.api.google.places.query.parameter.Parameter;

import java.util.Set;

import static net.plyse.api.google.places.connection.RequestUrl.BaseUrl.*;

/**
 * @author Raphael Dichler on 30.06.2022.
 */
public class FindPlace implements Connection, ChangeableUrl {

    private final Url url;

    private FindPlace(Url url) {
        this.url = url;
    }

    @Override
    public void execute() {
        System.out.println(url);
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
        public RequestBuilder(OutputType outputType, InputTypeParameter inputType, InputParameter query) {
            super(outputType);
            addParameter(inputType);
            addParameter(query);
        }

        public RequestBuilder(OutputType outputType, String query) {
            this(outputType, InputTypeParameter.TEXT_QUERY, new InputParameter(query));
        }

        public RequestBuilder(InputTypeParameter inputTypeParameter, String query) {
            this(OutputType.JSON, inputTypeParameter, new InputParameter(query));
        }

        public RequestBuilder(String query) {
            this(OutputType.JSON, InputTypeParameter.TEXT_QUERY, new InputParameter(query));
        }

        @Override
        public FindPlace build() {
            if (!dataFields.isEmpty()) {
                addParameter(new DataFieldParameter(dataFields));
            }
            return new FindPlace(
                    new RequestUrl(BASE_URL, outputType, parameters)
            );
        }

    }


}
