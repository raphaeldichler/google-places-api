package net.plyse.google.api.place.controller.request;


import lombok.*;
import net.plyse.google.api.place.util.Utility;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TextSearchRequest implements Parameter {

    private String query;
    private String language;
    private Location location;
    @Builder.Default
    private int minprice = -1;
    @Builder.Default
    private int maxprice = -1;
    @Builder.Default
    private boolean opennow = false;
    @Builder.Default
    private int radius = -1;
    private String region;
    private String type;

    @Override
    public String getParameter() {
        if (query == null) {
            throw new IllegalStateException("Query is not an optional parameter.");
        }

        StringBuilder stringBuilder = new StringBuilder("?query=");
        stringBuilder.append(Utility.encodePath(query));

        if (language != null) {
            stringBuilder.append("&")
                    .append("language=")
                    .append(language);
        }

        if (location != null) {
            stringBuilder.append("&")
                    .append(location.getParameter());
        }

        if (Utility.isBetweenZeroAndFour(maxprice)) {
            stringBuilder.append("&")
                    .append("maxprice=")
                    .append(maxprice);
        }

        if (Utility.isBetweenZeroAndFour(minprice)) {
            stringBuilder.append("&")
                    .append("minprice=")
                    .append(minprice);
        }

        if (isOpennow()) {
            stringBuilder.append("&")
                    .append("opennow");
        }

        if (radius > 0) {
            stringBuilder.append("&")
                    .append("radius=")
                    .append(radius);
        }

        if (region != null) {
            stringBuilder.append("&")
                    .append("region=")
                    .append(region);
        }

        if (type != null) {
            stringBuilder.append("&")
                    .append("type=")
                    .append(type);
        }

        return stringBuilder.toString();
    }

}
