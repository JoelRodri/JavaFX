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

                new PieChart.Data("E",puntuacion[0]),
                new PieChart.Data("F",puntuacion[1]),
                new PieChart.Data("MR",puntuacion[2]),
                new PieChart.Data("AB",puntuacion[3]),
                new PieChart.Data("MY",puntuacion[4]),
                new PieChart.Data("JN",puntuacion[5]),
                new PieChart.Data("JL",puntuacion[6]),
                new PieChart.Data("AG",puntuacion[7]),
                new PieChart.Data("S",puntuacion[8]),
                new PieChart.Data("O",puntuacion[9]),
                new PieChart.Data("N",puntuacion[10]),
                new PieChart.Data("D",puntuacion[11]));

        pieChartData.forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(
                                data.getName(), " ", (int) data.getPieValue()
                        )
                ));

        pieChart.getData().addAll(pieChartData);


    }
}
