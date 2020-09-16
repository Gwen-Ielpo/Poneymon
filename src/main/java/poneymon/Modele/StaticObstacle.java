/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_lyon1.info.poneymon.Modele;

/**
 * Classe d'obstacle statique (ne bougeant pas).
 */
public class StaticObstacle extends Obstacle {
    /**
     * Constructeur de StaticObstacle.
     * @param y Coordonnée y de l'obstacle. 
     * @param ressourcePath Chemin vers le fichier représentant l'obstacle dans la vue.
     */
    public StaticObstacle(double y, String ressourcePath){
        super(y, ressourcePath);
    }
}
