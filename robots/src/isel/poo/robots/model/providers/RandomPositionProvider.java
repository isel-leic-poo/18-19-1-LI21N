package isel.poo.robots.model.providers;

import isel.poo.robots.model.ParticipantsProvider;
import isel.poo.robots.model.Position;
import isel.poo.robots.model.World;
import isel.poo.robots.model.elements.JunkPile;
import isel.poo.robots.model.elements.Player;
import isel.poo.robots.model.elements.Robot;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Provides the arena's initial participants through random positioning.
 */
public class RandomPositionProvider implements ParticipantsProvider {

    private static final Random random = new Random();
    private final int xMax, yMax;
    private final int junkPileCount, robotsCount;
    private Player player;
    private List<JunkPile> junkPiles;
    private List<Robot> robots;
    private List<Position> availablePositions;

    private static Player generatePlayer(int xMax, int yMax, List<Position> availablePositions, World world) {
        // TODO: Get a safe zone and remove those positions from the list of available ones
        final Position playerPosition = new Position(xMax / 2, yMax / 2);
        availablePositions.remove(playerPosition);
        return new Player(playerPosition, world);
    }

    private static List<Position> initializeAvailablePositions(int xMax, int yMax) {
        final LinkedList<Position> positions = new LinkedList<>();
        for(int x = 0; x < xMax; ++x) {
            for (int y = 0; y < yMax; y++) {
                positions.add(new Position(x, y));
            }
        }
        return positions;
    }

    private static Position generatePosition(List<Position> availablePositions) {
        return availablePositions.remove(random.nextInt(availablePositions.size()));
    }

    private static List<Robot> generateRobots(int robotsCount, List<Position> availablePositions, Player target, World world) {
        LinkedList<Robot> robots = new LinkedList<>();
        while (robotsCount-- > 0)
            robots.add(new Robot(generatePosition(availablePositions), target, world));
        return robots;
    }

    private static List<JunkPile> generateJunkPiles(int junkPileCount, List<Position> availablePositions) {
        LinkedList<JunkPile> junk = new LinkedList<>();
        while (junkPileCount-- > 0)
            junk.add(new JunkPile(generatePosition(availablePositions)));
        return junk;
    }

    /**
     * Helper method used to verify if the random generation of the participants is possible with the given arguments.
     * @param xMax the maximum X coordinate.
     * @param yMax the maximum Y coordinate.
     * @param junkPileCount the number of junk piles to be generated.
     * @param robotsCount the number of robots to be generated.
     */
    private static void checkArgumentsSanity(int xMax, int yMax, int junkPileCount, int robotsCount) {
        if (xMax <= 0 || yMax <= 0 || junkPileCount < 0 || robotsCount < 0)
            throw new IllegalArgumentException();

        int totalAvailablePositions = (xMax + 1) * (yMax + 1);
        if (junkPileCount + robotsCount + 1 >= totalAvailablePositions)
            throw new IllegalArgumentException();
    }

    /**
     * Initiates the provider with the given parameters.
     * @param xMax the maximum X value.
     * @param yMax the maximum Y value.
     * @param junkPileCount the initial number of junk piles.
     * @param robotsCount the initial number of robots.
     */
    public RandomPositionProvider(int xMax, int yMax, int junkPileCount, int robotsCount) {
        checkArgumentsSanity(xMax, yMax, junkPileCount, robotsCount);
        this.xMax = xMax;
        this.yMax = yMax;
        this.junkPileCount = junkPileCount;
        this.robotsCount = robotsCount;
        this.availablePositions = initializeAvailablePositions(xMax, yMax);
    }

    @Override
    public Player getPlayer(World world) {
        if (player == null)
            player = generatePlayer(xMax, yMax, availablePositions, world);
        return player;
    }

    @Override
    public List<JunkPile> getJunkPiles(World world) {
        if (junkPiles == null)
            junkPiles = generateJunkPiles(junkPileCount, availablePositions);
        return junkPiles;
    }

    @Override
    public List<Robot> getRobots(World world) {
        if (robots == null)
            robots = generateRobots(robotsCount, availablePositions, player, world);
        return robots;
    }
}
