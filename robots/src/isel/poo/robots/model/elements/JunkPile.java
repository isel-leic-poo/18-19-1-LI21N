package isel.poo.robots.model.elements;

import isel.poo.robots.model.Position;

/**
 * Class whose instances represent junk piles. Junk piles are produced whenever two or more robots colide.
 */
public class JunkPile extends Element {

    /**
     * Initiates the pile with the given coordinates.
     *
     * @param x the initial horizontal coordinate.
     * @param y the initial vertical coordinate.
     */
    public JunkPile(int x, int y) {
        this(new Position(x, y));
    }

    /**
     * Initiates the pile with the given position.
     *
     * @param position the pile's initial position.
     */
    public JunkPile(Position position) {
        super(position);
    }

    // TODO:
}
