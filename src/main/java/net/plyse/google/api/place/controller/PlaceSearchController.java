package net.plyse.google.api.place.controller;

import net.plyse.google.api.place.model.request.TextSearchRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/google/place-search")
public class PlaceSearchController {

    @PostMapping("/text-search")
    public String textSearch(@RequestBody TextSearchRequest textSearchRequest) {
        return textSearchRequest.getParameter();
    }

}
