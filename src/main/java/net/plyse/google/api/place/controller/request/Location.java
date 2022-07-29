package net.plyse.google.api.place.controller.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Location implements Parameter {

    private float lat;
    private float lon;

    @Override
    public String getParameter() {
        return "location=" + lat + "%2C" + lon;
    }
}
