package net.plyse.api.google.places.connection;

import net.plyse.api.google.places.query.field.DataField;
import net.plyse.api.google.places.query.parameter.Parameter;

import java.util.HashSet;
import java.util.Set;

public abstract class PlaceSearchRequestBuilder<T, K> {

    protected final Set<Parameter> parameters;
    protected final Set<DataField> dataFields;

    public PlaceSearchRequestBuilder() {
        this.parameters = new HashSet<>();
        this.dataFields = new HashSet<>();
    }

    public K addParameter(Parameter parameter) {
        this.parameters.add(parameter);
        return (K) this;
    }

    public K addDataField(DataField dataField) {
        this.dataFields.add(dataField);
        return (K) this;
    }

    public abstract T build();

}
