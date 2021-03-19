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
 * Der MainController ist im Kontext des Model-View-Controller Prinzips der zuständige Controller für die main.fxml view.
 *
 * @main-author Lukas Schenkel, Yannick Kandulski
 */

public class MainController implements Initializable {

    private Wahlpruefung wahlpruefung;

    private Schiene schiene;

    //wenn das drittePF NW als Pflicht hat wird dieses bei anderen Fächen entfernt
    String PF3SchienenWahl = "bel.";
    String PF4SchienenWahl = "bel.";
    String PF5SchienenWahl = "bel.";

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

    public MainController(Wahlpruefung wahlpruefung) {
        this.wahlpruefung = wahlpruefung;
    }


    /**
     * Dropdown Menü wird dynamisch für jedes Klicken auf ein PF-Auswahlfeld erstellt und zurückgegeben
     * @return Drop-Down-Menü-Liste
     * @author Lukas & Yannick
     */
    public ObservableList<String> getPFWahl(ComboBox combobox) {
        int rowIndex = GridPane.getRowIndex(combobox);
        Kurs kurs = wahlpruefung.getKursListeElement(rowIndex - 1);
        ObservableList<String> wahlPFEdited = FXCollections.observableArrayList("Keine Auswahl",
                "LK",
                "3. PF",
                "4. PF",
                "5. PF");
        if (wahlpruefung.getZweiLKgewaehlt()
        ) {
            wahlPFEdited.remove("LK");
        }
        if (wahlpruefung.getDrittesPFgewaehlt() || ((kursZuSchienenKategorie(kurs)).equals(PF3SchienenWahl))) {
            wahlPFEdited.remove("3. PF");
        }
        if (wahlpruefung.getViertesPFgewaehlt() || ((kursZuSchienenKategorie(kurs)).equals(PF4SchienenWahl))) {
            wahlPFEdited.remove("4. PF");
        }
        if (wahlpruefung.getFuenftesPFgewaehlt() || ((kursZuSchienenKategorie(kurs)).equals(PF5SchienenWahl))) {
            wahlPFEdited.remove("5. PF");
        }
        return wahlPFEdited;
    }

    /**
     * Initialisierung
     * @author Lukas Schenkel, Yannick Kandulski
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
     * mehr Pflicht sind (in bearbeitung)
     * @param event
     * @author Lukas Schenkel, Yannick Kandulski
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
            RadioButton q3 = (RadioButton) getNodeByCoordinate(rowIndex, colIndex + 1);
            q3.setSelected(true);
        }
        else if (kurs.getName().equals("Darstellendes Spiel")) // 2. Sonderfall: Wenn ein Semester DS ausgewählt wird,
            // werden auch alle anderen Semester ausgewählt
        {
            kurs.setQ1(val);
            kurs.setQ2(val);
            kurs.setQ3(val);
            kurs.setQ4(val);
            ((RadioButton) getNodeByCoordinate(rowIndex, 3)).setSelected(true);
            ((RadioButton) getNodeByCoordinate(rowIndex, 4)).setSelected(true);
            ((RadioButton) getNodeByCoordinate(rowIndex, 5)).setSelected(true);
            ((RadioButton) getNodeByCoordinate(rowIndex, 6)).setSelected(true);
        }
        else
        {
            // Normalfall: alle anderen Kurse (wenn Q1 belegt wird, auch Q2; wenn Q3 belegt wird, auch Q4
            // (und andersherum))
            if (colIndex == 3) {
                kurs.setQ1(val);
                kurs.setQ2(val);
                RadioButton q2 = (RadioButton) getNodeByCoordinate(rowIndex, colIndex + 1);
                q2.setSelected(true);
            } else if (colIndex == 4) {
                kurs.setQ2(val);
                kurs.setQ1(val);
                RadioButton q1 = (RadioButton) getNodeByCoordinate(rowIndex, colIndex - 1);
                q1.setSelected(true);
            } else if (colIndex == 5) {
                kurs.setQ3(val);
                kurs.setQ4(val);
                RadioButton q4 = (RadioButton) getNodeByCoordinate(rowIndex, colIndex + 1);
                q4.setSelected(true);
            } else if (colIndex == 6) {
                kurs.setQ4(val);
                kurs.setQ3(val);
                RadioButton q3 = (RadioButton) getNodeByCoordinate(rowIndex, colIndex - 1);
                q3.setSelected(true);
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
     * Methode zur Regelung des Ablaufs bei Wahl eines Kurses als PF aus der entsprechenden ComboBox.
     * @author Lukas Schenkel, Yannick Kandulski
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

        //
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
     * @author Lukas Schenkel, Yannick Kandulski
     */
    @FXML
    private void onClicked(MouseEvent event) {
        ComboBox comboBox = (ComboBox) event.getSource();
        comboBox.setItems(getPFWahl(comboBox));
    }

    /**
     * Ausführung der Wahlprüfung
     * @author Romy Karbstein, Lukas Schenkel
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

    /**
     * Wandelt den String der Art des Pruefungsfaches in den passenden Integerwert um.
     * @param pruefungsfach - umzuwandelnder String
     * @return - umgewandelter Integer (1-5)
     * @author Romy Karbstein, Glenn Grubert
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

    /**
     * Durch die Auswahl der Schiene, erfolgen automatisiert verpflichtende Eingaben in der Tabelle.
     * @param indexDerSchiene ausgewählte Schiene
     * @author Tomás Wagner, Yannick Kandulski
     */
    public void eingabenDurchSchieneVornehmen(int indexDerSchiene) {
        Schiene schiene = wahlpruefung.getSchienenListeElement(indexDerSchiene - 1);

        switch (schiene.getDrittesPF()) {
            case "NW":
                PF3SchienenWahl = "NW";
                break;
            case "Mu/Ku":
                PF3SchienenWahl = "MU/KU";
                break;
            case "FS":
                PF3SchienenWahl = "FS";
                break;
            case "2. AF":
                PF3SchienenWahl = "2. AF";
                break;
            case "Ma":
                mathematikPF.setValue("3. PF");
                select(deutschPF);
                break;
            case "In":
                informatikPF.setValue("3. PF");
                select(informatikPF);
                break;
            case "De":
                deutschPF.setValue("3. PF");
                select(deutschPF);
                break;
            case "bel.":
                break;
            default:
                System.out.println("ERROR: eingabenDurchSchieneVornehmen fehlgeschlagen");
        }

        switch (schiene.getViertesPF()) {
            case "NW":
                PF4SchienenWahl = "NW";
                break;
            case "Mu/Ku":
                PF4SchienenWahl = "MU/KU";
                break;
            case "FS":
                PF4SchienenWahl = "FS";
                break;
            case "2. AF":
                PF4SchienenWahl = "2. AF";
                break;
            case "Ma":
                mathematikPF.setValue("3. PF");
                select(deutschPF);
                break;
            case "In":
                informatikPF.setValue("3. PF");
                select(informatikPF);
                break;
            case "De":
                deutschPF.setValue("3. PF");
                select(deutschPF);
                break;
            case "bel.":
                break;
            default:
                System.out.println("ERROR: eingabenDurchSchieneVornehmen fehlgeschlagen");
        }

        switch (schiene.getFuenftesPF()) {
            case "NW":
                PF5SchienenWahl = "NW";
                break;
            case "Mu/Ku":
                PF5SchienenWahl = "MU/KU";
                break;
            case "FS":
                PF5SchienenWahl = "FS";
                break;
            case "2. AF":
                PF5SchienenWahl = "2. AF";
                break;
            case "Ma":
                mathematikPF.setValue("3. PF");
                select(deutschPF);
                break;
            case "In":
                informatikPF.setValue("3. PF");
                select(informatikPF);
                break;
            case "De":
                deutschPF.setValue("3. PF");
                select(deutschPF);
                break;
            case "bel.":
                break;
            default:
                System.out.println("ERROR: eingabenDurchSchieneVornehmen fehlgeschlagen");
        }
    }

    /**
     *
     * @param combo
     * @author Yannick Kandulski
     */
    private void select(ComboBox combo) {
        ComboBox comboBox = combo;
        String val = (String) comboBox.getValue();

        int pf = stringPFinInt(val);

        int rowIndex = GridPane.getRowIndex(comboBox);
        Kurs kurs = wahlpruefung.getKursListeElement(rowIndex - 1);

        //
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
        gesamtPS.setText("" + wahlpruefung.gesamtAnzahlPSberechnen());
        ueberpruefen();
    }

    /**
     * Gibt den Ausdruck in den Schienen für Kursfächer aus, welcher zur überprüfung der Einhaltung der Schinen dient
     * @param kurs
     * @return Kursname in Schienenformat
     * @author Yannick Kandulski
     */
    public String kursZuSchienenKategorie(Kurs kurs){
        String s = kurs.getName();
        if (s.equals("Englisch") || s.equals("Französisch") || s.equals("Latein")){
            return "FS";
        }
        if (s.equals("Physik") || s.equals("Chemie") || s.equals("Biologie")){
            return "NW";
        }
        if (s.equals("Musik") || s.equals("Bildende Kunst")){
            return "MU/KU";
        } else{
            return "2. AF";
        }
    }
}
