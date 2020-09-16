package fr.univ_lyon1.info.poneymon.Controlleur;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Classe principale de l'application.
 */
public class App extends Application {

    /**
     * Lanceur de l'application JavaFX.
     */
    @Override
    public void start(Stage stage) throws Exception {
        // Nom de la fenetre
        stage.setTitle("Poneymon");

        Group root = new Group();
        Scene scene = new Scene(root);
        
        // On cree le terrain de jeu et on l'ajoute a la racine de la scene
        GameControlleur gameController = new GameControlleur(root, scene, 800, 800);
     
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Méthode Main appellant le lanceur de l'application.
     * @param args Arguments de lancement.
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Application.launch(args);
    }
}
