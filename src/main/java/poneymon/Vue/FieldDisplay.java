package fr.univ_lyon1.info.poneymon.Vue;

import fr.univ_lyon1.info.poneymon.Modele.Obstacle;
import fr.univ_lyon1.info.poneymon.Modele.Runner;
import java.util.ArrayList;

/**
 * Classe d'affichage des données relatives au terrain et de gestion de la vue des entitées courantes.
 */
public class FieldDisplay {
    static int width;
    static int height;
    
    private ArrayList<RunnerDisplay> runners;
    private ArrayList<ObstacleDisplay> obstacles;
    
    private final GameDisplay gd; 
    
    /**
     * Constructeur de FieldDisplay.
     * @param gd GameDisplay courant du jeu.
     * @param w Largeur du terrain.
     * @param h Hauteur du terrain.
     */
    FieldDisplay(GameDisplay gd, int w, int h){
        width = w;
        height = h;
        this.gd = gd;
        runners = new ArrayList<>();
        obstacles = new ArrayList<>();
    }
    
    /**
     * Méthode d'initialisation de l'affichage d'un Runner.
     * @param r Runner sur lequel créer l'affichage.
     */
    public void initRunner(Runner r){
        RunnerDisplay rd = new RunnerDisplay(this);
        rd.init(r);
        runners.add(rd);
    }
    
    /**
     * Getter de la largeur du terrain.
     * @return Largeur du terrain.
     */
    public int getWidth(){
        return width;
    }
    
    /**
     * Getter de la hauteur du terrain.
     * @return Hauteur du terrain.
     */
    public int getHeight(){
        return height;
    }
    
    /**
     * Getter de la liste des affichages des Runners.
     * @return ArrayList contant les RunnerDisplay instanciés.
     */
    public ArrayList<RunnerDisplay> getRunners(){
        return runners;
    }
    
    /**
     * Getter du GameDisplay courant.
     * @return GameDisplay courant.
     */
    public GameDisplay getGd() {
        return gd;
    }

    /**
     * Méthode d'initialisation de la vue d'un obstacle.
     * @param obstacle Obstacle sur lequel créer la vue.
     */
    public void initObstacle(Obstacle obstacle) {
        ObstacleDisplay od = new ObstacleDisplay(this);
        od.init(obstacle);
        obstacle.addObserver(od);
        this.obstacles.add(od);
    }

    /**
     * Méthode de suppression d'un vue d'obstacle.
     * @param id Index de l'obstacle dans la liste des obstacle.
     */
    public void deleteObstacleDisplay(int id) {
        this.obstacles.set(id, null);
    }
}
