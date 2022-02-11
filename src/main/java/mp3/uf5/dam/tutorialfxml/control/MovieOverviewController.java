package mp3.uf5.dam.tutorialfxml.control;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import mp3.uf5.dam.tutorialfxml.MainApp;
import mp3.uf5.dam.tutorialfxml.model.Movie;

/**
 * Esta calse nos ayudara a controlar el movie-overview.fxml, para mostrar en una tabla todas las peliculas.
 */
public class MovieOverviewController {
    @FXML
    private TableView<Movie> movieTable;
    @FXML
    private TableColumn<Movie, String> tituloColumn;
    @FXML
    private TableColumn<Movie, String> lastNameColumn;

    @FXML
    private Label tituloLabel;
    @FXML
    private Label añoLabel;
    @FXML
    private Label directorLabel;
    @FXML
    private Label actoresLabel;
    @FXML
    private Label idiomasLabel;
    @FXML
    private Label sipnosisLabel;
    @FXML
    private ImageView image;

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * El construcor.
     * El constructor se llama al iniciar el metodo initialize().
     */

    String universal;

    public MovieOverviewController() {
    }

    /**
     * Inicializa la clase de controlador.
     * Este método se llama automáticamente después de que se haya cargado el archivo fxml.
     */
    @FXML
    private void initialize() {

        tituloColumn.setCellValueFactory(cellData -> cellData.getValue().tituloProperty());


        showMovieDetails(null);


        movieTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showMovieDetails(newValue));
    }

    /**
     * Es llamado por la aplicación principal para devolver una referencia a sí mismo.
     * @param mainApp
     */


    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        // Add observable list data to the table
        movieTable.setItems(mainApp.getMovieData());

    }

    @FXML
    private void showYoutube() {
        //String url = person.getStreet();
        mainApp.getHostServices().showDocument(universal);

    }
    /**
     * Rellena todos los campos de texto para mostrar detalles sobre la persona.
     * Si la persona especificada es nula, se borran todos los campos de texto.
     *
     * @param movie la persona o null
     */
    private void showMovieDetails(Movie movie) {
        if (movie != null) {
            // Fill the labels with info from the person object.
            tituloLabel.setText(movie.getTitulo());
            añoLabel.setText(movie.getAño());
            directorLabel.setText(movie.getDirector());
            actoresLabel.setText(movie.getActor());  //titulo, año , director, actor, idiomas, sinopsis, cartel,trailer
            idiomasLabel.setText(movie.getIdiomas());
            sipnosisLabel.setText(movie.getSinopsis());

            image.setImage(new Image(movie.getCartel()));

            String url = movie.getTrailer();
            universal = url;
            //mainApp.getHostServices().showDocument(url);

        } else {
            // Person is null, remove all the text.
            tituloLabel.setText("");
            añoLabel.setText("");
            directorLabel.setText("");
            actoresLabel.setText("");
            idiomasLabel.setText("");
            sipnosisLabel.setText("");
        }
    }

    /**
     * Se llama cuando el usuario hace clic en el botón Eliminar.
     */
    @FXML
    private void handleDeleteMovie() {
        int selectedIndex = movieTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            movieTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No ha seleccionado nada");
            alert.setHeaderText("Ninguna pelicula seleccionada");
            alert.setContentText("Por favor, selecciona una pelicula de la tabla.");
            alert.show();
            /*Dialogs.create()
                    .title("No Selection")
                    .masthead("No Person Selected")
                    .message("Please select a person in the table.")
                    .showWarning();*/
        }

    }

    /**
     * Se llama cuando el usuario hace clic en el botón nuevo.
     * Se abre una ventana para editar los detalles de una nueva pelicula.
     */

    @FXML
    private void handleNewMovie() {
        Movie tempMovie = new Movie();
        boolean okClicked = mainApp.showMovieEditDialog(tempMovie);
        if (okClicked) {
            mainApp.getMovieData().add(tempMovie);
        }
    }

    /**
     * Se llama cuando el usuario hace clic en el botón editar.
     * Se abre una ventana para editar los detalles de la pelicula.
     */
    @FXML
    private void handleEditMovie() {
        Movie selectedMovie = movieTable.getSelectionModel().getSelectedItem();
        if (selectedMovie != null) {
            boolean okClicked = mainApp.showMovieEditDialog(selectedMovie);
            if (okClicked) {
                showMovieDetails(selectedMovie);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No ha seleccionado nada");
            alert.setHeaderText("Ninguna pelicula seleccionada");
            alert.setContentText("Por favor, selecciona una pelicula de la tabla.");
            alert.show();

        }
    }
}