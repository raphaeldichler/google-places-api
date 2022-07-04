package net.plyse.api.google.places.connection;

import net.plyse.api.google.places.query.field.DataField;
import net.plyse.api.google.places.query.format.OutputType;
import net.plyse.api.google.places.query.parameter.Location;
import net.plyse.api.google.places.query.parameter.Parameter;

public class NearbySearch implements Connection, ChangeableUrl {

    private Parameter requiredParameter;
    private final Url url;

    private NearbySearch(Url url) {
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

    }

    public static class RequestBuilder extends PlaceSearchRequestBuilder<NearbySearch, NearbySearch.RequestBuilder> {

        private static final RequestUrl.BaseUrl BASE_URL = RequestUrl.BaseUrl.NEARBY_SEARCH;

        private Location location;

        public RequestBuilder(OutputType outputType, Location location) {
            super(outputType);
            this.location = location;
            addParameter(location);
        }

        public RequestBuilder(Location location) {
            this(OutputType.JSON, location);
        }

        @Override
        public NearbySearch build() {
            NearbySearch nearbySearch = new NearbySearch(
                    new RequestUrl(BASE_URL, outputType, parameters, dataFields)
            );
            nearbySearch.requiredParameter = this.location;

            return nearbySearch;
        }

    }

}
