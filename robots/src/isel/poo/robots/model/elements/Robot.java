package isel.poo.robots.model.elements;

import isel.poo.robots.model.Direction;
import isel.poo.robots.model.Position;

/**
 * Class whose instances represent robots. Robots have movement autonomy and always try to move towards the player.
 */
public class Robot extends Actor {

    /**
     * Initiates the robot with the given coordinates.
     *
     * @param x the initial horizontal coordinate.
     * @param y the initial vertical coordinate.
     */
    public Robot(int x, int y, Player target) {
        this(new Position(x, y), target);
    }

    /**
     * Initiates the robot with the given position.
     * @param position the robot's initial position.
     */
    public Robot(Position position, Player target) {
        super(position);
        target.addListener(new StateChangeListener() {
            @Override
            public void positionChanged(Actor source, Position oldPos, Position newPos) {
                // TODO: Fix this algorithm
                int distX = position.x - source.position.x;
                int deltaX = distX == 0 ? 0 : -(distX / Math.abs(distX));

                int distY = position.y - source.position.y;
                int deltaY = distY == 0 ? 0 : -(distY / Math.abs(distY));

                moveBy(deltaX, deltaY);
            }
        });
    }
}
