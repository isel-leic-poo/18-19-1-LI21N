package isel.poo.robots.model;

import isel.poo.robots.model.elements.*;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Arena implements World {

    private final Player player;
    private final List<JunkPile> junkPiles;
    private final List<Robot> robots;

    private Element[][] arena;

    private final int xMax, yMax;

    public Arena(int xUpperBound, int yUpperBound, ParticipantsProvider provider) {

        this.xMax = xUpperBound;
        this.yMax = yUpperBound;
        this.arena = new Element[xUpperBound][yUpperBound];
        this.player = provider.getPlayer(this);
        this.arena[player.getX()][player.getY()] = player;

        Actor.StateChangeListener movementListener = new Actor.StateChangeListener() {
            @Override
            public void positionChanged(Actor source, Position oldPos, Position newPos) {
                System.out.println(source.getClass().getSimpleName() + " moving from " + oldPos + " to " + newPos);
                arena[oldPos.x][oldPos.y] = null;
                arena[newPos.x][newPos.y] = source;
            }
        };

        this.player.addListener(movementListener);

        this.junkPiles = provider.getJunkPiles(this);
        this.robots = provider.getRobots(this);

        for (Element element : junkPiles) {
            arena[element.getX()][element.getY()] = element;
        }
        for (Robot robot : robots) {
            arena[robot.getX()][robot.getY()] = robot;
            robot.addListener(movementListener);
        }
    }

    public Player getPlayer() {
        return player;
    }

    public List<JunkPile> getJunkPiles() {
        return Collections.unmodifiableList(junkPiles);
    }

    public List<Robot> getRobots() {
        return Collections.unmodifiableList(robots);
    }

    public void movePlayer(Direction direction) {
        if (player.canMoveBy(direction)) {
            player.moveBy(direction);
        }
    }

    public void jumpPlayer() {
        player.jump();
    }

    @Override
    public boolean isValid(Position position) {
        return position.x >= 0 && position.x < xMax && position.y >= 0 && position.y < yMax;
    }

    @Override
    public Element getElementAt(Position position) {
        return arena[position.x][position.y];
    }

    @Override
    public Element getElementAt(int line, int column) {
        return getElementAt(new Position(column, line));
    }

    @Override
    public int getMaxX() {
        return xMax;
    }

    @Override
    public int getMaxY() {
        return yMax;
    }

    public boolean isGameOver() {
        return player.isDead();
    }
}
