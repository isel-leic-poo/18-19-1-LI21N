package isel.poo.robots.model;

/**
 * Class whose instances represent the position of the participants. Coordinates must positive or zero.
 */
public final class Position {

    public final int x, y;

    /**
     * Initiates an instance with the given coordinates.
     * @param x the X coordinate
     * @param y the Y coordinate
     */
    public Position(int x, int y) {
        if (x < 0 || y < 0)
            throw new IllegalArgumentException();

        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Position))
            return false;

        final Position theOther = (Position) other;
        if (this == theOther)
            return true;

        return this.x == theOther.x && this.y == theOther.y;
    }

    @Override
    public String toString() {
        return String.format("{ x: %1$d, y: %2$d }", x, y);
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}
