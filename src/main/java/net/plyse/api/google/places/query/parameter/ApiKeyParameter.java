package net.plyse.api.google.places.query.parameter;

import net.plyse.api.google.places.util.Properties;
/**
 * @author Raphael Dichler on 30.06.2022.
 */
public class ApiKeyParameter implements Parameter {

    @Override
    public String toUrlValue() {
        return "key=" + Properties.API_KEY;
    }

}
