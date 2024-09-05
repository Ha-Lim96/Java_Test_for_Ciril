package classes;

public enum Direction {
    NORD, SUD, EST, OUEST;


   // la fonction qui permet de dire convertir une lettre à une direction
    public static Direction fromChar(char c) {
        // Convertir en majuscule pour correspondre aux noms d'énumérations
        switch (Character.toUpperCase(c)) {
            case 'N': return NORD;
            case 'S': return SUD;
            case 'E': return EST;
            case 'O': return OUEST;
            default: throw new IllegalArgumentException("Direction invalide : " + c);
        }
    }
}


