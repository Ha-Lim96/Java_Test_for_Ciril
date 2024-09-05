package tests;

import classes.Jeu;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TestJeu {

    // ici on test est ce qu'on a le résultat souhaité on utilisant les fichiers "cartes et déplacement"
    @Test
    void testPremierScenario() throws IOException {
        Jeu jeu = new Jeu("src/resources/carte.txt", "src/resources/deplacements1.txt");

        assertEquals(2, jeu.getPersonnage().getX());
        assertEquals(9, jeu.getPersonnage().getY());
    }


    // ici on test avec le deuxième fichier (la
    @Test
    void testDeuxiemeScenario() throws IOException {
        Jeu jeu = new Jeu("src/resources/carte.txt", "src/resources/deplacements2.txt");
        assertEquals(9, jeu.getPersonnage().getX());
        assertEquals(1, jeu.getPersonnage().getY());
    }


}
