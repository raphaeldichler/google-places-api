package net.plyse.api.google.places.connection;

import net.plyse.api.google.places.query.field.DataField;
import net.plyse.api.google.places.query.parameter.ApiKeyParameter;
import net.plyse.api.google.places.query.format.OutputType;
import net.plyse.api.google.places.query.parameter.DataFieldParameter;
import net.plyse.api.google.places.query.parameter.Parameter;

import java.util.Set;

public final class RequestUrl implements Url, ChangeableUrl {

    private static final char PARAMETER_SEPARATOR = '&';

    /**
     * A list of all parameters in the url
     */
    private final Set<Parameter> parameters;

    /**
     * Part of the url that remains static
     */
    private final String baseUrl;

    /**
     * The url with which a request can be created.
     */
    private String url;

    private final DataFieldParameter dataFieldParameter;

    /**
     * Decides if the url needs to be recreated
     */
    private boolean hasUrlChanged = true;

    public RequestUrl(BaseUrl baseUrl, OutputType outputType, Set<Parameter> parameters, Set<DataField> dataFields) {
        this.baseUrl = baseUrl + outputType.toString() + "?";
        this.parameters = parameters;
        this.dataFieldParameter = new DataFieldParameter(dataFields);
        this.parameters.add(dataFieldParameter);
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

        hasUrlChanged = false;

        return this.url;
    }

    void setHasUrlChanged() {
        this.hasUrlChanged = true;
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

        hasUrlChanged |= this.parameters.add(parameter);
        return hasUrlChanged;
    }

    /**
     * Changes the value of an existing parameter.
     *
     * @param parameter The parameter to be changed in the url
     * @return Returns true if the parameter was changed. Returns false if the url does not contain the passed parameter.
     */
    @Override
    public boolean changeParameter(Parameter parameter) {
        if (!parameters.contains(parameter)) {
            return false;
        }
        hasUrlChanged |= this.parameters.add(parameter);
        return hasUrlChanged;
    }

    /**
     * Adds a new data field to the current url.
     *
     * @param dataField The new data field to be added to the url
     * @return Returns true if the data field is new and thus has been added.
     * Returns false if the data field is already part of the url.
     */
    @Override
    public boolean addDataField(DataField dataField) {
        hasUrlChanged |= this.dataFieldParameter.addDataField(dataField);
        return hasUrlChanged;
    }

    /**
     * Changes the value of an existing data field.
     *
     * @param dataField The data field to be changed in the url
     * @return Returns true if the data field was changed. Returns false if the url does not contain the passed data field.
     */
    @Override
    public boolean changeDataField(DataField dataField) {
        hasUrlChanged |= this.dataFieldParameter.changeDataField(dataField);
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