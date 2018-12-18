package isel.poo.robots.model.elements;

import isel.poo.robots.model.Direction;
import isel.poo.robots.model.Position;
import isel.poo.robots.model.World;

import java.util.ArrayList;
import java.util.List;

/**
 * Base class for all game actors. Actors are elements that are capable of moving around the arena.
 */
public abstract class Actor extends Element {

    protected static class CollisionResult {
        /** The element that we collided with, or null. */
        final Element element;
        /** Should the actor move or not */
        final boolean shouldMove;

        protected CollisionResult(Element element, boolean shouldMove) {
            this.element = element;
            this.shouldMove = shouldMove;
        }
    }

    /** The list of state change listeners */
    private List<StateChangeListener> listeners;

    /**
     * The world where the actor lives on.
     */
    protected World world;

    protected void firePositionChanged(Position oldPos, Position newPos) {
        for (StateChangeListener listener: listeners)
            listener.positionChanged(this, oldPos, newPos);
    }

    /**
     * Initiates the instance with the given position.
     *
     * @param position the initial position.
     */
    protected Actor(Position position, World world) {
        super(position);
        this.listeners = new ArrayList<>();
        this.world = world;
    }

    /**
     * Moves the player on the given direction.
     * @param dX the movement's variation in the X axis
     * @param dY the movement's variation in the Y axis
     */
    public Position moveBy(int dX, int dY) {
        final Position newPos = new Position(position.x + dX, position.y + dY);
        final CollisionResult result = checkCollision(newPos);
        if (result.shouldMove) {
            final Position oldPos = position;
            position = newPos;
            firePositionChanged(oldPos, position);
        }
        return position;
    }

    /**
     * Checks if this actor will collid with a world element.
     * Derived classes must specify their behaviour upon collision and return the appropriate result.
     * @param newPosition the position where the actor intends to go.
     * @return The collision result.
     */
    protected abstract CollisionResult checkCollision(Position newPosition);

    /**
     * Moves the player on the given direction.
     * @param direction the movement's direction
     */
    final public Position moveBy(Direction direction) {
        return moveBy(direction.deltaX, direction.deltaY);
    }

    /**
     * Checks whether the actor can move in the given direction.
     * @param direction the movement's direction
     * @return a boolean value indicating whether the movement can be made or not.
     */
    public boolean canMoveBy(Direction direction) {
        Position newPosition = new Position(position.x + direction.deltaX, position.y + direction.deltaY);
        return world.isValid(newPosition);
    }

    /**
     * Registers the given listener to be notified of state changes.
     * @param stateChangeListener the listener to be notified.
     */
    public void addListener(StateChangeListener stateChangeListener) {
        listeners.add(stateChangeListener);
    }

    /**
     * Unregisters the given listener.
     * @param stateChangeListener the listener to be unregistered.
     */
    public void removeListener(StateChangeListener stateChangeListener) {
        listeners.remove(stateChangeListener);
    }

    /**
     * Contract to be supported by all listeners of changes in the actor's state
     */
    public interface StateChangeListener {
        /**
         * Callback method used to signal that the actor's position has changed
         * @param source The actor instance producing the notification
         * @param oldPos The previous position of the actor
         * @param newPos The current position of the actor
         */
        void positionChanged(Actor source, Position oldPos, Position newPos);
    }
}
