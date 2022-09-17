package net.plyse.google.api.place.util;


public final class Utility {

    public static final String TEXT_SEARCH_BASE_URL = "https://maps.googleapis.com/maps/api/place/textsearch/" ;
    public static final String PARAMETER_SEPARATOR = "&";


    private Utility() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    @SuppressWarnings("SameReturnValue")
    public static String getApiKey() {
        return "API_KEY";
    }

}
