package isel.poo.robots.model;

import isel.poo.robots.model.elements.JunkPile;
import isel.poo.robots.model.elements.Player;
import isel.poo.robots.model.elements.Robot;

import java.util.Collections;
import java.util.List;

public class Arena {

    private final Player player;
    private final List<JunkPile> junkPiles;
    private final List<Robot> robots;

    private final int xUpperBound, yUpperBound;

    public Arena(int xUpperBound, int yUpperBound, ParticipantsProvider provider) {

        this.player = provider.getPlayer();
        this.junkPiles = provider.getJunkPiles();
        this.robots = provider.getRobots();

        this.xUpperBound = xUpperBound;
        this.yUpperBound = yUpperBound;
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
}
