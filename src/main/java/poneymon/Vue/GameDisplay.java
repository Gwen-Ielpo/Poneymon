package fr.univ_lyon1.info.poneymon.Vue;

import fr.univ_lyon1.info.poneymon.Controlleur.GameControlleur;

import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;

/**
 * Classe de gestion des vues et de l'affichage général du jeu.
 */
public class GameDisplay extends Canvas{
    
    private final GraphicsContext gc;
    private ArrayList<String> input = new ArrayList<>();
    private final FieldDisplay fieldDisplay;
    private GameControlleur gameControlleur;
    
    private Button button;
    private Group root;	
    
    /**
     * Constructeur de GameDisplay.
     * @param root Group instancié pour l'affichage.
     * @param scene Scene de la vue principale.
     * @param width Largeur de la fenêtre/terrain.
     * @param height Hauteur de la fenêtre/terrain.
     * @param gameControlleur GameControlleur associé au jeu courant.
     */
    public GameDisplay(Group root, Scene scene, int width, int height, GameControlleur gameControlleur){  
        super(width, height);
        fieldDisplay = new FieldDisplay(this, width, height);
        this.setFocusTraversable(true);
        
        gc = this.getGraphicsContext2D();
	 this.gameControlleur = gameControlleur;
        
        this.root = root;
        this.button = new Button();
        updateButton();
        this.button.setLayoutX(100);
        this.button.setLayoutY(650);
        button.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                pause();
                        
            }
        });
        
        root.getChildren().add(this);
	root.getChildren().add(this.button);

        scene.setOnKeyPressed(
            new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent e) {
                    String code = e.getCode().toString();
                    e.consume();
                    if (!input.contains(code)) {
                        input.add(code);
                    }
                }
            }
        );
    }

    /**
     * Méthode pour mettre à jour le texte du bouton.
     */
    public void updateButton(){
        if(this.getGameControlleur().getSop() == 1)
            this.button.setText("Pause");
        else
            this.button.setText("Start");
        
    }
    
    /**
     * Méthode gérant la mise en pause du jeu.
     */
    public void pause(){
        if(this.getGameControlleur().getSop() == 1){
            this.getGameControlleur().setSop(0);
        }    
        else
            this.getGameControlleur().setSop(1);
    }
    
    /**
     * Méthode de mise à jour de l'affichage des scores. 
     * Méthode appelée pour chaque Runner ayant notifié un changement de score.
     * @param string Texte à afficher pour les scores
     * @param y Coordonnée y sur laquelle afficher les scores.
     */
    public void updateScore(String string, double y){
        ObservableList<Node> list = root.getChildren();
        for (int i = 0; i< list.size(); i++){
            if(list.get(i) instanceof TextFlow){  
                if(list.get(i).getLayoutY() == 110*(y + 1)){
                    list.remove(i,i+1);
                }    
            }
        }   
        Text text = new Text(string);
        TextFlow textFlow = new TextFlow();
        textFlow.setTextAlignment(TextAlignment.JUSTIFY); 
        textFlow.setLineSpacing(-5); 
        textFlow.setLayoutX(550);
        textFlow.setLayoutY(110*(y + 1));
        
        textFlow.getChildren().add(text);
        root.getChildren().add(textFlow);
    }

    /**
     * Méthode de remise à zéro de l'affichage. 
     * Utilisé chaque tour pour pouvoir redessiner sur le canvas proprement.
     */
    public void resetDisplay(){
        this.gc.setFill(Color.LIGHTGRAY);
        this.gc.fillRect(0, 0, this.fieldDisplay.getWidth(), this.fieldDisplay.getHeight());
    }
        
    /**
     * Getter du contexte graphique courant.
     * @return Le GraphicsContext courant.
     */
    public GraphicsContext getGc(){
        return gc;
    }

    /**
     * Getter de la classe d'affichage du terrain courant.
     * @return Le FieldDisplay courant.
     */
    public FieldDisplay getFieldDisplay() {
        return fieldDisplay;
    }

    /**
     * Getter de la liste des entrées clavier en attente de traitement.
     * @return ArrayList de String contenant les codes des entrées clavier en attente.
     */
    public ArrayList<String> getInput() {
        return input;
    }
  
    /**
     * Getter du controlleur du jeu courant.
     * @return GameControlleur du jeu courant.
     */
    public GameControlleur getGameControlleur() {
        return this.gameControlleur;
    }

    /**
     * Getter du bouton de pause.
     * @return Button correspondant au bouton de pause.
     */
    public Button getButton() {
        return this.button;
    } 
}
