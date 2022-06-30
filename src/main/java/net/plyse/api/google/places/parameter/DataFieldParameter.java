package net.plyse.api.google.places.parameter;

import java.util.Set;

public class DataFieldParameter implements Parameter {

    private static final String DATA_FIELD_SEPARATOR = "%2C";

    private final String PARAMETER_KEY;

    public DataFieldParameter(Set<RequestField> dataFields) {
        StringBuilder parameter = new StringBuilder();

        for (RequestField dataField : dataFields) {
            parameter.append(dataField.toUrlValue());
            parameter.append(DATA_FIELD_SEPARATOR);
        }

        parameter.delete(parameter.length() - 3, parameter.length());

        PARAMETER_KEY = parameter.toString();
    }

    @Override
    public String toUrlValue() {
        return "fields=" + PARAMETER_KEY;
    }

}
