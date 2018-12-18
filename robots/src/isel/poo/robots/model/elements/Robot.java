package isel.poo.robots.model.elements;

import isel.poo.robots.model.Position;
import isel.poo.robots.model.World;

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
    public Robot(int x, int y, Player target, World world) {
        this(new Position(x, y), target, world);
    }

    /**
     * Initiates the robot with the given position.
     * @param initialPosition the robot's initial position.
     */
    public Robot(Position initialPosition, Player player, World world) {
        super(initialPosition, world);
        player.addListener(new StateChangeListener() {
            @Override
            public void positionChanged(Actor source, Position oldPos, Position newPos) {
                if (player.isDead()) {
                    System.out.println("Player is dead");
                    return;
                }
                int distX = position.x - newPos.x;
                int deltaX = distX == 0 ? 0 : -(distX / Math.abs(distX));
                int distY = position.y - newPos.y;
                int deltaY = distY == 0 ? 0 : -(distY / Math.abs(distY));
                moveBy(deltaX, deltaY);
            }
        });
    }

    @Override
    protected CollisionResult checkCollision(Position newPosition) {
        Element element = world.getElementAt(newPosition);
        if (element != null) {
            if (element instanceof Player)
                ((Player) element).kill();
        }
        return new CollisionResult(element, true);
    }
}