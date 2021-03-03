package kurswahl.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import kurswahl.Wahlpruefung;
import kurswahl.models.Kurs;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private Wahlpruefung wahlpruefung;

    @FXML
    private GridPane grid;

    @FXML
    private ComboBox<String> deutschPF;

    @FXML
    private ComboBox<String> englischPF;

    @FXML
    private ComboBox<String> franzoesischPF;

    @FXML
    private ComboBox<String> lateinPF;

    @FXML
    private ComboBox<String> musikPF;

    @FXML
    private ComboBox<String> bildendekunstPF;

    @FXML
    private ComboBox<String> darstellendesspielPF;

    @FXML
    private ComboBox<String> politikwissenschaftenPF;

    @FXML
    private ComboBox<String> geschichtePF;

    @FXML
    private ComboBox<String> geographiePF;

    @FXML
    private ComboBox<String> philosophiePF;

    @FXML
    private ComboBox<String> mathematikPF;

    @FXML
    private ComboBox<String> physikPF;

    @FXML
    private ComboBox<String> chemiePF;

    @FXML
    private ComboBox<String> biologiePF;

    @FXML
    private ComboBox<String> informatikPF;

    @FXML
    private ComboBox<String> sportPF;

    @FXML
    private ComboBox<String> sporttheoriePF;

    @FXML
    private Button bestaetigt;

    ObservableList<String> wahlPF = FXCollections.observableArrayList(
            "1LK",
            "LK",
            "3PK",
            "4PK",
            "5PK"
    );

    public ObservableList<String> erzeugeAuswahlPF(ObservableList<String> wahlPF){

        return wahlPF;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        wahlpruefung = new Wahlpruefung();
    }

    @FXML
    private void onPressed(ActionEvent event) {
        RadioButton btn = (RadioButton) event.getSource();
        boolean val = btn.isSelected();
        int colIndex = GridPane.getColumnIndex(btn);
        int rowIndex = GridPane.getRowIndex(btn);
        Kurs kurs = wahlpruefung.getKursListeElement(rowIndex - 1);
        if (colIndex == 3) {
            kurs.setQ1(val);
        } else if (colIndex == 4) {
            kurs.setQ2(val);
        } else if (colIndex == 5) {
            kurs.setQ3(val);
        } else if (colIndex == 6) {
            kurs.setQ4(val);
        } else {
            System.err.println("Error Button");
        }

        Label lblSemester = (Label) grid.getChildren().filtered(node -> {
            final Integer col = GridPane.getColumnIndex(node);
            return col != null && 7 == GridPane.getColumnIndex(node);
        }).get(rowIndex);

        lblSemester.setText(String.valueOf(kurs.getAnzahlSemester()));
    }

    @FXML
    private void onSelected(ActionEvent event) {
        ComboBox comboBox = (ComboBox) event.getSource();
        String val = (String) comboBox.getValue();
        int rowIndex = GridPane.getRowIndex(comboBox);
        Kurs kurs = wahlpruefung.getKursListeElement(rowIndex - 1);
    }

    @FXML
    void onClicked(MouseEvent event) {
        System.out.println("Clicked!");
        deutschPF.setItems(wahlPF);
    }

}
