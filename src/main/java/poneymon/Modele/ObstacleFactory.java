/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_lyon1.info.poneymon.Modele;

/**
 * Classe factory pour créer les obstacles.
 */
public class ObstacleFactory implements ObstacleFactoryIF{
    /**
     * Méthode de création paramétrée des obstacles.
     * @param type String indiquant le type de l'obstacle à créer.
     * @param args Liste de String contenant les arguments à passer au constructeur de l'obstacle.
     * @return L'obstacle créé.
     */
    @Override
    public Obstacle createObstacle(String type, String[] args){
        Obstacle obstacle = null;
        switch(type){
            case "sleepy":
                obstacle = new StaticObstacle(Integer.decode(args[0]), args[1]);
                break;
            case "grumpy":
                obstacle = new DynamicObstacle(Integer.decode(args[0]), args[1]);
                break;
        }
        return obstacle;    
    }
    
}
