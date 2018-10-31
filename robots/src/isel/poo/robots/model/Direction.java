package isel.poo.robots.model;

/**
 * Enumeration used to represent movement directions.
 */
public enum Direction {

    N(0, -1), NE(1, -1), E(1, 0), SE(1, 1), S(0, 1), SW(-1, 1), W(-1, 0), NW(-1, -1);

    public final int deltaX, deltaY;

    Direction(int dX, int dY) {
        this.deltaX = dX;
        this.deltaY = dY;
    }
}
