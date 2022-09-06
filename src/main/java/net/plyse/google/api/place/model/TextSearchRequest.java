package net.plyse.google.api.place.model;


public class TextSearchRequest implements Request {

    private static final String OUTPUT = "json";

    private static final String BASE_URL = "https://maps.googleapis.com/maps/api/place/textsearch/" + OUTPUT;

    @Override
    public String getUrl() {
        return null;
    }
}
