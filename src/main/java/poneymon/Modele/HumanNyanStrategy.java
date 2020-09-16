/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_lyon1.info.poneymon.Modele;

/**
 * Classe de stratégie pour le mode NyanPoney des joueurs humains.
 */
public class HumanNyanStrategy implements NyanStrategy {

    /**
     * Active le mode NyanPoney suivant les appuis clavier et les conditions.
     * @param np Runner sur lequel déterminer l'activation du mode NyanPoney.
     */
    @Override
    public void chooseNyanActivation(NyanPoney np) {
        
        if(np.getField().getGame().getGameControlleur().isInputContains("NUMPAD" + (np.getId() + 1))
                && np.getField().getGame().getGameControlleur().isInputContains("SHIFT")) {
            np.activateRainbowMode();
            np.getField().getGame().getGameControlleur().removeFromInputs("NUMPAD" + (np.getId() + 1));
            np.getField().getGame().getGameControlleur().removeFromInputs("SHIFT");
        }
    }
    
}
