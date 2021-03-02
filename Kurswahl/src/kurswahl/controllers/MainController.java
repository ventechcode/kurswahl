package kurswahl.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.ComboBox;
import javafx.scene.input.ContextMenuEvent;
import kurswahl.Funktionalitaet;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;
import kurswahl.models.Kurs;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    private Funktionalitaet funktionalitaet;

    ObservableList<String> wahlPF = FXCollections.observableArrayList(
            "1LK",
            "2LK",
            "3PK",
            "4PK",
            "5PK"
    );

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        funktionalitaet = new Funktionalitaet();
        deutschPF.setItems(lkPFWahl);
    }

    ObservableList lkPFWahl = FXCollections.observableArrayList(
            "1LK",
            "2LK",
            "3PK",
            "4PK",
            "5PK"
            );

    
    /*
    * moegliche LK Faecher
    *
    * */

    @FXML
    private ComboBox<String> deutschPF, englishPF, franzoesischPF, lateinPF, musikPF,bildendekunstPF,darstellendesspielPF;

    @FXML
    private ComboBox<String> politikwissenschaftenPF, geschichtePF, geographiePF, philosophiePF;

    @FXML
    private ComboBox<String> mathematikPF, physikPF, chemie, biologiePF, informatikPF, sportPF, sporttheoriePF;

    @FXML
    private Button bestaetigt;

    @FXML
    private void onPressed(ActionEvent event) {
        RadioButton btn = (RadioButton) event.getSource();
        boolean val = btn.isSelected();
        System.out.println("val: " + val);
        int colIndex = GridPane.getColumnIndex(btn);
        int rowIndex = GridPane.getRowIndex(btn);
        Kurs kurs = funktionalitaet.getKursListeElement(rowIndex - 1);
        if(colIndex == 3) {
            kurs.setQ1(val);
        } else if(colIndex == 4) {
            kurs.setQ2(val);
        } else if(colIndex == 5) {
            kurs.setQ3(val);
        } else if (colIndex == 6){
            kurs.setQ4(val);
        } else {
            System.err.println("Error Button");
        }
        System.out.println(kurs.toString());
    }

    @FXML
    private void onSelected(ActionEvent event) {
        ComboBox comboBox = (ComboBox) event.getSource();
        String val = (String) comboBox.getValue();
        System.out.println("selected val: " + val);
        int rowIndex = GridPane.getRowIndex(comboBox);
        Kurs kurs = funktionalitaet.getKursListeElement(rowIndex - 1);
        System.out.println("Reached!!");
    }

    //
    @FXML
    void onClicked(ContextMenuEvent event) {
        ComboBox comboBox = (ComboBox) event.getSource();
        System.out.println("Clicked!");

        //System.out.println(comboBox.getValue());
    }

}
