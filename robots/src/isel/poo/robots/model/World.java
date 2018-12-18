package isel.poo.robots.model;

import isel.poo.robots.model.elements.Element;

/**
 * Contract to be supported by types that can provide information about the world where the game actors live.
 */
public interface World {

    /**
     * Checks if the given position is within the world's boundaries.
     * @param position the position to be checked
     * @return
     */
    boolean isValid(Position position);

    /**
     * Gets the element at the given position, otherwise returns null.
     * @param position the position
     * @return the element at that position, or null.
     */
    Element getElementAt(Position position);

    /**
     * Gets the element at the given position, otherwise returns null.
     * @param y the position's Y coordinate (or line)
     * @param x the position's X coordinate (or column)
     * @return the element at that position, or null.
     */
    Element getElementAt(int y, int x);

    /**
     * Gets the maximum valid X coordinate.
     */
    int getMaxX();

    /**
     * Gets the maximum valid Y coordinate.
     */
    int getMaxY();
}
