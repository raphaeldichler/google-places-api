package net.plyse.api.google.places.connection;

import net.plyse.api.google.places.query.parameter.Parameter;

public interface Url {

    String getUrl();
    boolean addParameter(Parameter parameter);
    boolean changeParameter(Parameter parameter);

}
