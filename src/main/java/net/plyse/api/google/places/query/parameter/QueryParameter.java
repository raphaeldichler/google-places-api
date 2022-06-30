package net.plyse.api.google.places.query.parameter;

public class QueryParameter implements Parameter {

    private final String query;

    public QueryParameter(String query) {
        this.query = query;
    }

    @Override
    public String toUrlValue() {
        return "query=" + query;
    }
}
