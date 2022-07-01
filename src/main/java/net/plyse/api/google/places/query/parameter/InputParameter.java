package net.plyse.api.google.places.query.parameter;


/**
 * @author Raphael Dichler on 30.06.2022.
 */
public class InputParameter implements Parameter {

    private String query;

    public InputParameter(String query) {
        this.query = query;
    }

    @Override
    public String toUrlValue() {
        return "input=" + query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

}
