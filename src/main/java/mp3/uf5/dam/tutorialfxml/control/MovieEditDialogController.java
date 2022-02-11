package mp3.uf5.dam.tutorialfxml.control;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mp3.uf5.dam.tutorialfxml.model.Movie;
import mp3.uf5.dam.tutorialfxml.util.DateUtil;

public class MovieEditDialogController {
    @FXML
    private TextField titulo;
    @FXML
    private TextField año;
    @FXML
    private TextField streetField;
    @FXML
    private TextField postalCodeField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField birthdayField;


    private Stage dialogStage;
    private Movie movie;
    private boolean okClicked = false;

    /**
     * Inicializa la clase de controlador. Este método se llama automáticamente después de cargar el archivo fxml.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Establece la ventana de este diálogo.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Establece la persona que se va a editar en el cuadro de diálogo.
     *
     * @param movie
     */
    public void setPerson(Movie movie) {
        this.movie = movie;

        titulo.setText(movie.getTitulo());
        año.setText(movie.getAño());
        streetField.setText(movie.getDirector());
        postalCodeField.setText(movie.getActor());   //titulo, año , director, actor, idiomas, sinopsis, cartel,trailer
        cityField.setText(movie.getIdiomas());
        birthdayField.setText(movie.getSinopsis());
        //birthdayField.setPromptText("dd.mm.yyyy");
    }

    /**
     * Devuelve true si el usuario hizo clic en "Aceptar", de lo contrario es false.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Se llama cuando la usuario hace clic en "ok".
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            movie.setTitulo(titulo.getText());
            movie.setAño(año.getText());
            movie.setDirector(streetField.getText());
            movie.setActor(postalCodeField.getText());//titulo, año , director, actor, idiomas, sinopsis, cartel,trailer
            movie.setIdiomas(cityField.getText());
            movie.setSinopsis(birthdayField.getText());
            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Se llama cuando el usuario hace clic en "cancelar".
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Valida lo que el usuario ha escrito en los campos de texto.
     *
     * @return devuelve true si los campos son validos
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (titulo.getText() == null || titulo.getText().length() == 0) {
            errorMessage += "Nombre no valido!\n";
        }
        if (año.getText() == null || año.getText().length() == 0) {
            errorMessage += "Apellido no valido!\n";
        }
        if (streetField.getText() == null || streetField.getText().length() == 0) {
            errorMessage += "Calle no valida!\n";
        }

        if (postalCodeField.getText() == null || postalCodeField.getText().length() == 0) {
            errorMessage += "Codigo postal invalido!\n";
        }

        if (cityField.getText() == null || cityField.getText().length() == 0) {
            errorMessage += "Ciudad no valida!\n";
        }

        if (birthdayField.getText() == null || birthdayField.getText().length() == 0) {
            errorMessage += "Fecha no valida!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Campos erroneos.");
            alert.setHeaderText("Por favor, corrige los campos erroneos.");
            alert.setContentText(errorMessage);
            alert.show();

            return false;
        }
    }
}