package net.plyse.api.google.places.query.parameter;

import net.plyse.api.google.places.query.field.DataField;

import java.util.Set;
/**
 * @author Raphael Dichler on 30.06.2022.
 */
public class DataFieldParameter implements Parameter {

    private static final String DATA_FIELD_SEPARATOR = "%2C";

    private final String PARAMETER_KEY;

    public DataFieldParameter(Set<DataField> dataFields) {
        if (dataFields.isEmpty()) {
            PARAMETER_KEY = "";
            return;
        }

        StringBuilder parameter = new StringBuilder();

        for (DataField dataField : dataFields) {
            parameter.append(dataField.toUrlValue());
            parameter.append(DATA_FIELD_SEPARATOR);
        }

        parameter.delete(parameter.length() - 3, parameter.length());

        PARAMETER_KEY = parameter.toString();
    }

    @Override
    public String toUrlValue() {
        if (PARAMETER_KEY.isEmpty()) {
            return "";
        }
        return "fields=" + PARAMETER_KEY;
    }

}
