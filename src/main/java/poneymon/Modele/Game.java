/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_lyon1.info.poneymon.Modele;

import fr.univ_lyon1.info.poneymon.Controlleur.GameControlleur;

/**
 * Classe d'entrée du modèle contenant les informations générales du jeu.
 */
public class Game {
    
    private Field field;
    private GameControlleur gameControlleur;
    
    /**
     * Constructeur de Game.
     * @param gc GameControlleur associé au jeu.
     * @param width Largeur du terrain.
     * @param height Hauteur du terrain.
     */
    public Game(GameControlleur gc, int width, int height){
        this.gameControlleur = gc;
        this.field = new Field(this, width,height);
    }

    /**
     * Getter de Field associé au jeu courant.
     * @return Field associé au jeu courant.
     */
    public Field getField() {
        return field;
    }

    /**
     * Getter de GameControlleur associé au jeu courant.
     * @return GameControlleur associé au jeu courant.
     */
    public GameControlleur getGameControlleur() {
        return gameControlleur;
    }
    
}
