package net.plyse.api.google.places.query.parameter;

/**
 * @author Raphael Dichler on 30.06.2022.
 */
public class LocationbiasParameter implements Parameter {

    private final LocationbiasType type;
    private final double lat;
    private final double lng;
    private final int distance;

    public LocationbiasParameter(LocationbiasType type, double lat, double lng, int distanceInMeter) {
        this.type = type;
        this.lat = lat;
        this.lng = lng;
        this.distance = distanceInMeter;
    }

    @Override
    public String toUrlValue() {
        return "locationbias=" + type + "%3A" + distance + lat + "%2C" + lng;
    }

    public enum LocationbiasType {

        CIRCLE("circle"),
        RADIUS("radius");

        private final String type;

        LocationbiasType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return type;
        }
    }

}
