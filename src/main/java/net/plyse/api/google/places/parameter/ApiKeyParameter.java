package net.plyse.api.google.places.parameter;

import net.plyse.api.google.places.util.Properties;

public class ApiKeyParameter implements Parameter {

    @Override
    public String toUrlValue() {
        return "key=" + Properties.API_KEY;
    }

}
