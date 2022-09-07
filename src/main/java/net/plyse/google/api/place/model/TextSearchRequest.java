package net.plyse.google.api.place.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.plyse.google.api.place.exception.IllegalParameterException;
import net.plyse.google.api.place.exception.MissingParameterException;

import static com.fasterxml.jackson.annotation.JsonInclude.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@JsonInclude(Include.NON_NULL)
public class TextSearchRequest implements Request {

    private static final String OUTPUT = "json";

    private static final String BASE_URL = "https://maps.googleapis.com/maps/api/place/textsearch/" + OUTPUT ;
    private String query;
    private String language;
    private LatLngLiteral location;
    private int maxPrice = -1;
    private int minPrice = -1;
    private Boolean openNow;
    private String pageToken;
    private int radius = -1;
    private String region;
    private String type;

    public static void main(String[] args) throws JsonProcessingException {
        String jsonString =
                "{\n" +
                "\t\"query\": \"Hello World\",\n" +
                "\t\"language\": \"de\",\n" +
                "\t\"location\": {\n" +
                "\t\t\"lat\": \"13.432\",\n" +
                "\t\t\"lng\": \"-78.928\"\n" +
                "\t}\n" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        TextSearchRequest textSearchRequest = mapper.readValue(jsonString, TextSearchRequest.class);


        System.out.println(textSearchRequest);
    }

    @Override
    public String getUrl() {
        if (query == null || query.isEmpty()) {
            throw new MissingParameterException("A query is always needed for a text search.");
        }

        StringBuilder stringBuilder = new StringBuilder(BASE_URL).append("?query=").append(query).append("&");

        if (language != null) stringBuilder.append("language=").append(language).append("&");
        if (location != null) stringBuilder.append("location=").append(location.getLat())
                    .append("%2C").append(location.getLng())
                    .append("&");
        if (maxPrice != -1) stringBuilder.append("maxprice=").append(maxPrice).append("&");
        if (minPrice != -1) stringBuilder.append("minprice=").append(minPrice).append("&");
        if (openNow != null) stringBuilder.append("opennow=").append(openNow).append("&");
        if (pageToken != null) stringBuilder.append("pagetoken=").append(pageToken).append("&");
        if (radius != -1) stringBuilder.append("radius=").append(radius).append("&");
        if (region != null) stringBuilder.append("region=").append(region).append("&");
        if (type != null) stringBuilder.append("type=").append(type).append("&");

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        return stringBuilder.toString();
    }


}
