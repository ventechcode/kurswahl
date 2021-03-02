package kurswahl;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
    private Funktionalitaet funktionalitaet;
    private Wahlpruefung wahlpruefung;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Kurswahl");

        Parent root = FXMLLoader.load(getClass().getResource("view/main.fxml"));

        primaryStage.setScene(new Scene(root, 1280, 920));
        primaryStage.show();

        // Erstellung von Objekten der Klasse Funktionalitaet und Wahlpruefung + Übergabe Referenzen
        funktionalitaet = new Funktionalitaet();
        wahlpruefung = new Wahlpruefung();
        funktionalitaet.setWahlpruefung(wahlpruefung);
        wahlpruefung.setFunktionalitaet(funktionalitaet);
    }

    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("Application started");
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("Application stopped");
    }

    public static void main(String[] args) {
        launch(args);
    }

}
