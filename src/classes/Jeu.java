package classes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Jeu {
    private Carte carte;
    private Personnage personnage;

    public Jeu(String fichierCarte, String fichierDeplacement) throws IOException {
        // Chargement de la carte
        this.carte = new Carte(fichierCarte);

        // Lecture du fichier de déplacement
        List<String> lignes = Files.readAllLines(Paths.get(fichierDeplacement));
        String[] coordonneesInitiales = lignes.get(0).split(",");
        int xInitial = Integer.parseInt(coordonneesInitiales[1]);
        int yInitial = Integer.parseInt(coordonneesInitiales[0]);

        // Création du personnage à la position initiale
        this.personnage = new Personnage(xInitial, yInitial);

        // Exécution des déplacements
        String mouvements = lignes.get(1);
        executerDeplacements(mouvements);
    }

    public Personnage getPersonnage() {
        return personnage;
    }

    private void executerDeplacements(String mouvements) {
        // Pour chaque caractère dans la chaîne des mouvements
        for (int i = 0; i < mouvements.length(); i++) {
            char mouvement = mouvements.charAt(i); // Récupérer le mouvement actuel
            Direction direction = Direction.fromChar(mouvement); // Trouver la direction

            // Calculer les nouvelles coordonnées en fonction de la direction
            int nouvelX = personnage.getX();
            int nouvelY = personnage.getY();

            if (direction == Direction.NORD) {
                nouvelX -= 1; // Aller vers le nord (haut)
            } else if (direction == Direction.SUD) {
                nouvelX += 1; // Aller vers le sud (bas)
            } else if (direction == Direction.EST) {
                nouvelY += 1; // Aller vers l'est (droite)
            } else if (direction == Direction.OUEST) {
                nouvelY -= 1; // Aller vers l'ouest (gauche)
            }

            // Vérifier si le déplacement est possible
            if (carte.estDeplacementPossible(nouvelX, nouvelY)) {
                personnage.deplacer(direction); // Si oui, déplacer le personnage
            }
        }
    }

    public void afficherPositionFinale() {
        System.out.println("Position finale : (" + personnage.getY() + ", " + personnage.getX() + ")");

    }

}


