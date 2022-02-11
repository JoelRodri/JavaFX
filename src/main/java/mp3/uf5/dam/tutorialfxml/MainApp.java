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
import mp3.uf5.dam.tutorialfxml.control.PersonOverviewController;
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

public class MainApp extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    public static int[] puntuacion;

    private ObservableList<Movie> movieData = FXCollections.observableArrayList();

    public MainApp() {
        // Add some sample data
        puntuacion = new int[12];
        readXML();

    }



    /**
     * Returns the data as an observable list of Persons.
     *
     * @return ObservableList<Person>
     */
    public ObservableList<Movie> getPersonData() {
        return movieData;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");

        initRootLayout();

        showPersonOverview();
    }

    /**
     * Initializes the root layout.
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
     * Shows the person overview inside the root layout.
     */
    public void showPersonOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("person-overview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);

            // Give the controller access to the main app.
            PersonOverviewController controller = loader.getController();
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
     * @param movie the person object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean showPersonEditDialog(Movie movie) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("person-editDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            MovieEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(movie);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Returns the main stage.
     *
     * @return Stage
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static int[] getpuntuacion (){
        return puntuacion;
    }

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

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
    String date = "16/12/2016";
    //MAY JUNE JULY AUGUST SEPTEMBER OCTOBER NOVEMBER DECEMBER

    //convert String to LocalDate


    public void readXML(){


        try {
            // internet URL
            URL url = new URL("http://gencat.cat/llengua/cinema/provacin.xml");

            // download and save image
            ReadableByteChannel rbc = Channels.newChannel(url.openStream());
            FileOutputStream fos = new FileOutputStream("cat.xml");
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);

            //close writers
            fos.close();
            rbc.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //String FILENAME = "/home/dam2a-2021/IdeaProjects/tutorialJavaFX-main/cat.xml";
        //String FILENAME = "C:\\Users\\Usuario\\IdeaProjects\\JavaFXAlan\\cat.xml";
        String FILENAME = "cat.xml";

        // Instantiate the Factory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {

            // optional, but recommended
            // process XML securely, avoid attacks like XML External Entities (XXE)
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            // parse XML file
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

                    // get staff's attribute
                    //String id = element.getAttribute("id");

                    // get text
                    //TITOL ESTRENA DIRECCIO INTERPRETS IDIOMA_x0020_ORIGINAL SINOPSI CARTELL TRAILER
                    String firstname = element.getElementsByTagName("TITOL").item(0).getTextContent();
                    String lastname = element.getElementsByTagName("CARTELL").item(0).getTextContent();
                    String street = element.getElementsByTagName("IDIOMA_x0020_ORIGINAL").item(0).getTextContent();
                    String city = element.getElementsByTagName("ESTRENA").item(0).getTextContent();

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
                    System.out.println("First Name : " + firstname);
                    System.out.println("Last Name : " + lastname);
                    System.out.println("Idioma: " + street);
                    System.out.println("fecha: " + city);
                    String imagen = "http://gencat.cat/llengua/cinema/"+ lastname;


                    movieData.add(new Movie(titulo, año , director, actor, idiomas, sinopsis, cartel,trailer));

                    //personData.add(new Person(firstname, imagen , street, city));

//MAY JUNE JULY AUGUST SEPTEMBER OCTOBER NOVEMBER DECEMBER


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

        /*System.out.println("aqui");
        System.out.println(month);
        System.out.println("aqui");*/
    }
}