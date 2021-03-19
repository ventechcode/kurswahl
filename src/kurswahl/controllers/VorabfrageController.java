package kurswahl.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import kurswahl.Main;
import kurswahl.Wahlpruefung;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Der VorabfrageController ist im Kontext des Model-View-Controller Prinzips der zuständige Controller für die vorabfrage.fxml view.
 *
 * @main-author Tomás Wagner, Lukas Schenkel
 */

public class VorabfrageController implements Initializable {

    private Wahlpruefung wahlpruefung;

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

    @FXML
    private CheckBox checkBoxSchiene1;

    @FXML
    private CheckBox checkBoxSchiene2;

    @FXML
    private CheckBox checkBoxSchiene3;

    /**
     * Initialisierung
     * @author Lukas Schenkel
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        wahlpruefung = new Wahlpruefung();
        ersterLK.setItems(FXCollections.observableArrayList("Keine Auswahl",
                "Deutsch",
                "Englisch",
                "Französisch",
                "Kunst",
                "Politikwissenschaften",
                "Mathematik",
                "Biologie"));
        ersterLK.setValue("Keine Auswahl");
        zweiterLK.setItems(FXCollections.observableArrayList("Keine Auswahl",
                "Englisch",
                "Kunst",
                "Politikwissenschaften",
                "Mathematik",
                "Biologie",
                "Musik",
                "Geschichte",
                "Chemie",
                "Physik",
                "Informatik"));
        zweiterLK.setValue("Keine Auswahl");
    }

    /**
     * Dropdown Menü wird dynamisch für jedes Klicken auf ein LK-Auswahlfeld erstellt und zurückgegeben
     * @return Drop-Down-Menü-Liste
     * @author Tomás Wagner
     */
    public ObservableList<String> getLKWahlA() {
        ObservableList<String> wahlLKEditedA = FXCollections.observableArrayList("Keine Auswahl",
                "Deutsch",
                "Englisch",
                "Französisch",
                "Kunst",
                "Politikwissenschaften",
                "Mathematik",
                "Biologie");

        if (ersterLK.getValue() == "Deutsch" || zweiterLK.getValue() == "Deutsch") {
            wahlLKEditedA.remove("Deutsch");
        }

        if (ersterLK.getValue() == "Englisch" || zweiterLK.getValue() == "Englisch") {
            wahlLKEditedA.remove("En");
        }

        if (ersterLK.getValue() == "Französisch" || zweiterLK.getValue() == "Französisch") {
            wahlLKEditedA.remove("Französisch");
        }

        if (ersterLK.getValue() == "Kunst" || zweiterLK.getValue() == "Kunst") {
            wahlLKEditedA.remove("Kunst");
        }

        if (ersterLK.getValue() == "Politikwissenschaften" || zweiterLK.getValue() == "Politikwissenschaften") {
            wahlLKEditedA.remove("Politikwissenschaften");
        }

        if (ersterLK.getValue() == "Mathematik" || zweiterLK.getValue() == "Mathematik") {
            wahlLKEditedA.remove("Mathematik");
        }

        if (ersterLK.getValue() == "Biologie" || zweiterLK.getValue() == "Biologie") {
            wahlLKEditedA.remove("Biologie");
        }
        return wahlLKEditedA;
    }

    /**
     * Dropdown Menü wird dynamisch für jedes Klicken auf ein LK-Auswahlfeld erstellt und zurückgegeben
     * @return Drop-Down-Menü-Liste
     * @author Tomás Wagner
     */
    public ObservableList<String> getLKWahlB() {
        ObservableList<String> wahlLKEditedB = FXCollections.observableArrayList("Keine Auswahl",
                "Englisch",
                "Kunst",
                "Musik",
                "Geschichte",
                "Politikwissenschaften",
                "Mathematik",
                "Biologie",
                "Chemie",
                "Physik",
                "Informatik");
        if (ersterLK.getValue() == "Englisch" || zweiterLK.getValue() == "Englisch") {
            wahlLKEditedB.remove("Englisch");
        }

        if (ersterLK.getValue() == "Kunst" || zweiterLK.getValue() == "Kunst") {
            wahlLKEditedB.remove("Kunst");
        }

        if (ersterLK.getValue() == "Musik" || zweiterLK.getValue() == "Musik") {
            wahlLKEditedB.remove("Musik");
        }

        if (ersterLK.getValue() == "Geschichte" || zweiterLK.getValue() == "Geschichte") {
            wahlLKEditedB.remove("Geschichte");
        }

        if (ersterLK.getValue() == "Politikwissenschaften" || zweiterLK.getValue() == "Politikwissenschaften") {
            wahlLKEditedB.remove("Politikwissenschaften");
        }

        if (ersterLK.getValue() == "Mathematik" || zweiterLK.getValue() == "Mathematik") {
            wahlLKEditedB.remove("Mathematik");
        }

        if (ersterLK.getValue() == "Biologie" || zweiterLK.getValue() == "Biologie") {
            wahlLKEditedB.remove("Biologie");
        }

        if (ersterLK.getValue() == "Chemie" || zweiterLK.getValue() == "Chemie") {
            wahlLKEditedB.remove("Chemie");
        }

        if (ersterLK.getValue() == "Physik" || zweiterLK.getValue() == "Physik") {
            wahlLKEditedB.remove("Physik");
        }

        if (ersterLK.getValue() == "Informatik" || zweiterLK.getValue() == "Informatik") {
            wahlLKEditedB.remove("Informatik");
        }
        return wahlLKEditedB;
    }

    /**
     * Reagiert auf Auswahl einer CheckBox
     * @param event
     * @author Tomás Wagner
     */
    @FXML
    private void onPressed(ActionEvent event) {
        CheckBox box = (CheckBox) event.getSource();
        int rowIndex = GridPane.getRowIndex(box);

        if(rowIndex == 1 && labelNr1.getText() != "-"){
            checkBoxSchiene1.setSelected(true);
            checkBoxSchiene2.setSelected(false);
            checkBoxSchiene3.setSelected(false);
        }

        if(rowIndex == 2 && labelNr2.getText() != "-"){
            checkBoxSchiene1.setSelected(false);
            checkBoxSchiene2.setSelected(true);
            checkBoxSchiene3.setSelected(false);
        }

        if(rowIndex == 3 && labelNr3.getText() != "-"){
            checkBoxSchiene1.setSelected(false);
            checkBoxSchiene2.setSelected(false);
            checkBoxSchiene3.setSelected(true);
        }
    }

    /**
     * Methode zur Regelung des Ablaufs bei Klicken des Speichern-Buttons
     * @author Tomás Wagner, Glenn Grubert, Romy Karbstein
     */
    @FXML
    private void onClickedSave(ActionEvent event) {
        tabelleLeeren();

        String eLK = ersterLK.getValue();
        String zLK = zweiterLK.getValue();

        if (ersterLK.getValue() == "Englisch" || ersterLK.getValue() == "Französisch"){ eLK = "FS"; }
        if (ersterLK.getValue() == "Chemie" || ersterLK.getValue() == "Biologie" || ersterLK.getValue() == "Physik"){ eLK = "NW"; }
        if (ersterLK.getValue() == "Geschichte" || ersterLK.getValue() == "Politikwissenschaften"){ eLK = "2. AF";}
        if (ersterLK.getValue() == "Musik" || ersterLK.getValue() == "Kunst"){ eLK = "MU/KU";}
        if (ersterLK.getValue() == "Deutsch"){ eLK = "DE"; }
        if (ersterLK.getValue() == "Mathematik"){ eLK = "MA"; }
        if (ersterLK.getValue() == "Informatik"){ eLK = "IN"; }

        if (zweiterLK.getValue() == "Englisch" || zweiterLK.getValue() == "Französisch"){ zLK = "FS"; }
        if (zweiterLK.getValue() == "Chemie" || zweiterLK.getValue() == "Biologie" || zweiterLK.getValue() == "Physik"){ zLK = "NW"; }
        if (zweiterLK.getValue() == "Geschichte" || zweiterLK.getValue() == "Politikwissenschaften"){ zLK = "2. AF";}
        if (zweiterLK.getValue() == "Musik" || zweiterLK.getValue() == "Kunst"){ zLK = "MU/KU";}
        if (zweiterLK.getValue() == "Deutsch"){ zLK = "DE"; }
        if (zweiterLK.getValue() == "Mathematik"){ zLK = "MA"; }
        if (zweiterLK.getValue() == "Informatik"){ zLK = "IN"; }


        //Schienen filtern
        if (ersterLK.getValue() != "Keine Auswahl" && (zweiterLK.getValue() != "Keine Auswahl"))
        {
            wahlpruefung.schienenFiltern(eLK, zLK);


            //Schienen in Tabelle anzeigen
            if(wahlpruefung.getPassendeSchienenListeElement(0) != null) {
                labelNr1.setText(String.valueOf(wahlpruefung.getPassendeSchienenListeElement(0).getNr()));
                labelErsterLK1.setText(wahlpruefung.getPassendeSchienenListeElement(0).getErsterLK());
                labelZweiterLK1.setText(wahlpruefung.getPassendeSchienenListeElement(0).getZweiterLK());
                label3PF1.setText(wahlpruefung.getPassendeSchienenListeElement(0).getDrittesPF());
                label4PF1.setText(wahlpruefung.getPassendeSchienenListeElement(0).getViertesPF());
                label5PF1.setText(wahlpruefung.getPassendeSchienenListeElement(0).getFuenftesPF());
                labelDE1.setText(String.valueOf(wahlpruefung.getPassendeSchienenListeElement(0).getDe()));
                labelKF1.setText(String.valueOf(wahlpruefung.getPassendeSchienenListeElement(0).getKf()));
                labelFS1.setText(String.valueOf(wahlpruefung.getPassendeSchienenListeElement(0).getFs()));
                labelGEPW1.setText(String.valueOf(wahlpruefung.getPassendeSchienenListeElement(0).getGePw()));
                labelMA1.setText(String.valueOf(wahlpruefung.getPassendeSchienenListeElement(0).getMa()));
                labelNW1.setText(String.valueOf(wahlpruefung.getPassendeSchienenListeElement(0).getNw()));
                labelPHCH1.setText(String.valueOf(wahlpruefung.getPassendeSchienenListeElement(0).getPhCh()));
                labelKdT1.setText(String.valueOf(wahlpruefung.getPassendeSchienenListeElement(0).getTauschmoeglichkeiten()));
            }

            if(wahlpruefung.getPassendeSchienenListeElement(1) != null) {
                labelNr2.setText(String.valueOf(wahlpruefung.getPassendeSchienenListeElement(1).getNr()));
                labelErsterLK2.setText(wahlpruefung.getPassendeSchienenListeElement(1).getErsterLK());
                labelZweiterLK2.setText(wahlpruefung.getPassendeSchienenListeElement(1).getZweiterLK());
                label3PF2.setText(wahlpruefung.getPassendeSchienenListeElement(1).getDrittesPF());
                label4PF2.setText(wahlpruefung.getPassendeSchienenListeElement(1).getViertesPF());
                label5PF2.setText(wahlpruefung.getPassendeSchienenListeElement(1).getFuenftesPF());
                labelDE2.setText(String.valueOf(wahlpruefung.getPassendeSchienenListeElement(1).getDe()));
                labelKF2.setText(String.valueOf(wahlpruefung.getPassendeSchienenListeElement(1).getKf()));
                labelFS2.setText(String.valueOf(wahlpruefung.getPassendeSchienenListeElement(1).getFs()));
                labelGEPW2.setText(String.valueOf(wahlpruefung.getPassendeSchienenListeElement(1).getGePw()));
                labelMA2.setText(String.valueOf(wahlpruefung.getPassendeSchienenListeElement(1).getMa()));
                labelNW2.setText(String.valueOf(wahlpruefung.getPassendeSchienenListeElement(1).getNw()));
                labelPHCH2.setText(String.valueOf(wahlpruefung.getPassendeSchienenListeElement(1).getPhCh()));
                labelKdT2.setText(String.valueOf(wahlpruefung.getPassendeSchienenListeElement(1).getTauschmoeglichkeiten()));
            }

            if(wahlpruefung.getPassendeSchienenListeElement(2) != null) {
                labelNr3.setText(String.valueOf(wahlpruefung.getPassendeSchienenListeElement(2).getNr()));
                labelErsterLK3.setText(wahlpruefung.getPassendeSchienenListeElement(2).getErsterLK());
                labelZweiterLK3.setText(wahlpruefung.getPassendeSchienenListeElement(2).getZweiterLK());
                label3PF3.setText(wahlpruefung.getPassendeSchienenListeElement(2).getDrittesPF());
                label4PF3.setText(wahlpruefung.getPassendeSchienenListeElement(2).getViertesPF());
                label5PF3.setText(wahlpruefung.getPassendeSchienenListeElement(2).getFuenftesPF());
                labelDE3.setText(String.valueOf(wahlpruefung.getPassendeSchienenListeElement(2).getDe()));
                labelKF3.setText(String.valueOf(wahlpruefung.getPassendeSchienenListeElement(2).getKf()));
                labelFS3.setText(String.valueOf(wahlpruefung.getPassendeSchienenListeElement(2).getFs()));
                labelGEPW3.setText(String.valueOf(wahlpruefung.getPassendeSchienenListeElement(2).getGePw()));
                labelMA3.setText(String.valueOf(wahlpruefung.getPassendeSchienenListeElement(2).getMa()));
                labelNW3.setText(String.valueOf(wahlpruefung.getPassendeSchienenListeElement(2).getNw()));
                labelPHCH3.setText(String.valueOf(wahlpruefung.getPassendeSchienenListeElement(2).getPhCh()));
                labelKdT3.setText(String.valueOf(wahlpruefung.getPassendeSchienenListeElement(2).getTauschmoeglichkeiten()));
            }
        }
    }

    public void tabelleLeeren()
    {
        labelNr1.setText("-");
        labelErsterLK1.setText("-");
        labelZweiterLK1.setText("-");
        label3PF1.setText("-");
        label4PF1.setText("-");
        label5PF1.setText("-");
        labelDE1.setText("-");
        labelKF1.setText("-");
        labelFS1.setText("-");
        labelGEPW1.setText("-");
        labelMA1.setText("-");
        labelNW1.setText("-");
        labelPHCH1.setText("-");
        labelKdT1.setText("-");

        labelNr2.setText("-");
        labelErsterLK2.setText("-");
        labelZweiterLK2.setText("-");
        label3PF2.setText("-");
        label4PF2.setText("-");
        label5PF2.setText("-");
        labelDE2.setText("-");
        labelKF2.setText("-");
        labelFS2.setText("-");
        labelGEPW2.setText("-");
        labelMA2.setText("-");
        labelNW2.setText("-");
        labelPHCH2.setText("-");
        labelKdT2.setText("-");

        labelNr3.setText("-");
        labelErsterLK3.setText("-");
        labelZweiterLK3.setText("-");
        label3PF3.setText("-");
        label4PF3.setText("-");
        label5PF3.setText("-");
        labelDE3.setText("-");
        labelKF3.setText("-");
        labelFS3.setText("-");
        labelGEPW3.setText("-");
        labelMA3.setText("-");
        labelNW3.setText("-");
        labelPHCH3.setText("-");
        labelKdT3.setText("-");
    }

    /**
     * Methode zum Anzeigen des oberen Drop-Down-Menüs, in dem die Leistungskurse ausgewählt werden können.
     * @author Lukas Schenkel, Yannick Kandulski
     */
    @FXML
    private void onClickedA(MouseEvent event) {
        ersterLK.setItems(getLKWahlA());

    }

    /**
     * Methode zum Anzeigen des unteren Drop-Down-Menüs, in dem die Leistungskurse ausgewählt werden können.
     * @author Lukas Schenkel, Yannick Kandulski
     */
    @FXML
    private void onClickedB(MouseEvent event) {
        zweiterLK.setItems(getLKWahlB());
    }

    /**
     * Methode zur Regelung des Ablaufs bei Klicken des Bestätigen-Buttons
     * @author Lukas Schenkel
     */
    @FXML
    private void onClickedConfirm(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("views/main.fxml"));
            MainController controller = new MainController(wahlpruefung);
            loader.setController(controller);
            Parent root = loader.load();
            Scene mainScene = new Scene(root,1295,750);
            Main.primaryStage.setScene(mainScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return Node, bei der angegebenen Reihe und Spalte
     * @author Yannick Kandulski
     */
    public Node getNodeByCoordinate(Integer row, Integer column) {
        if(row != null && column != null) {
            for (Node node : grid.getChildren()) {
                if(GridPane.getRowIndex(node) != null && GridPane.getColumnIndex(node) != null){
                    if(GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column){
                        return node;
                    }
                }
            }
        }
        return null;
    }
}