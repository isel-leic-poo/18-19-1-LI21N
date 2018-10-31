package isel.poo.robots.model;

import isel.poo.robots.model.elements.Element;
import isel.poo.robots.model.elements.JunkPile;
import isel.poo.robots.model.elements.Player;
import isel.poo.robots.model.elements.Robot;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Arena {

    private final Player player;
    private final List<JunkPile> junkPiles;
    private final List<Robot> robots;

    private Element[][] arena;

    private final int xUpperBound, yUpperBound;

    public Arena(int xUpperBound, int yUpperBound, ParticipantsProvider provider) {

        this.player = provider.getPlayer();
        this.junkPiles = provider.getJunkPiles();
        this.robots = provider.getRobots();

        this.xUpperBound = xUpperBound;
        this.yUpperBound = yUpperBound;

        arena = new Element[xUpperBound][yUpperBound];
        arena[player.getX()][player.getY()] = player;
        for (Element element : junkPiles) {
            arena[element.getX()][element.getY()] = element;
        }
        for (Element element : robots) {
            arena[element.getX()][element.getY()] = element;
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
        player.moveBy(direction);
    }

    public Element getElementAt(Position position) {
        return arena[position.x][position.y];
    }

    public Element getElementAt(int line, int column) {
        return getElementAt(new Position(column, line));
    }
}
