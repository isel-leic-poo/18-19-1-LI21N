package isel.poo.robots.model.elements;

import isel.poo.robots.model.Arena;
import isel.poo.robots.model.Direction;
import isel.poo.robots.model.Position;
import isel.poo.robots.model.World;

import java.util.Random;

/**
 * Class whose instances represent the player.
 */
public class Player extends Actor {

    private boolean isAlive;

    /**
     * Initiates the player with the given coordinates.
     *
     * @param x the initial horizontal coordinate.
     * @param y the initial vertical coordinate.
     * @param world The world containing the player instance.
     */
    public Player(int x, int y, World world) {
        this(new Position(x, y), world);
    }

    /**
     * Initiates the robot with the given position.
     * @param position the player's initial position.
     * @param world The world containing the player instance.
     */
    public Player(Position position, World world) {
        super(position, world);
        isAlive = true;
    }

    /**
     * Causes the player to jump to a random position within the given world
     */
    public Position jump() {
        final Random rnd = new Random();
        Position initialPosition = position;
        position = new Position(rnd.nextInt(world.getMaxX()),
                rnd.nextInt(world.getMaxY()));
        firePositionChanged(initialPosition, position);
        return position;
    }

    @Override
    protected CollisionResult checkCollision(Position newPosition) {
        final Element element = world.getElementAt(newPosition);
        if (element != null) {
            if (element instanceof Robot)
                this.kill();
        }
        return new CollisionResult(element, true);
    }

    /**
     * Checks whether the player is dead or not
     * @return a boolean value indicating whether the player is alive or not
     */
    public boolean isDead() {
        return !isAlive;
    }

    /**
     * Kills the player instance. Subsequent calls to @isDead return true
     */
    public void kill() {
        isAlive = false;
    }
}
