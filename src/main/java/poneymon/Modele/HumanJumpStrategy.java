/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_lyon1.info.poneymon.Modele;

/**
 * Classe de stratégie pour les sauts des joueurs humains.
 */
public class HumanJumpStrategy implements JumpStrategy {

    /**
     * Active le saut suivant les appuis clavier et les conditions.
     * @param r Runner sur lequel déterminer l'activation du saut.
     */
    @Override
    public void chooseJumpActivation(Runner r) {
        if(r.getField().getGame().getGameControlleur().isInputContains("NUMPAD" + (r.getId() + 1))
                && !r.getField().getGame().getGameControlleur().isInputContains("SHIFT")) {
            r.enableJump();
            r.getField().getGame().getGameControlleur().removeFromInputs("NUMPAD" + (r.getId() + 1));
        }
    }
    
}
