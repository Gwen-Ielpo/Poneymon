/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_lyon1.info.poneymon.Modele;

/**
 * Classe factory pour créer des Runners.
 */
public class RunnerFactory implements RunnerFactoryIF {
    /**
     * Méthode de création paramétrée des Runners
     * @param type String indiquant le type de Runner à créer.
     * @param f Field sur lequel créer le Runner.
     * @param args Liste de String contenant les arguments à passer au constructeur du Runner.
     * @return Le Runner créé.
     */
    @Override
    public Runner createRunner(String type, Field f, String[] args){
        Runner runner = null;
        switch(type)
        {
            case "poney":
                runner = new Poney(f, args[0], Integer.decode(args[1]), args[2]);
                break;
            case "nyanponey":
                runner = new NyanPoney(f, args[0], Integer.decode(args[1]), args[2], args[3]);
                break;
        }
        return runner;
    }
}
