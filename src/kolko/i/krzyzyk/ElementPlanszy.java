package kolko.i.krzyzyk;

/**
 * Created by Rafał.
 */
public class ElementPlanszy {
    private int x;
    private int y;
    private Stan stan;

    public ElementPlanszy(int x, int y){
        this.x = x;
        this.y = y;
        this.stan = Stan.PUSTY;
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

    public Stan getStan() {
        return stan;
    }

    public void setStan(Stan stan) {
        this.stan = stan;
    }
}
