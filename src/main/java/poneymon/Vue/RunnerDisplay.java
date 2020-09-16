package fr.univ_lyon1.info.poneymon.Vue;

import fr.univ_lyon1.info.poneymon.Modele.Runner;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.image.Image;

/**
 * Classe d'affichage des Runners.
 */
public class RunnerDisplay implements Observer{
    Image runnerImage;
    final FieldDisplay fd; 
    private int nbt;

    /**
     * Constructeur de RunnerDisplay.
     * @param fd FieldDisplay courant du jeu.
     */
    public RunnerDisplay(FieldDisplay fd) {
        this.fd = fd;
	this.nbt = -1;
    }

    /**
     * Méthode de mise à jour des données (pattern Observer).
     * @param o Observable (Runner) surveillé ayant envoyé une notification.
     * @param arg Arguments de la notification.
     */
    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof Runner){
            if(arg != null){
                runnerImage = new Image((String) arg);
            }
	    if (this.nbt != ((Runner) o).getNbTours()){
                String s = String.valueOf(((Runner) o).getNbTours());       
                String str = new String("Nb tour : " + s + "\n");
                this.fd.getGd().updateScore(str, ((Runner) o).getId());
                this.nbt++;
            }
            this.display((Runner) o);
        }
    }
    
    /**
     * Méthode d'affichage du Runner.
     * @param r Runner à afficher.
     */
    public void display(Runner r){
        this.fd.getGd().getGc().drawImage(this.runnerImage, r.getX(), r.getY());
    }

    /**
     * Méthode de complément d'initialisation de l'affichage.
     * @param r Runner à afficher.
     */
    void init(Runner r) {
        this.runnerImage = new Image(r.getRessourcePath());
        this.display(r);
    }
}
