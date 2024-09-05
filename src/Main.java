import classes.Jeu;
import tests.TestJeu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.err.println("Erreur ! il faut ajouter les parametres ' carte + fichier de déplacement' pour exécuter le jeu ");
            return;
        }
        Jeu jeu = new Jeu(args[0], args[1]);
        jeu.afficherPositionFinale();
    }
}