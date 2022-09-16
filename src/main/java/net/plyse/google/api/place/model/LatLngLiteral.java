package net.plyse.google.api.place.model;

public record LatLngLiteral(float lat, float lng) implements Parameter {
    @Override
    public String getValue() {
        return String.format(Utility.LAT_LNG_STRING_FORMAT, lat, lng);
    }
}
