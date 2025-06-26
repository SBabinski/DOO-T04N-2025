package services;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.Serie;
import models.SerieWrapper;

public abstract class SerieMapper {
    
    static final ObjectMapper mapper = new ObjectMapper();

    public static Serie singleSerieMapper(String body){
        try {
            Serie serie = mapper.readValue(body, Serie.class);
            return serie;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Serie> multipleSerieMapper(String body){
        try {
            ArrayList<SerieWrapper> series = mapper.readValue(body, new TypeReference<ArrayList<SerieWrapper>>() {});
            return (ArrayList<Serie>) series.stream()
                       .map(SerieWrapper::getShow)
                       .collect(Collectors.toList());
        } catch (JsonProcessingException | NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }
}
