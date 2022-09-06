package net.plyse.google.api.place.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlaceOpeningHoursPeriod {

    private PlaceOpeningHoursPeriodDetail open;
    private PlaceOpeningHoursPeriodDetail close;

}
