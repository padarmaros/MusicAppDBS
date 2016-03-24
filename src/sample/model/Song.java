package sample.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by marospadar on 24.03.16.
 */
public class Song {

    private final StringProperty name;
    private final StringProperty interpret;
    /*private final StringProperty album;
    private final StringProperty time;
    private final StringProperty ranking;
    private final StringProperty year;
    private final StringProperty genre;
*/


    public Song(){
        this(null,null);
    }

    /**
     * Constructor with some initial data.
     *
     * @param name
     * @param interpret
     *
     */
    public Song(String name, String interpret) {
        this.name = new SimpleStringProperty(name);
        this.interpret = new SimpleStringProperty(interpret);
    }



    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getInterpret() {
        return interpret.get();
    }

    public StringProperty interpretProperty() {
        return interpret;
    }

    public void setInterpret(String interpret) {
        this.interpret.set(interpret);
    }
/*
    public String getAlbum() {
        return album.get();
    }

    public StringProperty albumProperty() {
        return album;
    }

    public void setAlbum(String album) {
        this.album.set(album);
    }

    public String getTime() {
        return time.get();
    }

    public StringProperty timeProperty() {
        return time;
    }

    public void setTime(String time) {
        this.time.set(time);
    }

    public String getRanking() {
        return ranking.get();
    }

    public StringProperty rankingProperty() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking.set(ranking);
    }

    public String getYear() {
        return year.get();
    }

    public StringProperty yearProperty() {
        return year;
    }

    public void setYear(String year) {
        this.year.set(year);
    }

    public String getGenre() {
        return genre.get();
    }

    public StringProperty genreProperty() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre.set(genre);
    }
    */
}
