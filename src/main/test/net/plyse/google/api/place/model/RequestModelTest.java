package net.plyse.google.api.place.model;

import net.plyse.google.api.place.exception.MissingParameterException;
import net.plyse.google.api.place.util.Utility;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RequestModelTest {

    private static final float LAT = (float) 2.2;
    private static final float LNG = (float) 72.4;
    private static final String TEXT_SEARCH_BASE_URL = "https://maps.googleapis.com/maps/api/place/textsearch/json?";

    static Stream<Arguments> textSearchTest() {
        return Stream.of(
            Arguments.of(new TextSearchRequest("query", "de", null, -1,
                    -1, null, null, -1, null, null),
                    TEXT_SEARCH_BASE_URL + "query=query&key=" + Utility.getApiKey() + "&language=de"),
                Arguments.of(new TextSearchRequest("query", null, new LatLngLiteral(LAT, LNG), -1,
                                -1, null, null, -1, null, null),
                        TEXT_SEARCH_BASE_URL + "query=query&key=" + Utility.getApiKey() + "&location=" + LAT + "%2C" + LNG),
                Arguments.of(new TextSearchRequest("query", null, null, 4,
                                2, true, null, -1, null, null),
                        TEXT_SEARCH_BASE_URL + "query=query&key=" + Utility.getApiKey() + "&maxprice=4&minprice=2&opennow=true"),
                Arguments.of(new TextSearchRequest("query", null, null, -1,
                                -1 , null, "null", -1, null, null),
                        TEXT_SEARCH_BASE_URL + "query=query&key=" + Utility.getApiKey() + "&pagetoken=null")
        );
    }

    @Test
    void missingQueryParameterTextSearchTest() {
        assertThrows(MissingParameterException.class,
                () -> new TextSearchRequest().getUrl());
        TextSearchRequest blankQuery = new TextSearchRequest();
        blankQuery.setQuery("");
        assertThrows(MissingParameterException.class,
                blankQuery::getUrl);
    }

    @ParameterizedTest
    @MethodSource({"textSearchTest"})
    void urlTest(Request request, String expected) {
        assertEquals(expected, request.getUrl());
    }


}