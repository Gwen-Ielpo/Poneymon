/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_lyon1.info.poneymon.Modele;

import java.util.Observable;
import java.util.Random;

/**
 * Classe représentant les obstacles.
 */
public abstract class Obstacle extends Observable{
    protected double x;
    private double y;
    private String ressourcePath;
    private boolean active;
        
    /**
     * Constructeur de Obstacle.
     * @param y Coordonnée y de l'obstacle.
     * @param ressourcePath Chemin vers le fichier représentant l'obstacle dans la vue.
     */
    public Obstacle(double y, String ressourcePath){
	int max = 500;
	int min = 100;
        Random rand = new Random();
        this.x = rand.nextInt(max - min -1) + min;
        this.y = y;
        this.ressourcePath = ressourcePath;
        this.active = true;
    }
    
    /**
     * Méthode de déplacement de l'obstacle.
     */
    public void move(){
        this.setChanged();
        this.notifyObservers();
    }  

    /**
     * Getter de la coordonnée x de l'obstacle.
     * @return Coordonnée x de l'obstacle.
     */
    public double getX() {
        return x;
    }

    /**
     * Getter de la coordonnée y de l'obstacle.
     * @return Coordonnée y de l'obstacle.
     */
    public double getY() {
        return y;
    }

    /**
     * Getter de la String contenant le chemin vers le fichier représentant l'obstacle dans la vue.
     * @return String contenant le chemin vers le fichier représentant l'obstacle dans la vue.
     */
    public String getRessourcePath() {
        return ressourcePath;
    }

    /**
     * Setter de la coordonnéee x de l'obstacle.
     * @param x Double à attribuer à la coordonnée x.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Setter de la coordonnéee y de l'obstacle.
     * @param y Double à attribuer à la coordonnée y.
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Setter de la String contenant le chemin vers le fichier représentant l'obstacle dans la vue.
     * @param ressourcePath String contenant le chemin vers le fichier représentant l'obstacle dans la vue.
     */
    public void setRessourcePath(String ressourcePath) {
        this.ressourcePath = ressourcePath;
    }

    /**
     * Méthde permettant de mettre à jour si l'obstacle doit être considéré dans les collisions.
     * @param active 
     */
    void setActive(boolean active) {
        this.active = active;
        setChanged();
        notifyObservers();
    }

    /**
     * Méthode indiquant si l'obstacle doit être considéré pour les collision.
     * @return True si l'obstacle est actif, false sinon.
     */
    boolean isActive() {
        return this.active;
    }
    
    
}
