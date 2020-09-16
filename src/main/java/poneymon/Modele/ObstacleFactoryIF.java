/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_lyon1.info.poneymon.Modele;

/**
 * Interface de factory pour la création paramétrée des obstacles.
 */
public interface ObstacleFactoryIF {
    /**
     * Méthode de création paramétrée des obstacles.
     * @param type String indiquant le type de l'obstacle à créer.
     * @param args Liste de String contenant les arguments à passer au constructeur de l'obstacle.
     * @return L'obstacle créé.
     */
    public Obstacle createObstacle(String type, String[] args);
}
