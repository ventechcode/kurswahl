package kurswahl;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Die Klasse repräsentiert den Einstiegspunkt in das Programm.
 *
 * @main-author Lukas Schenkel
 */

public class Main extends Application
{

    /**
     * Starten der Anwendung
     * @author Lukas Schenkel
     */
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Kurswahl");

        Parent root = FXMLLoader.load(getClass().getResource("views/main.fxml"));

        primaryStage.setScene(new Scene(root, 1280, 920));
        primaryStage.show();
    }

    /**
     * @author Lukas Schenkel
     */
    public static void main(String[] args) {
        launch(args);
    }
}