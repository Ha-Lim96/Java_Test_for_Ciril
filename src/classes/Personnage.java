package classes;

public class Personnage {
    private int x;
    private int y;

    public Personnage(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void deplacer(Direction direction) {
        switch (direction) {
            case NORD:
                this.x -= 1;
                break;
            case SUD:
                this.x += 1;
                break;
            case EST :
                this.y += 1;
                break;
            case OUEST:
                this.y -= 1;
                break;
        }
    }
}
