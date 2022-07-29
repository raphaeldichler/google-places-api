package net.plyse.google.api.place.search;


import lombok.AllArgsConstructor;
import net.plyse.google.api.place.exchange.DataExchange;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TextSearch extends Search<String> {

    private final DataExchange dataExchange;

    @Override
    public String search(String query) {
        return null;
    }

}
