/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_lyon1.info.poneymon.Modele;

/**
 * Interface de factory pour la création paramétrée des Runners.
 */
public interface RunnerFactoryIF {
    /**
     * Méthode de création paramétrée des Runners
     * @param type String indiquant le type de Runner à créer.
     * @param f Field sur lequel créer le Runner.
     * @param args Liste de String contenant les arguments à passer au constructeur du Runner.
     * @return Le Runner créé.
     */
    public Runner createRunner(String type, Field f, String[] args);
}
