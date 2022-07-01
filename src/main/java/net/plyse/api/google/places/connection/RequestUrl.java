package net.plyse.api.google.places.connection;

import net.plyse.api.google.places.query.parameter.ApiKeyParameter;
import net.plyse.api.google.places.query.format.OutputType;
import net.plyse.api.google.places.query.parameter.Parameter;

import java.util.Set;

public final class RequestUrl implements Url, ChangeableUrl {

    private static final char PARAMETER_SEPARATOR = '&';
    private final Set<Parameter> parameters;
    private String baseUrl;
    private String url;
    private boolean hasUrlChanged = true;

    public RequestUrl(BaseUrl baseUrl, OutputType outputType, Set<Parameter> parameters) {
        this.baseUrl = baseUrl + outputType.toString() + "?";
        this.parameters = parameters;
        this.parameters.add(new ApiKeyParameter());
        getUrl();
    }

    @Override
    public String getUrl() {
        if (!hasUrlChanged) {
            return this.url;
        }

        StringBuilder url = new StringBuilder(this.baseUrl);

        for (Parameter parameter : parameters) {
            url.append(parameter.toUrlValue());
            url.append(PARAMETER_SEPARATOR);
        }

        url.delete(url.length() - 1, url.length());
        this.url = url.toString();

        return this.url;
    }

    /**
     * Adds a new parameter to the current url.
     *
     * @param parameter The new parameter to be added to the url
     * @return Returns true if the parameter is new and thus has been added.
     * Returns false if the parameter is already part of the url.
     */
    @Override
    public boolean addParameter(Parameter parameter) {
        if (parameters.contains(parameter)) {
            return false;
        }
        hasUrlChanged = this.parameters.add(parameter);
        return hasUrlChanged;
    }

    /**
     * Changes the value of an existing parameter.
     *
     * @param parameter The parameter to be changed in the url
     * @return Returns true if the parameter was changed. Returns false if the url does not have the passed parameter.
     */
    @Override
    public boolean changeParameter(Parameter parameter) {
        if (!parameters.contains(parameter)) {
            return false;
        }
        hasUrlChanged = this.parameters.add(parameter);
        return hasUrlChanged;
    }

    @Override
    public String toString() {
        return getUrl();
    }


    public enum BaseUrl {

        FIND_PLACE("https://maps.googleapis.com/maps/api/place/findplacefromtext/"),
        TEXT_SEARCH("https://maps.googleapis.com/maps/api/place/textsearch/"),
        NEARBY_SEARCH("https://maps.googleapis.com/maps/api/place/nearbysearch/");

        String url;

        BaseUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return url;
        }

    }

}