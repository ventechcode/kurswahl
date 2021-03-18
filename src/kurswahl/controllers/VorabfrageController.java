package kurswahl.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import kurswahl.Wahlpruefung;
import kurswahl.models.Kurs;
import kurswahl.models.Schiene;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Der VorabfrageController ist im Kontext des Model-View-Controller Prinzips der zuständige Controller für die vorabfrage.fxml view.
 *
 * @main-author Tomás Wagner
 */

public class VorabfrageController implements Initializable {

    @FXML
    private GridPane grid;

    @FXML
    private Label labelNr1;

    @FXML
    private Label labelNr2;

    @FXML
    private Label labelNr3;

    @FXML
    private Label labelErsterLK1;

    @FXML
    private Label labelErsterLK2;

    @FXML
    private Label labelErsterLK3;

    @FXML
    private Label labelZweiterLK1;

    @FXML
    private Label labelZweiterLK2;

    @FXML
    private Label labelZweiterLK3;

    @FXML
    private Label label3PF1;

    @FXML
    private Label label3PF2;

    @FXML
    private Label label3PF3;

    @FXML
    private Label label4PF1;

    @FXML
    private Label label4PF2;

    @FXML
    private Label label4PF3;

    @FXML
    private Label label5PF1;

    @FXML
    private Label label5PF2;

    @FXML
    private Label label5PF3;

    @FXML
    private Label labelDE1;

    @FXML
    private Label labelDE2;

    @FXML
    private Label labelDE3;

    @FXML
    private Label labelKF1;

    @FXML
    private Label labelKF2;

    @FXML
    private Label labelKF3;

    @FXML
    private Label labelFS1;

    @FXML
    private Label labelFS2;

    @FXML
    private Label labelFS3;

    @FXML
    private Label labelGEPW1;

    @FXML
    private Label labelGEPW2;

    @FXML
    private Label labelGEPW3;

    @FXML
    private Label labelMA1;

    @FXML
    private Label labelMA2;

    @FXML
    private Label labelMA3;

    @FXML
    private Label labelNW1;

    @FXML
    private Label labelNW2;

    @FXML
    private Label labelNW3;

    @FXML
    private Label labelPHCH1;

    @FXML
    private Label labelPHCH2;

    @FXML
    private Label labelPHCH3;

    @FXML
    private Label labelKdT1;

    @FXML
    private Label labelKdT2;

    @FXML
    private Label labelKdT3;

    @FXML
    private ComboBox<String> ersterLK;

    @FXML
    private ComboBox<String> zweiterLK;

    /**
     * Initialisierung
     * @author
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //
    }

    /**
     * Dropdown Menü wird dynamisch für jedes Klicken auf ein LK-Auswahlfeld erstellt und zurückgegeben
     * @return Drop-Down-Menü-Liste
     * @author Lukas & Yannick
     */
    public ObservableList<String> getLKWahl() {
//        ObservableList<String> wahlLKEdited = FXCollections.observableArrayList("Keine Auswahl",
//                "LK",
//                "3. PF",
//                "4. PF",
//                "5. PF");
//        if (wahlpruefung.getZweiLKgewaehlt()) {
//            wahlPFEdited.remove("LK");
//        }
//        if (wahlpruefung.getDrittesPFgewaehlt()) {
//            wahlPFEdited.remove("3. PF");
//        }
//        if (wahlpruefung.getViertesPFgewaehlt()) {
//            wahlPFEdited.remove("4. PF");
//        }
//        if (wahlpruefung.getFuenftesPFgewaehlt()) {
//            wahlPFEdited.remove("5. PF");
//        }
//        return wahlLKEdited;
        return null; //kann raus, sobald Methode richtig implementiert wurde
    }

    /**
     * Reagiert auf Auswahl einer CheckBox
     * @param event
     * @author
     */
    @FXML
    private void onPressed(ActionEvent event) {
        //
    }

    /**
     * Methode zur Regelung des Ablaufs bei Wahl eines Kurses als LK aus der entsprechenden ComboBox.
     * @author
     */
    @FXML
    private void onSelected(ActionEvent event) {
        //
    }

    /**
     * Methode zum Anzeigen des Drop-Down-Menüs, in dem die Leistungskurse ausgewählt werden können.
     * @author Lukas Schenkel, Yannick Kandulski
     */
    @FXML
    private void onClicked(MouseEvent event) {
        ComboBox comboBox = (ComboBox) event.getSource();
        comboBox.setItems(getLKWahl());
    }

    /**
     * Methode zur Regelung des Ablaufs bei Klicken des Speichern-Buttons
     * @author
     */
    @FXML
    private void onClickedSave(ActionEvent event) {
        //
    }

    /**
     * Methode zur Regelung des Ablaufs bei Klicken des Bestätigen-Buttons
     * @author
     */
    @FXML
    private void onClickedConfirm(ActionEvent event) {
        //
    }
}
