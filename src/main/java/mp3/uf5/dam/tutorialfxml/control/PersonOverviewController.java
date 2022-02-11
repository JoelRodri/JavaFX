package mp3.uf5.dam.tutorialfxml.control;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import mp3.uf5.dam.tutorialfxml.MainApp;
import mp3.uf5.dam.tutorialfxml.model.Person;
import mp3.uf5.dam.tutorialfxml.util.DateUtil;

public class PersonOverviewController {
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label birthdayLabel;
    @FXML
    private ImageView image;

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * El construcor.
     * El constructor se llama al iniciar el metodo initialize().
     */

    String universal;

    public PersonOverviewController() {
    }

    /**
     * Inicializa la clase de controlador.
     * Este método se llama automáticamente después de que se haya cargado el archivo fxml.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().tituloProperty());

        // Clear person details.
        showPersonDetails(null);

        // Listen for selection changes and show the person details when changed.
        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));
    }

    /**
     * Es llamado por la aplicación principal para devolver una referencia a sí mismo.
     * @param mainApp
     */


    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        // Add observable list data to the table
        personTable.setItems(mainApp.getPersonData());

    }


    @FXML
    private void handleShowGraphics() {
        mainApp.showGraphics();
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
     * @param person la persona o null
     */
    private void showPersonDetails(Person person) {
        if (person != null) {
            // Fill the labels with info from the person object.
            firstNameLabel.setText(person.getTitulo());
            lastNameLabel.setText(person.getAño());
            streetLabel.setText(person.getDirector());
            postalCodeLabel.setText(person.getActor());  //titulo, año , director, actor, idiomas, sinopsis, cartel,trailer
            cityLabel.setText(person.getIdiomas());
            birthdayLabel.setText(person.getSinopsis());

            image.setImage(new Image(person.getCartel()));

            String url = person.getTrailer();
            universal = url;
            //mainApp.getHostServices().showDocument(url);

        } else {
            // Person is null, remove all the text.
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            streetLabel.setText("");
            postalCodeLabel.setText("");
            cityLabel.setText("");
            birthdayLabel.setText("");
        }
    }

    /**
     * Se llama cuando el usuario hace clic en el botón Eliminar.
     */
    @FXML
    private void handleDeletePerson() {
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            personTable.getItems().remove(selectedIndex);
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
    private void handleNewPerson() {
        Person tempPerson = new Person();
        boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
        if (okClicked) {
            mainApp.getPersonData().add(tempPerson);
        }
    }

    /**
     * Se llama cuando el usuario hace clic en el botón editar.
     * Se abre una ventana para editar los detalles de la pelicula.
     */
    @FXML
    private void handleEditPerson() {
        Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
            if (okClicked) {
                showPersonDetails(selectedPerson);
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