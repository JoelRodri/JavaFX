package mp3.uf5.dam.tutorialfxml.control;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class RootLayoutControler {

    Scene scene;
    Pane pane;
    public void cambiarStile(ActionEvent actionEvent) throws IOException {

        pane.getStylesheets().add("DarkTheme.css");

//        Parent root;
//        root = (AnchorPane) FXMLLoader.load(getClass().getResource("CssChange.fxml"));
//        String css = CssChange.class.getResource("login2.css").toExternalForm();
//        root.getStylesheets().clear();
//        root.getStylesheets().add(css);
//        root.applyCss();
    }

    public void setScene(Scene scene, Pane pane) {
        this.scene=scene;
        this.pane = pane;
    }
}
