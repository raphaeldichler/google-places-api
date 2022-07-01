package net.plyse.api.google.places.query.parameter;

public class QueryParameter implements Parameter {

    private String query;

    public QueryParameter(String query) {
        this.query = query;
    }

    @Override
    public String toUrlValue() {
        return "query=" + query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
