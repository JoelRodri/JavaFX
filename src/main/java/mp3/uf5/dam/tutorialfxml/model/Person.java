package mp3.uf5.dam.tutorialfxml.model;

import javafx.beans.property.*;
import javafx.scene.image.Image;

import java.time.LocalDate;

public class Person {

    /*private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty street;
    private final IntegerProperty postalCode;
    private final StringProperty city;
    private final ObjectProperty<LocalDate> birthday;*/


    private final StringProperty titulo;
    private final StringProperty año;
    private final StringProperty director;
    private final StringProperty actor;
    private final StringProperty idiomas;
    private final StringProperty sinopsis;
    private final StringProperty cartel;
    private final StringProperty trailer;

    /**
     * Constructor predeterminado.
     */
    /*public Person() {
        this(null,null,null,null);
    }*/

    /*public Person(){
        this(null,null,null,null);
    }*/

    public Person(){
        this(null,null,null,null,null,null,null,null);
    }

    public Person(String titulo, String año, String director, String actor, String idiomas, String sinopsis, String cartel, String trailer) {
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
     * Constructor con información
     *
     * @param firstName
     * @param lastName
     */
    /*public Person(String firstName, String lastName, String street, String city) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.street = new SimpleStringProperty(street);
        this.city = new SimpleStringProperty(city);
        // Some initial dummy data, just for convenient testing.

        this.postalCode = new SimpleIntegerProperty(1234);

        this.birthday = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
    }*/



    /*public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getStreet() {
        return street.get();
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public StringProperty streetProperty() {
        return street;
    }

    public int getPostalCode() {
        return postalCode.get();
    }

    public void setPostalCode(int postalCode) {
        this.postalCode.set(postalCode);
    }

    public IntegerProperty postalCodeProperty() {
        return postalCode;
    }

    public String getCity() {
        return city.get();
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public StringProperty cityProperty() {
        return city;
    }

    public LocalDate getBirthday() {
        return birthday.get();
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }

    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }*/

    // -------------------------------------


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
