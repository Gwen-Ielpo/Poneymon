/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_lyon1.info.poneymon.Modele;

import static java.lang.Double.max;
import java.util.ArrayList;
import java.util.Observable;

/**
 * Classe abstraite représentant une entité courant sur le Field.
 */
public abstract class Runner extends Observable{
    public static int spaceBetweenRunners = 110;
    
    private double x;       // position horizontale du poney
    private double y; 	  // position verticale du poney
    private double speed;   // vitesse du poney
    private int nbTours;
    private String ressourcePath;
    private int id;
    private JumpStrategy js;
    
    private final Field field;
    private ArrayList<Runner> runners;

    private boolean jumping;
    private boolean falling;
    private double velY;
    private boolean hasJumped;
    
    /**
     * COnstructeur de Runner.
     * @param f Field sur lequel est instancié ce Runner.
     * @param x Coordonnée x du Runner.
     * @param y Coordonnée y du Runner.
     * @param ressourcePath Chemin vers le fichier représentant le Runner dans la vue.
     * @param jumpStrategy String indiquant la stratégie utilisée pour le saut.
     */
    public Runner(Field f, double x, double y, String ressourcePath, String jumpStrategy) {
        this.x = x;
        this.y = y;
        this.nbTours = 0;
        this.ressourcePath = ressourcePath;
        this.runners = new ArrayList<>();
        this.field = f;
        
        switch(jumpStrategy){
            case "human":
                js = new HumanJumpStrategy();
                break;
            case "ai":
                js = new AIJumpStrategy();
                break;
            default:
                throw new IllegalArgumentException();
        }
        
        this.jumping = false;
        this.falling = true;
        this.velY = 0;
        this.hasJumped = false;
    }
    
    /**
     * Méthode de complétion de la construction du Runner. 
     * Elle est appelée à la fin de la construction de tous les Runners du jeu pour que chacun d'eux puisse ajouter les autres dans leur liste de Runners?
     */
    public void completeInit(){
        for (int i = 0; i < this.field.getRunners().size(); i++) {
            if(this.field.getRunners().get(i) == this) {
                this.id = i;
                this.runners.add(null);
            }
            else
                this.runners.add(this.field.getRunners().get(i));
        }
    }
    
    /**
     * Méthode de déplacement du Runner.
     */
    public void move() {
        this.js.chooseJumpActivation(this);
        this.jump();
        this.x += this.speed;
        this.detectCollision();
        if(this.x >= this.field.getWidth()) 
            newLap();
        setChanged();
        notifyObservers();
    }
    
    /**
     * Méthode gérant le passage à un nouveau tour.
     */
    public void newLap() {
        this.nbTours++;
        this.x = -100;
        this.field.clearObstacle(id);
        this.hasJumped = false;
    }
    
    /**
     * Méthode d'ajout d'un Runner dans les liste des Runners connus.
     * @param r Runner à ajouter.
     * @param i Index dans lequel ajouter le Runner.
     */
    public void addRunner(Runner r, int i) {
        this.runners.set(i, r);
    }

    /**
     * Méthode de calcul de distance avec un Runner.
     * @param i Index du Runner de référence.
     * @return 0 si le Runner de référence est ce Runner, sinon la distance qui les sépare.
     */
    public int getDistance(int i) {
        if (this.runners.get(i) != null) { // si le poney regardé n'est pas lui-même
            return (int) ((this.runners.get(i).getX() + ((this.runners.get(i).getNbTours() + 1) * 520)) - (this.x + ((this.nbTours + 1) * 520)));
        }
        return 0;
    }

    /**
     * Getter de la coordonnée x du Runner.
     * @return La coordonnée x du Runner.
     */
    public double getX() {
        return x;
    }

    /**
     * Getter du nombre de tours parcourus par le Runner.
     * @return Le nombre de tours du Runner.
     */
    public int getNbTours() {
        return nbTours;
    }

    /**
     * Getter de la coordonnée y du Runner.
     * @return La coordonnée y du Runner.
     */
    public double getY() {
        return y;
    }

    /**
     * Getter de la vitesse du Runner.
     * @return La vitesse du Runner.
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Getter de la liste des Runners connus par ce Runner.
     * @return Une ArrayList de Runner correspondant à la liste des Runners connus par ce Runner.
     */
    public ArrayList<Runner> getRunners() {
        return runners;
    }

    /**
     * Setter de la vitesse du Runner.
     * @param speed La vitesse à affecter au Runner.
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * Setter de la coordonnée x du Runner.
     * @param x La nouvelle coordonnée x du Runner.
     */
    public void setX(double x) {
        this.x = x;
        setChanged();
        notifyObservers();
    }

    /**
     * Getter du chemin du fichier représentant le Runner dans la vue.
     * @return String contenant le chemin du fichier représentant le RUnner dans la vue.
     */
    public String getRessourcePath() {
        return ressourcePath;
    }

    /**
     * Setter du chemin du fichier représentant le Runner dans la vue.
     * @param ressourcePath String contenant le chemin du fichier représentant le Runner dans la vue.
     */
    public void setRessourcePath(String ressourcePath) {
        this.ressourcePath = ressourcePath;
        setChanged();
        notifyObservers(this.ressourcePath);
    }

    /**
     * Getter du Field sur lequel le Runner est instancié.
     * @return Field sur lequel le Runner est instancié.
     */
    public Field getField() {
        return field;
    }

    /**
     * Getter de l'index du Runner.
     * @return Index du Runner.
     */
    public int getId() {
        return id;
    }

    /**
     * Setter de la coordonnée y du Runner.
     * @param y Nouvelle coordonnée y du Runner.
     */
    public void setY(double y) {
        this.y = y;
    }
        
    /**
     * Méthode calculant les modifications de coordonnées liées au saut.
     */
    public void jump(){
        float gravity = 0.5f;
        double maxSpeed = 11;
        
        if (this.jumping == true){
             this.velY += gravity;
             if(this.velY > maxSpeed){
                 this.velY = maxSpeed;
                 this.jumping = false;
                 this.falling = true;
             }
             this.x += 2.25;
        }
        else{
            this.velY = 0;
        }
        
        this.y += this.velY;
    }

    /**
     * Méthode activant le saut.
     */
    public void enableJump() {
        if(this.jumping == false && this.hasJumped == false){
            this.jumping = true;
            this.falling = false;
            this.velY = -12;
            this.hasJumped = true;
        }
    }

    /**
     * Méthode de détection des collisions avec les obstacles.
     */
    private void detectCollision() {
        if(this.field.getObstacles().get(id) == null)
            return;
        if(!this.field.getObstacles().get(id).isActive())
            return;
        
        double realX = this.x + 110.0;
        double realX2 = realX + 80.0;
        double xObstacle = this.field.getObstacles().get(id).x;
        double x2Obstacle = xObstacle + 50.0;
        
        if(xObstacle >= realX && xObstacle <= realX2
                || x2Obstacle >= realX && x2Obstacle <= realX2){
            if(this.y + 110.0 >= this.field.getObstacles().get(id).getY() + (110.0-20.0)){
                this.collision();
            }
        }
    }

    /**
     * Méthode d'application des effets d'une collision.
     */
    private void collision() {
        System.out.println("COLLISION! "+this.id);
        this.speed = max(0.3, this.speed/2);
        this.field.getObstacles().get(id).setActive(false);
    }
}
