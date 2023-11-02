package cstjean.mobile.noktakto;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe du jeu Notakto.
 */
public class Notakto {
    /**
     * Variable pour savoir si c'est le tour du joueur 1.
     */
    private Boolean estTourJoueurUn = true;
    /**
     * Variable qui contient les boutons du jeu.
     */
    private final Map<Integer, Boolean> boutons = new HashMap<>(9);

    /**
     * Constructeur qui initialise chaque bouton à false.
     */
    public Notakto() {
        initialiser();
    }

    /**
     * Getter pour savoir si un bouton en particulier est coché.
     *
     * @param index L'index du bouton.
     * @return True si le bouton est coché, false si non.
     */
    public Boolean getEstCoche(int index) {
        return boutons.get(index);
    }

    public Boolean getEstTourJoueurUn() {
        return estTourJoueurUn;
    }

    /**
     * Méthode pour jouer un tour du jeu.
     *
     * @param index Index du bouton à jouer.
     */
    public void jouerTour(int index) {
        boutons.put(index, true);
        estTourJoueurUn = !estTourJoueurUn;
    }

    /**
     * Vérifie si le joueur actuel a perdu.
     *
     * @return True si le joueur actuel a perdu, false is non.
     */
    public Boolean verifierDefaite() {
        return Boolean.TRUE.equals(boutons.get(0)) && Boolean.TRUE.equals(boutons.get(1)) &&
                Boolean.TRUE.equals(boutons.get(2)) ||
                Boolean.TRUE.equals(boutons.get(3)) && Boolean.TRUE.equals(boutons.get(4)) &&
                        Boolean.TRUE.equals(boutons.get(5)) ||
                Boolean.TRUE.equals(boutons.get(6)) && Boolean.TRUE.equals(boutons.get(7)) &&
                        Boolean.TRUE.equals(boutons.get(8)) ||
                Boolean.TRUE.equals(boutons.get(0)) && Boolean.TRUE.equals(boutons.get(3)) &&
                        Boolean.TRUE.equals(boutons.get(6)) ||
                Boolean.TRUE.equals(boutons.get(1)) && Boolean.TRUE.equals(boutons.get(4)) &&
                        Boolean.TRUE.equals(boutons.get(7)) ||
                Boolean.TRUE.equals(boutons.get(2)) && Boolean.TRUE.equals(boutons.get(5)) &&
                        Boolean.TRUE.equals(boutons.get(8)) ||
                Boolean.TRUE.equals(boutons.get(0)) && Boolean.TRUE.equals(boutons.get(4)) &&
                        Boolean.TRUE.equals(boutons.get(8)) ||
                Boolean.TRUE.equals(boutons.get(2)) && Boolean.TRUE.equals(boutons.get(4)) &&
                        Boolean.TRUE.equals(boutons.get(6));
    }

    /**
     * Initialise le jeu au démarrage de l'app ou reset le jeu si l'app est en cours.
     */
    public void initialiser() {
        for (int i = 0; i <= 8; i++) {
            boutons.put(i, false);
        }
        estTourJoueurUn = true;
    }
}
