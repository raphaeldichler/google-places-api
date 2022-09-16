package net.plyse.google.api.place.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RequestModelTest {

    private static final float LAT = (float) 2.2;
    private static final float LNG = (float) 72.4;
    private static final String TEXT_SEARCH_BASE_URL = "https://maps.googleapis.com/maps/api/place/textsearch/json?";

    static Stream<Arguments> textSearchTest() {
        return Stream.of(
            Arguments.of()
        );
    }

    @Test
    void missingQueryParameterTextSearchTest() {
//        assertThrows(MissingParameterException.class,
//                () -> new TextSearchRequest().getUrl());
//        TextSearchRequest blankQuery = new TextSearchRequest();
////        blankQuery.setQuery("");
//        assertThrows(MissingParameterException.class,
//                blankQuery::getUrl);
    }

    @ParameterizedTest
    @MethodSource({"textSearchTest"})
    void urlTest(Request request, String expected) {
        assertEquals(expected, request.getUrl());
    }


}