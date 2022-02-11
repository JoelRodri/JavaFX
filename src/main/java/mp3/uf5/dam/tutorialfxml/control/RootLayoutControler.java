package mp3.uf5.dam.tutorialfxml.control;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import mp3.uf5.dam.tutorialfxml.MainApp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Esta calse nos ayudara a controlar el RootLayout, que es el MenuBar.
 */

public class RootLayoutControler {
    /**
     * Creamos las variables de la clase.
     */
    Scene scene;
    Pane pane;
    MainApp mainApp = new MainApp();

    /**
     * Un constructor con el que le pasamos a la calse sus variables.
     * @param scene es la scene principal.
     * @param pane es el pane principal.
     */
    public void setScene(Scene scene, Pane pane) {
        this.scene=scene;
        this.pane = pane;
    }

    /**
     * Cambiamos el steelsheets del pane y le ponemos encima del que tiene el que nosotros queremos.
     */
    public void cambiarOscuro() {
        pane.getStylesheets().add("DarkTheme.css");
    }

    /**
     * Borramos el steelsheets que hay actualmente para volver al anterior (en este caso se borra el negro y se queda el blanco que habia antes).
     */
    public void cambiarClaro(){
        pane.getStylesheets().remove(pane.getStylesheets().size()-1);
//        pane.getStylesheets().add("WitheTheme.css");
    }

    /**
     * Se ejecuta el metodo que muestra el grafico
     */
    public void mostrarGrafico(){
        mainApp.showGraphics();
    }
    /**
     * Este metodo cierra la aplicación.
     */
    public void closeFile(){Platform.exit();}

    @FXML
    private void handleShowGraphics() {
        mainApp.showGraphics();
    }

    /**
     * Abrimos una pagina web externa de ayuda (este javadoc).
     */
    public void mostrarJavadoc(){
                mainApp.getHostServices().showDocument("http://gencat.cat/llengua/cinema/provacin.xml");
    }

    /**
     * Muestra el XML del que se saca la información(cat.xml)
     */
    public void mostrarXML(){
        mainApp.getHostServices().showDocument("http://gencat.cat/llengua/cinema/provacin.xml");
    }
}
