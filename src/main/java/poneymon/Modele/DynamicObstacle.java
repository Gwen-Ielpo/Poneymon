/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_lyon1.info.poneymon.Modele;

import java.util.Random;

/**
 * Classe d'obstacle dynamique (se déplacant).
 */
public class DynamicObstacle extends Obstacle {
    private double speed;
    
    /**
     * Constructeur de DynamicObstacle.
     * @param y Coordonnée y de l'obstacle. 
     * @param ressourcePath Chemin vers le fichier représentant l'obstacle dans la vue.
     */
    public DynamicObstacle(double y, String ressourcePath){
        super(y, ressourcePath);
        this.speed = -0.3;
	int max = 500;
	int min = 300;
        Random rand = new Random();
        this.x = rand.nextInt(max - min -1) + min;
    }

    /**
     * Méthode de déplacement de l'obstacle.
     */
    @Override
    public void move() {
        this.x += this.speed;
        if(x <= 100){
            this.speed = 0;
        }
        super.move();
    }
}

