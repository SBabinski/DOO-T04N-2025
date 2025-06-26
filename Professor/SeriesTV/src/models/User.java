package models;

import java.util.ArrayList;

public class User {
    String name;
    ArrayList<Serie> favorites;
    ArrayList<Serie> toWatch;
    ArrayList<Serie> watching;

    @Override
    public String toString() {
        return "User [name=" + name + ", favorites=" + favorites + ", toWatch=" + toWatch + ", watching=" + watching
                + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Serie> getFavorites() {
        return favorites;
    }

    public void setFavorites(ArrayList<Serie> favorites) {
        this.favorites = favorites;
    }

    public ArrayList<Serie> getToWatch() {
        return toWatch;
    }

    public void setToWatch(ArrayList<Serie> toWatch) {
        this.toWatch = toWatch;
    }

    public ArrayList<Serie> getWatching() {
        return watching;
    }

    public void setWatching(ArrayList<Serie> watching) {
        this.watching = watching;
    }

    
}
