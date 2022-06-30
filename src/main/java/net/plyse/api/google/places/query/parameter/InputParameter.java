package net.plyse.api.google.places.query.parameter;


/**
 * @author Raphael Dichler on 30.06.2022.
 */
public class InputParameter implements Parameter {

    private final String query;

    public InputParameter(String query) {
        this.query = query;
    }

    @Override
    public String toUrlValue() {
        return "input=" + query;
    }

}
