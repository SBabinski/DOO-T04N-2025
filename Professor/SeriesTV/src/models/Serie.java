package models;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Serie {
    private String name;
    private String language;
    private String[] genres;
    private String rating;
    private String status;
    private Date premiered, ended;
    private String network;

    @Override
    public String toString() {
        return "Serie [name=" + name + ", language=" + language + ", genres=" + Arrays.toString(genres) + ", rating="
                + rating + ", status=" + status + ", premiered=" + premiered + ", ended=" + ended + ", network="
                + network + "]";
    }

    @JsonProperty("rating")
    private void unpackRating(Object value) {
        if (value instanceof Map<?, ?> map) {
            Object rating = map.get("average");
            this.rating = rating != null ? rating.toString() : "";
        } else if (value instanceof String rating) {
            this.rating = rating;
        }
    }

    @JsonProperty("network")
    private void unpackNetwork(Object value) {
        if (value instanceof Map<?, ?> map) {
            Object network = map.get("name");
            this.network = network != null ? network.toString() : "";
        } else if (value instanceof String network) {
            this.network = network;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getPremiered() {
        return premiered;
    }

    public void setPremiered(Date premiere) {
        this.premiered = premiere;
    }

    public Date getEnded() {
        return ended;
    }

    public void setEnded(Date ended) {
        this.ended = ended;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }
}