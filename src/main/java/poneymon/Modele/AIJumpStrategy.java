/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_lyon1.info.poneymon.Modele;

/**
 * Classe de stratégie de saut pour les IA.
 */
public class AIJumpStrategy implements JumpStrategy {

    /**
     * Active le saut suivant les conditions.
     * @param r Runner sur lequel déterminer l'activation du saut.
     */
    @Override
    public void chooseJumpActivation(Runner r) {
        Obstacle o = r.getField().getObstacles().get(r.getId());
        if(o == null)
            return;
        if(r.getX()+200.0 >= o.getX())
            r.enableJump();
    }
}
