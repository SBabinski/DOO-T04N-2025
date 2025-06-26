package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SerieWrapper {

    private Serie show;

    public Serie getShow() {
        return show;
    }

    public void setShow(Serie show) {
        this.show = show;
    }
}