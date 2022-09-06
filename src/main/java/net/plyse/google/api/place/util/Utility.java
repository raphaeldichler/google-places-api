package net.plyse.google.api.place.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.UriUtils;

import java.nio.charset.StandardCharsets;

public final class Utility {

    private static final Logger LOGGER = LoggerFactory.getLogger(Utility.class);

    public static final String CHARSET = StandardCharsets.UTF_8.toString();

    private Utility() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static String encodePath(String path) {
        return UriUtils.encodePath(path, CHARSET);
    }

    public static boolean isBetweenZeroAndFour(int x) {
        return x >= 0 && x <= 4;
    }

}
