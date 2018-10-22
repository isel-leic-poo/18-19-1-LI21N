package isel.poo.robots.model.elements;

import isel.poo.robots.model.Position;

/**
 * Class whose instances represent robots. Robots have movement autonomy and always try to move towards the player.
 */
public class Robot extends Element {

    /**
     * Initiates the robot with the given coordinates.
     *
     * @param x the initial horizontal coordinate.
     * @param y the initial vertical coordinate.
     */
    public Robot(int x, int y) {
        this(new Position(x, y));
    }

    /**
     * Initiates the robot with the given position.
     * @param position the robot's initial position.
     */
    public Robot(Position position) {
        super(position);
    }

    // TODO
}
