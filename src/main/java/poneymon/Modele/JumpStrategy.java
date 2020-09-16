/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_lyon1.info.poneymon.Modele;

/**
 * Interface de stratégie pour les sauts.
 */
public interface JumpStrategy {
    /**
     * Active le saut suivant la stratégie.
     * @param r Runner sur lequel déterminer l'activation du saut.
     */
    public void chooseJumpActivation(Runner r);
}
