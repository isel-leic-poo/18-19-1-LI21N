package isel.poo.robots.model.elements;

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
     * @param initialPosition the robot's initial position.
     */
    public Robot(Position initialPosition, Player target) {
        super(initialPosition);
        target.addListener(new StateChangeListener() {
            @Override
            public void positionChanged(Actor source, Position oldPos, Position newPos) {
                int distX = position.x - newPos.x;
                int deltaX = distX == 0 ? 0 : -(distX / Math.abs(distX));
                int distY = position.y - newPos.y;
                int deltaY = distY == 0 ? 0 : -(distY / Math.abs(distY));
                System.out.printf("Player at %1$s", newPos);
                System.out.printf("; Robot at %1$s \n", position);
                System.out.printf("Moving by { x: %1$d, y: %2$d }\n", deltaX, deltaY);
                moveBy(deltaX, deltaY);
            }
        });
    }
}
