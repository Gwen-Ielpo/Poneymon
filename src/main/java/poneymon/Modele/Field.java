/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_lyon1.info.poneymon.Modele;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe représentant le terrain de course des Runners.
 */
public class Field {
    private ArrayList<Runner> runners;
    private ArrayList<Obstacle> obstacles;
    private Game game;
    private int width;
    private int height;

    /**
     * Constructeur de Field.
     * @param game Game associé au terrain en cronstruction.
     * @param width Largeur du terrain.
     * @param height Hauteur du terrain.
     */
    public Field(Game game, int width, int height) {
        this.game = game;
        this.width = width;
        this.height = height;
        String[] colorMap = new String[]{"blue", "green", "orange", "purple", "yellow"};
        
        RunnerFactory rf = new RunnerFactory();
        runners = new ArrayList<>();
        
        for (int i = 0; i < colorMap.length; i++) {
            if(i < 2)
                this.runners.add(rf.createRunner("nyanponey", this, 
                        new String[]{colorMap[i], Integer.toString(i*Runner.spaceBetweenRunners), "human", "human"}));
            else
                this.runners.add(rf.createRunner("nyanponey", this, 
                        new String[]{colorMap[i], Integer.toString(i*Runner.spaceBetweenRunners), "ai", "ai"}));
        }
        
        for (int i = 0; i < colorMap.length; i++) {
            this.runners.get(i).completeInit();
        }
        
        this.obstacles = new ArrayList<>();
        for (int i = 0; i < this.runners.size(); i++) {
            this.obstacles.add(null);
        }
    }    

    /**
     * Getter de la liste de Runner du Field.
     * @return ArrayList contenant les Runners présents sur le Field.
     */
    public ArrayList<Runner> getRunners() {
        return runners;
    }

    /**
     * Getter de la largeur du Field.
     * @return Largeur du terrain.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Getter de la hauteur du Field.
     * @return Hauteur du terrain.
     */
    public int getHeight() {
        return height;
    }
    
    /**
     * Getter de Game associé au Field.
     * @return Game lié au Field.
     */
    public Game getGame() {
        return game;
    }
    
    /**
     * Getter de la liste de Obstacle du Field.
     * @return ArrayList contenant les Obstacle présents sur le Field.
     */
    public ArrayList<Obstacle> getObstacles() {
        return obstacles;
    }

    /**
     * Méthode d'initialisation des obstacles, appelée à chaque frame. 
     * Pour chaque Runner présent, détermine aléatoirement s'il faut créer un obstacle sur sa ligne.
     * Détermine ensuite, si création, le type de l'obstacle et l'initialise.
     * Enfin, demande au GameControlleur d'initialiser la vue de l'obstacle.
     */
    public void initObstacles() {
        String[] types = new String[]{"sleepy", "grumpy"};
        String[] ressources = new String[]{"assets/rainbow_dash.png", "assets/rainbow_dash.png"};
        
        Random randomGenerator = new Random();
        ObstacleFactory of = new ObstacleFactory();
        
        for (int i = 0; i < this.runners.size(); i++) {
            if(randomGenerator.nextInt(100) == 0 && this.obstacles.get(i) == null){
                int rn = randomGenerator.nextInt(2);
                this.obstacles.set(i, of.createObstacle(types[rn], 
                    new String[]{Integer.toString(i*Runner.spaceBetweenRunners), ressources[rn]}));
                this.getGame().getGameControlleur().createObstacleDisplay(this.obstacles.get(i));
            }
        }
    }

    /**
     * Méthode de suppression de l'obstacle à un index déterminé.
     * @param id Index de l'obstacle à supprimer.
     */
    void clearObstacle(int id) {
        this.game.getGameControlleur().deleteObstacleDisplay(id);
        this.obstacles.set(id, null);
    }
}
