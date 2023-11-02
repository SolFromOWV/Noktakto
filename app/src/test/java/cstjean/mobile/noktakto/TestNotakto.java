package cstjean.mobile.noktakto;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Classe de test pour le jeu notakto.
 */
public class TestNotakto {

    /**
     * Variable qui invoque la classe notakto.
     */
    private Notakto notakto;

    /**
     * Setup un jeu de notakto pour se servir plus tard.
     */
    @Before
    public void setUp() {
        notakto = new Notakto();
    }

    /**
     * Test si le notakto si crée correctement.
     */
    @Test
    public void testCreer() {
        for (int i = 0; i <= 8; i++) {
            assertEquals(false, notakto.getEstCoche(i));
        }
        assertEquals(true, notakto.getEstTourJoueurUn());
    }

    /**
     * Test si le notakto peut jouer un tour correctement.
     */
    @Test
    public void testJouerTour() {
        assertEquals(false, notakto.getEstCoche(0));
        notakto.jouerTour(0);
        assertEquals(true, notakto.getEstCoche(0));
        assertEquals(false, notakto.getEstTourJoueurUn());
    }

    /**
     * Test si l'initialisation et le reset fonctionnent.
     */
    @Test
    public void testInitialiser() {
        notakto.jouerTour(0);
        notakto.initialiser();
        assertEquals(false, notakto.getEstCoche(0));
    }

    /**
     * Test si la défaite fonctionne.
     */
    @Test
    public void testDefaite() {
        notakto.jouerTour(0);
        notakto.jouerTour(1);
        notakto.jouerTour(2);
        assertEquals(true, notakto.verifierDefaite());
    }
}
