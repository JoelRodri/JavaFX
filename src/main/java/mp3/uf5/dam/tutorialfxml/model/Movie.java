package mp3.uf5.dam.tutorialfxml.model;

import javafx.beans.property.*;

/**
 * Esta clase se encarga de guardar los datos de cada pelicula
 */
public class Movie {

    /**
     * Constructor predeterminado
     */

    private final StringProperty titulo;
    private final StringProperty año;
    private final StringProperty director;
    private final StringProperty actor;
    private final StringProperty idiomas;
    private final StringProperty sinopsis;
    private final StringProperty cartel;
    private final StringProperty trailer;

    /**
     * Constructor predeterminado que inicializa pelicula con los datos en nulo
     */

    public Movie(){
        this(null,null,null,null,null,null,null,null);
    }

    /**
     * Constructor que recibe los datos para guardarlos
     */

    public Movie(String titulo, String año, String director, String actor, String idiomas, String sinopsis, String cartel, String trailer) {
        this.titulo = new SimpleStringProperty(titulo);
        this.año = new SimpleStringProperty(año);
        this.director = new SimpleStringProperty(director);
        this.actor = new SimpleStringProperty(actor);
        this.idiomas = new SimpleStringProperty(idiomas);
        this.sinopsis = new SimpleStringProperty(sinopsis);
        this.cartel = new SimpleStringProperty(cartel);
        this.trailer = new SimpleStringProperty(trailer);
    }

    /**
     * Getters y Setters de la pelicula
     */
    public String getTitulo() {
        return titulo.get();
    }

    public StringProperty tituloProperty() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo.set(titulo);
    }

    public String getAño() {
        return año.get();
    }

    public StringProperty añoProperty() {
        return año;
    }

    public void setAño(String año) {
        this.año.set(año);
    }

    public String getDirector() {
        return director.get();
    }

    public StringProperty directorProperty() {
        return director;
    }

    public void setDirector(String director) {
        this.director.set(director);
    }

    public String getActor() {
        return actor.get();
    }

    public StringProperty actorProperty() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor.set(actor);
    }

    public String getIdiomas() {
        return idiomas.get();
    }

    public StringProperty idiomasProperty() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas.set(idiomas);
    }

    public String getSinopsis() {
        return sinopsis.get();
    }

    public StringProperty sinopsisProperty() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis.set(sinopsis);
    }

    public String getCartel() {
        return cartel.get();
    }

    public StringProperty cartelProperty() {
        return cartel;
    }

    public void setCartel(String cartel) {
        this.cartel.set(cartel);
    }

    public String getTrailer() {
        return trailer.get();
    }

    public StringProperty trailerProperty() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer.set(trailer);
    }
}
