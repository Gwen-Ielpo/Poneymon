/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_lyon1.info.poneymon.Vue;

import fr.univ_lyon1.info.poneymon.Modele.Obstacle;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.image.Image;

/**
 * Classe d'affichage des Obstalces.
 */
public class ObstacleDisplay implements Observer{
    Image obstacleImage;
    final FieldDisplay fd; 
    
    /**
     * Constructeur de ObstacleDisplay.
     * @param fd FieldDisplay courant du jeu.
     */
    public ObstacleDisplay(FieldDisplay fd) {
        this.fd = fd;
    }
    
    /**
     * Méthode de mise à jour des données (pattern Observer).
     * @param o Observable (Obstacle) surveillé ayant envoyé une notification.
     * @param arg Arguments de la notification.
     */
    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof Obstacle){
            if(arg != null){
                obstacleImage = new Image((String) arg);
            }
            this.display((Obstacle) o);
        }
    }
    
    /**
     * Méthode d'affichage de l'obstacle.
     * @param obstacle Obstacle à afficher.
     */
    public void display(Obstacle obstacle){
        this.fd.getGd().getGc().drawImage(this.obstacleImage, obstacle.getX(), obstacle.getY());
    }

    /**
     * Méthode de complément d'initialisation de l'affichage.
     * @param obstacle Obstacle à afficher.
     */
    void init(Obstacle obstacle) {
        this.obstacleImage = new Image(obstacle.getRessourcePath());
        this.display(obstacle);
    }
}
