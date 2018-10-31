package isel.poo.robots.model.elements;

import isel.poo.robots.model.Direction;
import isel.poo.robots.model.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class Actor extends Element {

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

    public void addListener(StateChangeListener stateChangeListener) {
        listeners.add(stateChangeListener);
    }

    public void removeListener(StateChangeListener stateChangeListener) {
        listeners.remove(stateChangeListener);
    }

    public interface StateChangeListener {
        void positionChanged(Actor source, Position oldPos, Position newPos);
    }
}
