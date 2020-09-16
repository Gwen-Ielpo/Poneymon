/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_lyon1.info.poneymon.Modele;

/**
 * Classe de stratégie de mode NyanPoney pour les IA.
 */
public class AINyanStrategy implements NyanStrategy {

    /**
     * Active le mode NyanPoney suivant les conditions.
     * @param np NyanPoney sur lequel déterminer l'activation du mode NyanPoney.
     */
    @Override
    public void chooseNyanActivation(NyanPoney np) {
        if(np.isRaindowModeActivated() == true)
            return;
        
        int max = 0;
        for (int i = 0; i < np.getRunners().size(); i++) {
            if(np.getRunners().get(i) != null)
            {
                if(max < np.getDistance(i))
                {
                    max = np.getDistance(i);
                }
            }
        }
        
        if(max > 700 || np.getSpeed() < 0.35 || np.getSpeed() > 0.8)
            np.activateRainbowMode();
    }
    
}
