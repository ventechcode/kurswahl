package kurswahl.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
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
     * @author Lukas Schenkel
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        wahlpruefung = new Wahlpruefung();
        ersterLK.setItems(FXCollections.observableArrayList("Keine Auswahl",
                "De",
                "En",
                "Fr",
                "Ku",
                "Pw",
                "Ma",
                "Bi"));
        ersterLK.setValue("Keine Auswahl");
        zweiterLK.setItems(FXCollections.observableArrayList("Keine Auswahl",
                "En",
                "Ku",
                "Pw",
                "Ma",
                "Bi",
                "Mu",
                "Ge",
                "Ch",
                "Ph",
                "In"));
        zweiterLK.setValue("Keine Auswahl");
    }

    /**
     * Dropdown Menü wird dynamisch für jedes Klicken auf ein LK-Auswahlfeld erstellt und zurückgegeben
     * @return Drop-Down-Menü-Liste
     * @author Tomás Wagner, Yannick Kandulski
     */
    public ObservableList<String> getLKWahla() {
        System.out.println("lk wahl");
        ObservableList<String> wahlLKEditedA = FXCollections.observableArrayList("Keine Auswahl",
                "De",
                "En",
                "Fr",
                "Ku",
                "Pw",
                "Ma",
                "Bi");

        if (ersterLK.getValue().equals("De") || zweiterLK.getValue().equals("De")) {
            wahlLKEditedA.remove("De");
        }

        if (ersterLK.getValue().equals("En") || zweiterLK.getValue().equals("En")) {
            wahlLKEditedA.remove("En");
        }

        if (ersterLK.getValue().equals("Fr") || zweiterLK.getValue().equals("Fr")) {
            wahlLKEditedA.remove("Fr");
        }

        if (ersterLK.getValue().equals("Ku") || zweiterLK.getValue().equals("Ku")) {
            wahlLKEditedA.remove("Ku");
        }

        if (ersterLK.getValue().equals("Pw") || zweiterLK.getValue().equals("Pw")) {
            wahlLKEditedA.remove("Pw");
        }

        if (ersterLK.getValue().equals("Ma") || zweiterLK.getValue().equals("Ma")) {
            wahlLKEditedA.remove("Ma");
        }

        if (ersterLK.getValue().equals("Bi") || zweiterLK.getValue().equals("Bi")) {
            wahlLKEditedA.remove("Bi");
        }
        return wahlLKEditedA;
    }

    /**
     * Dropdown Menü wird dynamisch für jedes Klicken auf ein LK-Auswahlfeld erstellt und zurückgegeben
     * @return Drop-Down-Menü-Liste
     * @author Tomás Wagner, Yannick Kandulski
     */
    public ObservableList<String> getLKWahlb() {
        System.out.println("lk wahl");
        ObservableList<String> wahlLKEditedB = FXCollections.observableArrayList("Keine Auswahl",
                "En",
                "Ku",
                "Mu",
                "Ge",
                "Pw",
                "Ma",
                "Bi",
                "Ch",
                "Ph",
                "In");

        if (ersterLK.getValue().equals("En") || zweiterLK.getValue().equals("En")) {
            wahlLKEditedB.remove("En");
        }

        if (ersterLK.getValue().equals("Ku") || zweiterLK.getValue().equals("Ku")) {
            wahlLKEditedB.remove("Ku");
        }

        if (ersterLK.getValue().equals("Mu") || zweiterLK.getValue().equals("Mu")) {
            wahlLKEditedB.remove("Mu");
        }

        if (ersterLK.getValue().equals("Ge") || zweiterLK.getValue().equals("Ge")) {
            wahlLKEditedB.remove("Ge");
        }

        if (ersterLK.getValue().equals("Pw") || zweiterLK.getValue().equals("Pw")) {
            wahlLKEditedB.remove("Pw");
        }

        if (ersterLK.getValue().equals("Ma") || zweiterLK.getValue().equals("Ma")) {
            wahlLKEditedB.remove("Ma");
        }

        if (ersterLK.getValue().equals("Bi") || zweiterLK.getValue().equals("Bi")) {
            wahlLKEditedB.remove("Bi");
        }

        if (ersterLK.getValue().equals("Ch") || zweiterLK.getValue().equals("Ch")) {
            wahlLKEditedB.remove("Ch");
        }

        if (ersterLK.getValue().equals("Ph") || zweiterLK.getValue().equals("Ph")) {
            wahlLKEditedB.remove("Ph");
        }

        if (ersterLK.getValue().equals("In") || zweiterLK.getValue().equals("In")) {
            wahlLKEditedB.remove("In");
        }
        return wahlLKEditedB;
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
     * @author Tomás Wagner, Glenn Grubert, Romy Karbstein
     */
    @FXML
    private void onSelected(ActionEvent event) {
        System.out.println("on selected");
        String eLK = ersterLK.getValue();
        String zLK = zweiterLK.getValue();

        if (ersterLK.getValue() == "En" || ersterLK.getValue() == "Fr"){ eLK = "FS"; }
        if (ersterLK.getValue() == "Ch" || ersterLK.getValue() == "Bi" || ersterLK.getValue() == "Ph"){ eLK = "NW"; }
        if (ersterLK.getValue() == "Ge" || ersterLK.getValue() == "Pw"){ eLK = "2. AF";}
        if (ersterLK.getValue() == "Mu" || ersterLK.getValue() == "Ku"){ eLK = "Mu/Ku";}

        if (zweiterLK.getValue() == "En" || zweiterLK.getValue() == "Fr"){ zLK = "FS"; }
        if (zweiterLK.getValue() == "Ch" || zweiterLK.getValue() == "Bi" || zweiterLK.getValue() == "Ph"){ zLK = "NW"; }
        if (zweiterLK.getValue() == "Ge" || zweiterLK.getValue() == "Pw"){ zLK = "2. AF";}
        if (zweiterLK.getValue() == "Mu" || zweiterLK.getValue() == "Ku"){ zLK = "Mu/Ku";}
        //Schienen filtern
        if (!ersterLK.getValue().equals("Keine Auswahl") && (!zweiterLK.getValue().equals("Keine Auswahl")))
        {
            wahlpruefung.schienenFiltern(eLK, zLK);
        }

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

    /**
     * Methode zum Anzeigen des Drop-Down-Menüs, in dem die Leistungskurse ausgewählt werden können.
     * @author Lukas Schenkel, Yannick Kandulski
     */
    @FXML
    private void onClicked(MouseEvent event) {
        System.out.println("on clicked");
        ersterLK.setItems(getLKWahla());
        zweiterLK.setItems(getLKWahlb());
        System.out.println("items set");
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
            Scene mainScene = new Scene(root);
            Main.primaryStage.setScene(mainScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String pruefungsfachNamenKonvertieren(String PF)
    {
        String ret;
        switch(PF){
            case "De":
                ret = "Deutsch";
                break;
            case "Ma":
                ret = "Mathematik";
                break;
            case "Bi": //
                ret = "Biologie";
                break;
            case "In":
                ret = "Informatik";
                break;
            case "Fr":
                ret = "Französisch";
                break;
            case "En":
                ret = "Englisch";
                break;
            case "Pw":
                ret = "Politikwissenschaften";
                break;
            case "Ku":
                ret = "Kunst";
                break;
            case "Mu":
                ret = "Musik";
                break;
            case "Ch":
                ret = "Chemie";
                break;
            case "Ge":
                ret = "Geschichte";
                break;
            case "Ph":
                ret = "Physik";
                break;
            default:
                ret = null;
                break;
        }
        return ret;
    }
}