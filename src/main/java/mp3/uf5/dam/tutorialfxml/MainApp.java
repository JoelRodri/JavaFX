package mp3.uf5.dam.tutorialfxml;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mp3.uf5.dam.tutorialfxml.control.MovieEditDialogController;
import mp3.uf5.dam.tutorialfxml.control.MovieOverviewController;
import mp3.uf5.dam.tutorialfxml.control.RootLayoutControler;
import mp3.uf5.dam.tutorialfxml.model.Movie;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;


/**
 *  Esta calse se encargara de iniciar  main principal de la aplicacion
 */

public class MainApp extends Application {

    /**
     * Creamos las variables de la clase.
     */

    private Stage primaryStage;
    private BorderPane rootLayout;
    public static int[] puntuacion;
    private ObservableList<Movie> movieData = FXCollections.observableArrayList();



    /**
     * Un constructor que iniciara la aplicacion con un array de 12 meses del año y un metedo que leera y cargara un xml
     */
    public MainApp() {
        // Add some sample data
        puntuacion = new int[12];
        readXML();

    }



    /**
     * Metodo getMovieData  es un getter que devuelve los datos de la pelicula
     * @return movieData los datos de la peli
     */

    public ObservableList<Movie> getMovieData() {
        return movieData;
    }

    /**
     * Metodo start que prepara el escenario principal y lo muestra con el titulo de la App
     * @param primaryStage le pasamos un Escenario
     */
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Movie Maker");

        initRootLayout();

        showMovieOverview();
    }

    /**
     * Metodo initRootLayout carga y muestra el root-layout.fxml
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("root-layout.fxml"));
            rootLayout = (BorderPane) loader.load();
            RootLayoutControler rootLayoutControler = loader.getController();
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            rootLayoutControler.setScene(scene, rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo showMoiveOverview muestra la pelicula dentro del movie-overview layout
     */
    // --------######@@@@@@@!!!!!!!!????-----------------  REFACTOR  ----------------------######@@@@@@@!!!!!!!!????--------------------------
    // --------######@@@@@@@!!!!!!!!????-----------------  REFACTOR  ----------------------######@@@@@@@!!!!!!!!????--------------------------
    // --------######@@@@@@@!!!!!!!!????-----------------  REFACTOR  ----------------------######@@@@@@@!!!!!!!!????--------------------------
    public void showMovieOverview() {
        try {

            FXMLLoader loader = new FXMLLoader();
            // --------######@@@@@@@!!!!!!!!????-----------------  REFACTOR  ----------------------######@@@@@@@!!!!!!!!????--------------------------
            // --------######@@@@@@@!!!!!!!!????-----------------  REFACTOR  ----------------------######@@@@@@@!!!!!!!!????--------------------------
            loader.setLocation(MainApp.class.getResource("movie-overview.fxml"));
            AnchorPane movieOverview = (AnchorPane) loader.load();


            rootLayout.setCenter(movieOverview);


            MovieOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Opens a dialog to edit details for the specified person. If the user
     * clicks OK, the changes are saved into the provided person object and true
     * is returned.
     *
     * Metodo showMovieEditDialog carga y muestra el movie-editDialog.fxml. Gracias a este metodo seremos capaces de editar los datos de una pelicul
     *
     * @param movie la pelicula selecionada
     * @return true devuelve true si seleciona una pelicula
     */
    public boolean showMovieEditDialog(Movie movie) {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("movie-editDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();


            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Movie");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);


            MovieEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMovie(movie);


            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Metodo getPrimaryStage es un getter que devuelve el escenario principal
     *
     * @return primaryStage el Escenario
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * Metodo main inicia el codigo
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Metodo getpuntuacion es un getter que devuelve el array puntuacion que es total del numero de veces de peliculas por mes
     *
     * @return primaryStage el Escenario
     */
    public static int[] getpuntuacion (){
        return puntuacion;
    }


    /**
     * Metodo showGraphics carga el archivo graphic.fxml y cree una nueva ventana a modo de po
     */
    public void showGraphics() {
        try {
            // Load the fxml file and create a new stage for the popup.

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("graphic.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Numero de estrenos");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            dialogStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo readXML descarga de una url un xml y lo lee y guarda los datos deseados
     */

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");


    public void readXML(){


        try {

            URL url = new URL("http://gencat.cat/llengua/cinema/provacin.xml");


            ReadableByteChannel rbc = Channels.newChannel(url.openStream());
            FileOutputStream fos = new FileOutputStream("cat.xml");
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);


            fos.close();
            rbc.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }


        String FILENAME = "cat.xml";


        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {


            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);


            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(FILENAME));

            // optional, but recommended
            // http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
            System.out.println("------");

            // get <staff>
            NodeList list = doc.getElementsByTagName("FILM");

            for (int temp = 0; temp < list.getLength(); temp++) {

                Node node = list.item(temp);


                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;

                    String titulo = element.getElementsByTagName("TITOL").item(0).getTextContent();
                    String año = element.getElementsByTagName("ESTRENA").item(0).getTextContent();
                    String director = element.getElementsByTagName("DIRECCIO").item(0).getTextContent();
                    String actor = element.getElementsByTagName("INTERPRETS").item(0).getTextContent();
                    String idiomas = element.getElementsByTagName("IDIOMA_x0020_ORIGINAL").item(0).getTextContent();
                    String sinopsis = element.getElementsByTagName("SINOPSI").item(0).getTextContent();
                    String cartel = element.getElementsByTagName("CARTELL").item(0).getTextContent();
                    String trailer = element.getElementsByTagName("TRAILER").item(0).getTextContent();

                    cartel = "http://gencat.cat/llengua/cinema/" + cartel;
                    trailer = "https://www.youtube.com/watch?v=" + trailer;


                    String month = "00/00/00";
                    try {
                            LocalDate localDate = LocalDate.parse(año, formatter);
                            Month monthREAL = localDate.getMonth();
                            month = monthREAL.toString();

                    }catch (Exception e){

                    }




                    System.out.println("Current Element :" + node.getNodeName());
                    // System.out.println("Staff Id : " + id);
                    System.out.println("Titulo : " + titulo);
                    System.out.println("Año : " + año);
                    System.out.println("Director: " + director);
                    System.out.println("Actores: " + actor);
                    String imagen = "http://gencat.cat/llengua/cinema/"+ cartel;


                    movieData.add(new Movie(titulo, año , director, actor, idiomas, sinopsis, cartel,trailer));


                    switch (month)
                    {
                        case "JANUARY": puntuacion[0] ++;
                            break;
                        case "FEBRUARY": puntuacion[1] ++;
                            break;
                        case "MARCH": puntuacion[2] ++;
                            break;
                        case "APRIL": puntuacion[3] ++;
                            break;
                        case "MAY": puntuacion[4] ++;
                            break;
                        case "JUNE": puntuacion[5] ++;
                            break;
                        case "JULY": puntuacion[6] ++;
                            break;
                        case "AUGUST": puntuacion[7] ++;
                            break;
                        case "SEPTEMBER": puntuacion[8] ++;
                            break;
                        case "OCTOBER": puntuacion[9] ++;
                            break;
                        case "NOVEMBER": puntuacion[10] ++;
                            break;
                        case "DECEMBER": puntuacion[11] ++;
                            break;
                        default:
                            System.out.println("ERROR");
                            break;
                    }
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}