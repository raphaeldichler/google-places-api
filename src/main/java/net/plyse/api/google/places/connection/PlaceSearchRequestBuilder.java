package net.plyse.api.google.places.connection;

import net.plyse.api.google.places.exception.InvalidRequestParameter;
import net.plyse.api.google.places.query.field.AtmosphereData;
import net.plyse.api.google.places.query.field.BasicData;
import net.plyse.api.google.places.query.field.ContactData;
import net.plyse.api.google.places.query.field.DataField;
import net.plyse.api.google.places.query.format.OutputType;
import net.plyse.api.google.places.query.parameter.Parameter;

import java.util.HashSet;
import java.util.Set;

public abstract class PlaceSearchRequestBuilder<T, K> {

    private static final Set<DataField> ILLEGAL_DATA_FIELDS = Set.of(
            BasicData.ADDRESS_COMPONENT, BasicData.ADDRESS, BasicData.TYPE, BasicData.URL, BasicData.UTC_OFFSET,
            BasicData.VICINITY, ContactData.WEBSITE, ContactData.FORMATTED_PHONE_NUMBER,
            ContactData.INTERNATIONAL_PHONE_NUMBER, AtmosphereData.REVIEWS
    );

    protected final Set<Parameter> parameters;
    protected final Set<DataField> dataFields;
    protected final OutputType outputType;

    public PlaceSearchRequestBuilder(OutputType outputType) {
        this.parameters = new HashSet<>();
        this.dataFields = new HashSet<>();
        this.outputType = outputType;
    }

    public K addParameter(Parameter parameter) {
        this.parameters.add(parameter);
        return (K) this;
    }

    //TODO: fix unchecked cast

    public K addDataField(DataField dataField) {
        if (ILLEGAL_DATA_FIELDS.contains(dataField)) {
            throw new InvalidRequestParameter("PlaceSearch does not support the DataField " + dataField.toUrlValue());
        }

        this.dataFields.add(dataField);
        return (K) this;
    }

    public abstract T build();

}
