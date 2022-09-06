package net.plyse.google.api.place.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlaceOpeningHours {

    private boolean openNow;
    private List<PlaceOpeningHoursPeriod> periods;
    private List<String> weekdayText;

}