package isel.poo.robots.model;

import isel.poo.robots.model.elements.JunkPile;
import isel.poo.robots.model.elements.Player;
import isel.poo.robots.model.elements.Robot;

import java.util.List;

/**
 * Contract to be supported by classes that provide the initial participants of the game.
 */
public interface ParticipantsProvider {

    /**
     * Gets the player instance at its initial position.
     * @return the player instance
     */
    Player getPlayer();

    /**
     * Gets the list of initial junk piles.
     * @return the list of junk piles.
     */
    List<JunkPile> getJunkPiles();

    /**
     * Gets the list of initial robots.
     * @return the list of robots.
     */
    List<Robot> getRobots();
}

