package kurswahl;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Die Klasse repräsentiert den Einstiegspunkt in das Programm.
 * @main-author Lukas Schenkel
 */

public class Main extends Application
{

    public static Stage primaryStage;

    /**
     * Starten der Anwendung
     * @author Lukas Schenkel
     */
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Main.primaryStage = primaryStage;
        primaryStage.setTitle("Oberstufenkurswahl am Leibniz Gymnasium");

        Parent vorabfrage = FXMLLoader.load(getClass().getResource("views/vorabfrage.fxml"));
        Scene vorabfrageScene = new Scene(vorabfrage, 960, 670);
        primaryStage.setScene(vorabfrageScene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * @author Lukas Schenkel
     */
    public static void main(String[] args) {
        launch(args);
    }
}