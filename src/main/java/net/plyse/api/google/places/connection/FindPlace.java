package net.plyse.api.google.places.connection;

import net.plyse.api.google.places.connection.RequestUrl.BaseUrl;
import net.plyse.api.google.places.query.field.BasicData;
import net.plyse.api.google.places.query.field.DataField;
import net.plyse.api.google.places.query.parameter.*;
import net.plyse.api.google.places.query.format.OutputType;

import static net.plyse.api.google.places.connection.RequestUrl.BaseUrl.*;

/**
 * @author Raphael Dichler on 30.06.2022.
 */
public class FindPlace implements Connection, ChangeableUrl, QueryConnection {

    private InputParameter queryParameter;


    public static void main(String[] args) {


        FindPlace findPlace = new FindPlace.RequestBuilder("resturant in meiner nähe")
                .addDataField(BasicData.NAME)
                .addDataField(BasicData.FORMATTED_ADDRESS)
                .build();

        findPlace.execute();
        findPlace.addParameter(TypeParameter.RESTAURANT);
        findPlace.execute("tirol resturant");

    }

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

    @Override
    public boolean addDataField(DataField dataField) {
        return false;
    }

    @Override
    public boolean changeDataField(DataField dataField) {
        return false;
    }

    @Override
    public void execute(String query) {
        queryParameter.setQuery(query);
        ((RequestUrl) url).setHasUrlChanged();
        execute();
    }

    public static class RequestBuilder extends PlaceSearchRequestBuilder<FindPlace, RequestBuilder> {

        private static final BaseUrl BASE_URL = FIND_PLACE;
        private InputParameter inputParameter;
        public RequestBuilder(OutputType outputType, InputTypeParameter inputType, InputParameter query) {
            super(outputType);
            this.inputParameter = query;
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
            FindPlace findPlace = new FindPlace(
                    new RequestUrl(BASE_URL, outputType, parameters, dataFields)
            );

            findPlace.queryParameter = this.inputParameter;

            return findPlace;
        }

    }


}
