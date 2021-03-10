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

import java.net.URL;
import java.util.ResourceBundle;

/**
 * <Klassenkommentar> TODO Klassenkommentar schreiben
 *
 * @author Lukas Schenkel, Yannick Kandulski
 */

public class MainController implements Initializable {

    private Wahlpruefung wahlpruefung;

    @FXML
    private GridPane grid;

    @FXML
    private Label gesamtPS;

    @FXML
    private Label gesamtQ1;

    @FXML
    private Label gesamtQ2;

    @FXML
    private Label gesamtQ3;

    @FXML
    private Label gesamtQ4;

    @FXML
    private Label gesamtAnzahl;

    /**
     * Dropdown Menü wird dynamisch für jedes Klicken auf ein PF-Auswahlfeld erstellt und zurückgegeben
     * @return Drop-Down-Menü-Liste
     * @author TODO Autor eintragen
     */
    public ObservableList<String> getPFWahl() {
        ObservableList<String> wahlPFEdited = FXCollections.observableArrayList("Keine Auswahl",
                "LK",
                "3. PF",
                "4. PF",
                "5. PF");
        if (wahlpruefung.getZweiLKgewaehlt()) {
            wahlPFEdited.remove("LK");
        }
        if (wahlpruefung.getDrittesPFgewaehlt()) {
            wahlPFEdited.remove("3. PF");
        }
        if (wahlpruefung.getViertesPFgewaehlt()) {
            wahlPFEdited.remove("4. PF");
        }
        if (wahlpruefung.getFuenftesPFgewaehlt()) {
            wahlPFEdited.remove("5. PF");
        }
        return wahlPFEdited;
    }

    /**
     * Initialisierung
     * @author TODO Autor eintragen
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        wahlpruefung = new Wahlpruefung();
        // Anzeigen der bereits vorhandenen Gesamtanzahl belegter Kurse (durch obligatorisch zu wählenden Kurse)
        gesamtQ1.setText("" + wahlpruefung.semesterGesamtanzahlBerechnen()[0]);
        gesamtQ2.setText("" + wahlpruefung.semesterGesamtanzahlBerechnen()[1]);
        gesamtQ3.setText("" + wahlpruefung.semesterGesamtanzahlBerechnen()[2]);
        gesamtQ4.setText("" + wahlpruefung.semesterGesamtanzahlBerechnen()[3]);
        gesamtAnzahl.setText("" + wahlpruefung.gesamtAnzahlKurseBerechnen());
    }

    /**
     * Reagiert auf Auswahl eines Radio Buttons
     * Es werden weitere Buttons ausgewaehlt die mit der Wahl des urspruenglichen Buttons nun Pflicht sind oder nicht
     * mehr Pflicht sind
     * @param event
     * @author TODO Autor eintragen
     */
    @FXML
    private void onPressed(ActionEvent event) {
        RadioButton btn = (RadioButton) event.getSource();
        boolean val = btn.isSelected();
        int colIndex = GridPane.getColumnIndex(btn);
        int rowIndex = GridPane.getRowIndex(btn);
        Kurs kurs = wahlpruefung.getKursListeElement(rowIndex - 1);

        // Wenn ein Semester eines Kurses ausgewählt wird, wird das dazugehörige zweite ebenfalls ausgewählt:
        if (kurs.getName().equals("Sporttheorie")) // 1. Sonderfall: Wenn das 2. oder 3. Semester Sporttheorie
            // ausgewählt wird, wird das jeweils andere ebenfalls gewählt
        {
            kurs.setQ2(val);
            kurs.setQ3(val);
        }
        else if (kurs.getName().equals("Darstellendes Spiel")) // 2. Sonderfall: Wenn ein Semester DS ausgewählt wird,
            // werden auch alle anderen Semester ausgewählt
        {
            kurs.setQ1(val);
            kurs.setQ2(val);
            kurs.setQ3(val);
            kurs.setQ4(val);
        }
        else
        {
            // Normalfall: alle anderen Kurse (wenn Q1 belegt wird, auch Q2; wenn Q3 belegt wird, auch Q4
            // (und andersherum))
            if (colIndex == 3) {
                kurs.setQ1(val);
                kurs.setQ2(val);
            } else if (colIndex == 4) {
                kurs.setQ2(val);
                kurs.setQ1(val);
            } else if (colIndex == 5) {
                kurs.setQ3(val);
                kurs.setQ4(val);
            } else if (colIndex == 6) {
                kurs.setQ4(val);
                kurs.setQ3(val);
            } else {
                System.err.println("Error Button");
            }
        }

        // Anzeigen der Gesamtanzahl an belegten Semetern pro Kurs:
        grid.getChildren().forEach(node -> {
            final Integer col = GridPane.getColumnIndex(node);
            final Integer row = GridPane.getRowIndex(node);

            if(row != null && col != null) {
                if(rowIndex == row && col == 7) {
                    Label lblSemester = (Label) node;
                    lblSemester.setText(String.valueOf(kurs.getAnzahlSemester()));
                }
            }
        });
        // Aktualisierung der Anzeige der Gesamtanzahl an Semestern in Q1, Q2, Q3, Q4 und der Gesamtanzahl belegter
        // Kurse:
        gesamtQ1.setText("" + wahlpruefung.semesterGesamtanzahlBerechnen()[0]);
        gesamtQ2.setText("" + wahlpruefung.semesterGesamtanzahlBerechnen()[1]);
        gesamtQ3.setText("" + wahlpruefung.semesterGesamtanzahlBerechnen()[2]);
        gesamtQ4.setText("" + wahlpruefung.semesterGesamtanzahlBerechnen()[3]);
        gesamtAnzahl.setText("" + wahlpruefung.gesamtAnzahlKurseBerechnen());
        ueberpruefen();
    }

    /**
     * Methode zur Regelung des Ablaufs und automatischer Eingaben bei Wahl eines Kurses als PF.
     * @author TODO Autor eintragen
     */
    @FXML
    private void onSelected(ActionEvent event) {
        ComboBox comboBox = (ComboBox) event.getSource();
        String val = (String) comboBox.getValue();
        int rowIndex = GridPane.getRowIndex(comboBox);
        Kurs kurs = wahlpruefung.getKursListeElement(rowIndex - 1);
        int pf = stringPFinInt(val);
        kurs.setPruefungsfach(pf);

        // Anzeigen der Pflichtsemester & belegten Semester, wenn ein Kurs als PF ausgewählt wird:
        if(pf == 1) {
            kurs.setAnzahlPflichtsemester(0);
        } else {
            kurs.setAnzahlPflichtsemester(4);
        }

        gesamtPS.setText("" + wahlpruefung.gesamtAnzahlPSberechnen());

        grid.getChildren().forEach(node -> {
            final Integer col = GridPane.getColumnIndex(node);
            final Integer row = GridPane.getRowIndex(node);
            // Anzeigen der Pflichtsemester in der Tabelle:
            if(row != null && col != null) {
                if(rowIndex == row && col == 2) {
                    Label lblPflichtsemester = (Label) node;
                    lblPflichtsemester.setText(String.valueOf(kurs.getAnzahlPflichtsemester()));
                }
                // Anzeigen der 4 ausgewählten Semester:
                if(pf != 1) {
                    // Q1 RadioButton
                    if(rowIndex == row && col == 3) {
                        RadioButton q1 = (RadioButton) node;
                        q1.setSelected(true);
                        kurs.setQ1(true);
                    }
                    // Q2 RadioButton
                    if(rowIndex == row && col == 4) {
                        RadioButton q2 = (RadioButton) node;
                        q2.setSelected(true);
                        kurs.setQ2(true);
                    }
                    // Q3 RadioButton
                    if(rowIndex == row && col == 5) {
                        RadioButton q3 = (RadioButton) node;
                        q3.setSelected(true);
                        kurs.setQ3(true);
                    }
                    // Q4 RadioButton
                    if(rowIndex == row && col == 6) {
                        RadioButton q4 = (RadioButton) node;
                        q4.setSelected(true);
                        kurs.setQ4(true);
                    }
                    if(rowIndex == row && col == 7) {
                        Label lblSemester = (Label) node;
                        lblSemester.setText(String.valueOf(kurs.getAnzahlSemester()));
                    }
                } else {
                    // Q1 RadioButton
                    if(rowIndex == row && col == 3) {
                        RadioButton q1 = (RadioButton) node;
                        q1.setSelected(false);
                        kurs.setQ1(false);
                    }
                    // Q2 RadioButton
                    if(rowIndex == row && col == 4) {
                        RadioButton q2 = (RadioButton) node;
                        q2.setSelected(false);
                        kurs.setQ2(false);
                    }
                    // Q3 RadioButton
                    if(rowIndex == row && col == 5) {
                        RadioButton q3 = (RadioButton) node;
                        q3.setSelected(false);
                        kurs.setQ3(false);
                    }
                    // Q4 RadioButton
                    if(rowIndex == row && col == 6) {
                        RadioButton q4 = (RadioButton) node;
                        q4.setSelected(false);
                        kurs.setQ4(false);
                    }
                    if(rowIndex == row && col == 7) {
                        Label lblSemester = (Label) node;
                        lblSemester.setText(String.valueOf(kurs.getAnzahlSemester()));
                    }
                }
            }
        });
        ueberpruefen();
    }

    /**
     * Methode zum Anzeigen des Drop-Down-Menüs, in dem die PF ausgewählt werden können.
     * @author TODO Autor eintragen
     */
    @FXML
    private void onClicked(MouseEvent event) {
        ComboBox comboBox = (ComboBox) event.getSource();
        comboBox.setItems(getPFWahl());
    }

    /**
     * Ausführung der Wahlprüfung
     * @author TODO Autor eintragen
     */
    private void ueberpruefen() {
        boolean result = wahlpruefung.wahlpruefung();
        if (result) {
            System.out.println("Erfolgreiche Kurswahl!");
        } else { System.out.println("Fail");
        }
    }

    /**
     * @return Node, bei der angegebenen Reihe und Spalte
     * @author TODO Autor eintragen
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

    /**
     * Wandelt den String der Art des Pruefungsfaches in den passenden Integerwert um.
     * @param pruefungsfach - umzuwandelnder String
     * @return - umgewandelter Integer (1-5)
     * @author TODO Autor eintragen
     */
    public int stringPFinInt(String pruefungsfach) {
        int ret = 1;
        switch (pruefungsfach) {
            case "LK":
                ret = 2;
                break;
            case "3. PF":
                ret = 3;
                break;
            case "4. PF":
                ret = 4;
                break;
            case "5. PF":
                ret = 5;
                break;
            default:
                ret = 1;
                break;
        }
        return ret;
    }
}
