package net.plyse.api.google.places.query.parameter;

import net.plyse.api.google.places.query.field.DataField;

import java.util.Objects;
import java.util.Set;
/**
 * @author Raphael Dichler on 30.06.2022.
 */
public class DataFieldParameter implements Parameter {

    private static final String DATA_FIELD_SEPARATOR = "%2C";

    private String parameterKey;
    private Set<DataField> dataFields;

    public DataFieldParameter(Set<DataField> dataFields) {
        this.dataFields = dataFields;
        setUpParameter();
    }

    public boolean addDataField(DataField dataField) {
        if (dataFields.contains(dataField)) {
            return false;
        }
        dataFields.add(dataField);
        setUpParameter();
        return true;
    }

    private void setUpParameter() {
        if (dataFields.isEmpty()) {
            parameterKey = "";
            return;
        }

        StringBuilder parameter = new StringBuilder();

        for (DataField dataField : dataFields) {
            parameter.append(dataField.toUrlValue());
            parameter.append(DATA_FIELD_SEPARATOR);
        }

        parameter.delete(parameter.length() - 3, parameter.length());

        parameterKey = parameter.toString();
    }

    @Override
    public String toUrlValue() {
        if (parameterKey.isEmpty()) {
            return "";
        }
        return "fields=" + parameterKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataFieldParameter that = (DataFieldParameter) o;
        return Objects.equals(parameterKey, that.parameterKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parameterKey);
    }

    public boolean changeDataField(DataField dataField) {
        if (dataFields.contains(dataField)) {
            return true;
        }
        return false;
    }
}
