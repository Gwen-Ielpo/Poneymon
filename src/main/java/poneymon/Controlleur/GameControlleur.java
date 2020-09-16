package fr.univ_lyon1.info.poneymon.Controlleur;

import fr.univ_lyon1.info.poneymon.Vue.GameDisplay;
import fr.univ_lyon1.info.poneymon.Modele.Game;
import fr.univ_lyon1.info.poneymon.Modele.Obstacle;
import fr.univ_lyon1.info.poneymon.Modele.Runner;
import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javax.swing.JOptionPane;

/**
 * Controlleur de l'application. Contient la boucle principale de l'application.
 */
public class GameControlleur {
    
    private Game game;
    private GameDisplay gameDisplay;
    private String[] colorMap = new String[]{"blue", "green", "orange", "purple", "yellow"};
    private int sop;
    /**
     * Constructeur de GameControlleur et instanciateur de la boucle principale du jeu.
     * @param root Group instancié pour l'affichage.
     * @param scene Scene de la vue principale.
     * @param width Largeur de la fenêtre/terrain.
     * @param heigth Hauteur de la fenêtre/terrain.
     */
    public GameControlleur(Group root, Scene scene, int width, int heigth){
        
        game = new Game(this, width, heigth);
        gameDisplay = new GameDisplay(root, scene, width, heigth, this);
        sop = 0;
        // liaison Runner/RunnerDisplay et init
        for (int i = 0; i < colorMap.length; i++) {
            this.gameDisplay.getFieldDisplay().initRunner(this.game.getField().getRunners().get(i));
            this.game.getField().getRunners().get(i).addObserver(
                    this.gameDisplay.getFieldDisplay().getRunners().get(i));
        }
        
        new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
		gameDisplay.updateButton();
                if(sop == 1){
                // On nettoie le canvas a chaque frame
		        gameDisplay.resetDisplay();
		        
		        ArrayList<Runner> runners = game.getField().getRunners();
		        
		        if (gameDisplay.getInput().contains("SPACE")) {
		            gameDisplay.getInput().remove("SPACE");
		            for (int i = 0; i < runners.size(); i++) {
		                JOptionPane.showMessageDialog(null,
		                    "Distance de " + i + " à 0 : " + runners.get(i).getDistance(0) + "\n"
		                    + "Distance de " + i + " à 1 : " + runners.get(i).getDistance(1) + "\n"
		                    + "Distance de " + i + " à 2 : " + runners.get(i).getDistance(2) + "\n"
		                    + "Distance de " + i + " à 3 : " + runners.get(i).getDistance(3) + "\n"
		                    + "Distance de " + i + " à 4 : " + runners.get(i).getDistance(4) + "\n"
		                );
		            }
		        }
		        
		        game.getField().initObstacles();
		        
		        for (Obstacle obstacle : game.getField().getObstacles()) {
		            if(obstacle != null){
		                obstacle.move();
		            }
		        }

		        // Deplacement et affichage des poneys
		        for (int i = 0; i < runners.size(); i++) {
		            runners.get(i).move();
		        }
		        
		        checkForWinner();
			}
		    }

		    private void checkForWinner() {
		        ArrayList<Runner> runners = game.getField().getRunners();
		        for (int i = 0; i < runners.size(); i++) {
		            if (runners.get(i).getNbTours() >= 5) {
		                this.stop();
		                JOptionPane.showMessageDialog(null,
		                        "Le poney " + i + " a gagné.\n"
		                );
		            }
		        }
		    }
		}.start();
        
    }
    
    /**
     * Détermine la présence d'une entrée clavier dans la liste des inputs.
     * @param s Code de l'entrée clavier à trouver.
     * @return True si l'entrée a été trouvée, false sinon.
     */
    public boolean isInputContains(String s){
        return gameDisplay.getInput().contains(s);
    }
    
    /**
     * Retire une entrée clavier de la liste des inputs.
     * @param s Code de l'entrée clavier à retirer.
     */
    public void removeFromInputs(String s){
        while(gameDisplay.getInput().remove(s)){};
    }

    /**
     * Demande à la vue la création d'un affichage pour cet cet obstacle du modèle.
     * @param obstacle Obstacle dont on veut créer l'affichage.
     */
    public void createObstacleDisplay(Obstacle obstacle) {
        this.gameDisplay.getFieldDisplay().initObstacle(obstacle);
    }

    /**
     * Demande la suppression de la vue du ieme obstacle stocké.
     * @param id Index de l'obstacle dans son conteneur.
     */
    public void deleteObstacleDisplay(int id) {
        this.gameDisplay.getFieldDisplay().deleteObstacleDisplay(id);
    }
    
    /**
     * Setter de la variable représentant l'état de pause du jeu.
     * @param sop Entier représentant la pause du jeu.
     */
    public void setSop(int sop) {
        this.sop = sop;
    }

    /**
     * Getter de la variable représentant l'état de pause du jeu.
     * @return Entier représentant l'état de pause du jeu.
     */
    public int getSop() {
        return sop;
    }
    
}
