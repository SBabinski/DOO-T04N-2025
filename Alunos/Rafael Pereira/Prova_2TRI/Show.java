package com.seriestracker;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Show {
    

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("language")
    private String language;

    @JsonProperty("genres")
    private List<String> genres;

    private double rating;
    private String network;

    @JsonProperty("status")
    private String status;

    @JsonProperty("premiered")
    private LocalDate premiered;

    @JsonProperty("ended")
    private LocalDate ended;
    
    
    public Show() {}

    
    @JsonProperty("rating")
    private void unpackRating(JsonNode ratingNode) {
        if (ratingNode != null && ratingNode.has("average") && !ratingNode.get("average").isNull()) {
            this.rating = ratingNode.get("average").asDouble();
        }
    }
    
    
    @JsonProperty("network")
    private void unpackNetwork(JsonNode networkNode) {
        if (networkNode != null && networkNode.has("name")) {
            this.network = networkNode.get("name").asText();
        }
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getLanguage() { return language; }
    public List<String> getGenres() { return genres; }
    public double getRating() { return rating; }
    public String getStatus() { return status; }
    public LocalDate getPremiered() { return premiered; }
    public LocalDate getEnded() { return ended; }
    public String getNetwork() { return network; }
    
    
    public Show(int id, String name, String language, List<String> genres, double rating, String status, LocalDate premiered, LocalDate ended, String network) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.genres = genres;
        this.rating = rating;
        this.status = status;
        this.premiered = premiered;
        this.ended = ended;
        this.network = network;
    }
    
    @Override
    public String toString() {
        return String.format("%s (Nota: %.1f) - Estreia: %s",
                name, rating, premiered);
    }

    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Show show = (Show) o;
        return id == show.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}