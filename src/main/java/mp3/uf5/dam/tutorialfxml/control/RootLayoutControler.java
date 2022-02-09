package mp3.uf5.dam.tutorialfxml.control;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class RootLayoutControler {

    Scene scene;
    Pane pane;
    public void cambiarOscuro() {
        pane.getStylesheets().add("DarkTheme.css");
    }

    public void cambiarClaro(){
        pane.getStylesheets().remove(pane.getStylesheets().size()-1);
//        pane.getStylesheets().add("WitheTheme.css");
    }

    /*public void closeFile(){
        Platform.exit();
    }*/

    public void closeFile(){
        Platform.exit();
    }

    public void setScene(Scene scene, Pane pane) {
        this.scene=scene;
        this.pane = pane;
    }
}
