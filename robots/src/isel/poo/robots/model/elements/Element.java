package isel.poo.robots.model.elements;


import isel.poo.robots.model.Position;

/**
 * Base class for all game elements. Game elements share a common characteristic: they all have a set of
 * rectangular coordinates. Negative coordinate values are not allowed.
 */
public abstract class Element {

    protected Position position;

    /**
     * Initiates the element with the given position.
     * @param position the initial position.
     */
    protected Element(Position position) {
        if (position == null)
            throw new IllegalArgumentException();
        this.position = position;
    }

    /**
     * Gets the element's horizontal coordinate.
     * @return the horizontal coordinate.
     */
    public int getX() {
        return position.x;
    }

    /**
     * Gets the element's vertical coordinate.
     * @return the vertical coordinate.
     */
    public int getY() {
        return position.y;
    }

    /**
     * Gets the element's position.
     * @return the elements position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Changes the element position.
     * @param position the new position.
     */
    public void setPositionAt(Position position) {
        if (position == null)
            throw new IllegalArgumentException();
        this.position = position;
    }

    /**
     * Changes the element position.
     * @param x the new horizontal coordinate.
     * @param y the new vertical coordinate.
     */
    public void setPositionAt(int x, int y) {
        setPositionAt(new Position(x, y));
    }
}
