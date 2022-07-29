package net.plyse.google.api.place.controller.request;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ParameterTest {

    static Stream<Arguments> testTextSearchRequest() { //aB,.-123#+ö!"§$%&/()=?`< >^
        return Stream.of(
                Arguments.of("?query=test&opennow&type=Restaurant",
                        TextSearchRequest.builder().query("test").opennow(true).type("Restaurant").build()),
                Arguments.of("?query=test&language=de&type=Restaurant",
                        TextSearchRequest.builder().query("test").type("Restaurant").language("de").build()),
                Arguments.of("?query=test&radius=1337&type=Restaurant",
                        TextSearchRequest.builder().query("test").radius(1337).type("Restaurant").build()),
                Arguments.of("?query=test&location=-52.523%2C78.618&radius=1337&type=Restaurant",
                        TextSearchRequest.builder().query("test").radius(1337)
                                .location(Location.builder().lat(-52.523F).lon(78.618F).build()).type("Restaurant").build())
                );
    }

    static Stream<Arguments> testNearBySearchRequest() {
        return Stream.of(
//                Arguments.of()
        );
    }

    static Stream<Arguments> testFindPlaceSearchRequest() {
        return Stream.of(
//                Arguments.of()
        );
    }

    @ParameterizedTest
    @MethodSource({"testTextSearchRequest", "testNearBySearchRequest", "testFindPlaceSearchRequest"})
    void parameterTest(String expected, Parameter parameter) {
        assertEquals(expected, parameter.getParameter());
    }

}