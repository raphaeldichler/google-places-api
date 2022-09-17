package net.plyse.google.api.place.model;

import java.util.HashMap;
import java.util.Map;

import static net.plyse.google.api.place.util.Utility.PARAMETER_SEPARATOR;

public abstract class Request {

    protected final String BASE_URL;
    protected final Map<Parameter, String> parameters = new HashMap<>();

    public Request(String baseUrl) {
        this.BASE_URL = baseUrl;
    }

    /**
     * Creates a URL based on the passed parameters (from addParameter).
     * @return Die URL mit welcher einen Request an die TextSearch API stellen kann.
     */
    public String getUrl() {
        StringBuilder stringBuilder = new StringBuilder(this.BASE_URL).append(PARAMETER_SEPARATOR);

        for (Map.Entry<Parameter, String> para : parameters.entrySet()) {
            stringBuilder.append(para.getKey().getValue())
                    .append(para.getValue()).append(PARAMETER_SEPARATOR);
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        return stringBuilder.toString();
    }

}
