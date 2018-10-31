package isel.poo.robots.model.elements;

import isel.poo.robots.model.Direction;
import isel.poo.robots.model.Position;

/**
 * Class whose instances represent the player.
 */
public class Player extends Actor {

    /**
     * Initiates the player with the given coordinates.
     *
     * @param x the initial horizontal coordinate.
     * @param y the initial vertical coordinate.
     */
    public Player(int x, int y) {
        this(new Position(x, y));
    }

    /**
     * Initiates the robot with the given position.
     * @param position the player's initial position.
     */
    public Player(Position position) {
        super(position);
    }
}
