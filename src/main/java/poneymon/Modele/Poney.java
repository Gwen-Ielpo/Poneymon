/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_lyon1.info.poneymon.Modele;

import static java.lang.Double.max;
import java.util.Random;

/**
 * Classe représentant les poneys.
 */
public class Poney extends Runner {
    
    private double startX;
    private String poneyColor;
    private Poney[] poneys = new Poney[5];
    
    /**
     * Constructeur de Poney.
     * @param f Field sur lequel est créé le Poney.
     * @param color String représentant la couleur du Poney.
     * @param yInit Coordonnée y du Poney.
     * @param jumpStrategy String indiquant la stratégie utilisée pour le saut.
     */
    public Poney(Field f, String color, int yInit, String jumpStrategy) {
        super(f, -220.0, yInit, "assets/pony-" + color + "-running.gif", jumpStrategy);
        this.startX = -220.0;
        this.poneyColor = color;
        
        this.setSpeed();
    }

    /**
     * Méthode gérant le passage à un nouveau tour.
     */
    @Override
    public void newLap() {
        super.newLap();
        // On ne veut pas le reset par défaut de x
        super.setX(this.startX);
        
        this.setSpeed();
    }

    /**
     * Getter de la couleur du poney
     * @return String représentant la couleur du poney.
     */
    public String getPoneyColor() {
        return poneyColor;
    }
    
    /**
     * Setter de la vitesse du poney.
     * Set la vitesse à un valeur aléatoire entre 0.3 et 1.0.
     */
    public void setSpeed(){
        Random randomGenerator = new Random();
        super.setSpeed(max(0.3, randomGenerator.nextFloat()));
    }
}
