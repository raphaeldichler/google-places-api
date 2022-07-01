package net.plyse.api.google.places.connection;

import net.plyse.api.google.places.query.field.DataField;
import net.plyse.api.google.places.query.parameter.Parameter;

public interface ChangeableUrl {

    boolean addParameter(Parameter parameter);
    boolean changeParameter(Parameter parameter);

    boolean addDataField(DataField dataField);
    boolean changeDataField(DataField dataField);

}
