package mp3.uf5.dam.tutorialfxml.control;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.IOException;

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

    public void setScene(Scene scene, Pane pane) {
        this.scene=scene;
        this.pane = pane;
    }
}
