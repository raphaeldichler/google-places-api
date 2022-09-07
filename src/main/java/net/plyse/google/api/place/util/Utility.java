package net.plyse.google.api.place.util;


import java.nio.charset.StandardCharsets;

public final class Utility {

    public static final String CHARSET = StandardCharsets.UTF_8.toString();

    private Utility() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static boolean isBetweenZeroAndFour(int x) {
        return x >= 0 && x <= 4;
    }


    public static String getApiKey() {
        return "API_KEY";
    }

}
