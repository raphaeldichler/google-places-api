package net.plyse.google.api.place.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Raphael Dichler on 16.09.2022.
 */
class LatLngLiteralTest {

    @Test
    void testToString() {
        LatLngLiteral l = new LatLngLiteral(5,6);
        assertEquals("5.0%2C6.0", l.toString());

        LatLngLiteral l1 = new LatLngLiteral(-5,-6);
        assertEquals("-5.0%2C-6.0", l1.toString());

        LatLngLiteral l2 = new LatLngLiteral(0,0);
        assertEquals("0.0%2C0.0", l2.toString());
    }

}