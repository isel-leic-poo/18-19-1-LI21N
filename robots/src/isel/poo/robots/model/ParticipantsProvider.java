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
     * Gets the player instance at its initial position on the given world.
     * @param world the world where the player will live in.
     * @return the player instance
     */
    Player getPlayer(World world);

    /**
     * Gets the list of initial junk piles on the given world
     * @param world the world where the junk piles will exist.
     * @return the list of junk piles.
     */
    List<JunkPile> getJunkPiles(World world);

    /**
     * Gets the list of initial robots.
     * @param world the world where the robots will exist.
     * @return the list of robots.
     */
    List<Robot> getRobots(World world);
}

