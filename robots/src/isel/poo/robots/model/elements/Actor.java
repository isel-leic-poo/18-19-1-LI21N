package isel.poo.robots.model.elements;

import isel.poo.robots.model.Direction;
import isel.poo.robots.model.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * Base class for all game actors. Actors are elements that are capable of moving around the arena.
 */
public abstract class Actor extends Element {

    /** The list of state change listeners */
    private List<StateChangeListener> listeners;

    /**
     * Initiates the instance with the given position.
     *
     * @param position the initial position.
     */
    protected Actor(Position position) {
        super(position);
        listeners = new ArrayList<>();
    }

    /**
     * Moves the player on the given direction.
     * @param dX the movement's variation in the X axis
     * @param dY the movement's variation in the Y axis
     */
    public void moveBy(int dX, int dY) {
        Position oldPos = position;
        position = new Position(position.x + dX, position.y + dY);

        for (StateChangeListener listener: listeners)
            listener.positionChanged(this, oldPos, position);
    }

    /**
     * Moves the player on the given direction.
     * @param direction the movement's direction
     */
    public void moveBy(Direction direction) {
        moveBy(direction.deltaX, direction.deltaY);
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
