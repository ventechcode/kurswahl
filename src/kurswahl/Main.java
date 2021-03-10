package kurswahl;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * <Klassenkommentar> TODO Klassenkommentar schreiben
 *
 * @main-author TODO Autor eintragen
 */

public class Main extends Application
{

    /**
     * Starten der Anwendung
     * @author TODO Autor eintragen
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
     * TODO Methodenkommentar schreiben
     * @author TODO Autor eintragen
     */
    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("Application started");
    }

    /**
     * Stoppen der Anwendung
     * @author TODO Autor eintragen
     */
    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("Application stopped");
    }

    /**
     * TODO Methodenkommentar schreiben
     * @author TODO Autor eintragen
     */
    public static void main(String[] args) {
        launch(args);
    }
}