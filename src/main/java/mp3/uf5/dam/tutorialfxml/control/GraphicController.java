package mp3.uf5.dam.tutorialfxml.control;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import mp3.uf5.dam.tutorialfxml.MainApp;

import java.net.URL;
import java.util.ResourceBundle;

public class GraphicController implements Initializable {

    @FXML
    private PieChart pieChart;

    int[] puntuacion;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        puntuacion = MainApp.getpuntuacion();



        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                /*new PieChart.Data("LUCHADOR",stats[0]),
                new PieChart.Data("MAGO",stats[1]),
                new PieChart.Data("ASESINO",stats[2]),
                new PieChart.Data("TIRADOR",stats[3]),
                new PieChart.Data("TANQUE",stats[4]),
                new PieChart.Data("APOYO",stats[5]));*/

                new PieChart.Data("Enero",puntuacion[0]),
                new PieChart.Data("Febrero",puntuacion[1]),
                new PieChart.Data("Marzo",puntuacion[2]),
                new PieChart.Data("Abril",puntuacion[3]),
                new PieChart.Data("Mayo",puntuacion[4]),
                new PieChart.Data("Junio",puntuacion[5]),
                new PieChart.Data("Julio",puntuacion[6]),
                new PieChart.Data("Agosto",puntuacion[7]),
                new PieChart.Data("Septiembre",puntuacion[8]),
                new PieChart.Data("Octubre",puntuacion[9]),
                new PieChart.Data("Noviembre",puntuacion[10]),
                new PieChart.Data("Diciembre",puntuacion[11]));

        pieChartData.forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(
                                data.getName(), " ", (int) data.getPieValue()
                        )
                ));

        pieChart.getData().addAll(pieChartData);


    }
}
