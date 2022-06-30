package net.plyse.api.google.places.connection;

import net.plyse.api.google.places.query.parameter.Parameter;

public interface ChangeableUrl {

    boolean addParameter(Parameter parameter);
    boolean changeParameter(Parameter parameter);

}
