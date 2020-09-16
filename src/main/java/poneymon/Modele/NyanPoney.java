/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_lyon1.info.poneymon.Modele;

/**
 * Classe réprésentant un poney ayant la possibilité d'activer le mode NyanPoney.
 */
public class NyanPoney extends Poney {
    
    private boolean rainbowMode;
    private boolean raindowModeActivated;
    private NyanStrategy ns;
    
    /**
     * Constructeur de NyanPoney.
     * @param f Field sur lequel est créé le Poney.
     * @param color String représentant la couleur du Poney.
     * @param yInit Coordonnée y du Poney.
     * @param nyanStrategy String indiquant la stratégie utilisée pour le mode NyanPoney.
     * @param jumpStrategy String indiquant la stratégie utilisée pour le saut.
     */
    public NyanPoney(Field f, String color, int yInit, String nyanStrategy, String jumpStrategy) {
        super(f, color, yInit, jumpStrategy);
        this.rainbowMode = false;
        this.raindowModeActivated = false;
        
        switch(nyanStrategy){
            case "human":
                ns = new HumanNyanStrategy();
                break;
            case "ai":
                ns = new AINyanStrategy();
                break;
            default:
                throw new IllegalArgumentException();
        }
    }
    
    /**
     * Méthode gérant le passage à un nouveau tour.
     */
    @Override
    public void newLap() {
        super.newLap();
        this.disableRainbowMode();
    }
    
    /**
     * Méthode de déplacement du NyanPoney.
     */
    @Override
    public void move(){
        this.ns.chooseNyanActivation(this);
        super.move();
    }
    
    /**
     * Méthode d'activation du mode NyanPoney.
     */
    public void activateRainbowMode() {
        if(this.raindowModeActivated == true)
            return;
        
        this.rainbowMode = true;
        super.setRessourcePath("assets/pony-" + super.getPoneyColor() + "-rainbow.gif");
        super.setSpeed(super.getSpeed() * 2);
        this.raindowModeActivated = true;
    }
    
    /**
     * Méthode de désactivation du mode NyanPoney.
     */
    public void disableRainbowMode() {
        this.rainbowMode = false;
        super.setRessourcePath("assets/pony-" + super.getPoneyColor() + "-running.gif");
    }

    /**
     * Méthode indiquant si le mode NyanPoney a déja été activé.
     * @return True si le mode NyanPoney a déja été activé, false sinon.
     */
    public boolean isRaindowModeActivated() {
        return raindowModeActivated;
    }

    /**
     * Getter de la stratégie utilisée pour le mode NyanPoney.
     * @return Stratégie utilisée pour le mode NyanPoney.
     */
    public NyanStrategy getStrategy() {
        return ns;
    }
}
