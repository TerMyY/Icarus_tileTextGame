package IcarusGame;

public class Tile {

    enum Type {
        EMPTY,
        HERO,
        ENEMY,
        TRAP,
        SHOPKEEPER,
        COIN
    }

    Type type;
    boolean isEmpty = true;
    private int x;
    private int y;

    Tile(Type type) {
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    @Override
    public String toString() {
        switch (type) {
            case EMPTY:
                return "[ ]";
            case HERO:
                return "[*]";
            case ENEMY:
                return "[#]";
            case TRAP:
                return "[^]";
            case COIN:
                return "[\u00A9]";
            case SHOPKEEPER:
                return "[$]";
        }
        return null;
    }
}