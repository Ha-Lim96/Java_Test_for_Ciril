package classes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Carte {
    private char[][] grille; // on déclare la grille

    public Carte(String cheminFichier) throws IOException {
        List<String> lignes = Files.readAllLines(Paths.get(cheminFichier)); // on récupère les lignes et les stocker dans une list de chaines de caractère
        int hauteur = lignes.size(); // on récupère la hauteur de la carte via la taille de la liste
        int largeur = lignes.get(0).length(); // on récupère la largeur de la carte via la taille d'une seule ligne
        grille = new char[hauteur][largeur];    // on instancie la grille caractère avec les bonnes dimensions

        // on copie la liste des ligne en changeant la forme de (string -> caractère) pour qu'on puisse naviger dessus
        for (int i = 0; i < hauteur; i++) {
            grille[i] = lignes.get(i).toCharArray();
        }

    }

    // la fonction permet de tester la possibilité du déplacement
    public boolean estDeplacementPossible(int x, int y) {
        if (x < 0 || y < 0 || x >= grille.length || y >= grille[0].length) {
            return false;  // Hors des limites
        }
        return grille[x][y] == ' ';  // true si l'héro peut se déplacer
    }

    //la fonction permet l'affichage de la carte
    public void afficherCarte() {
        for (char[] ligne : grille) {
            System.out.println(ligne);
        }
    }

}
