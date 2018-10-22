package isel.poo.robots.model.providers;

import isel.poo.robots.model.ParticipantsProvider;
import isel.poo.robots.model.Position;
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

    private static Player generatePlayer(int xMax, int yMax, List<Position> availablePositions) {
        // TODO: Get a safe zone and remove those positions from the list of available ones
        final Position playerPosition = new Position(xMax / 2, yMax / 2);
        availablePositions.remove(playerPosition);
        return new Player(playerPosition);
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

    private static List<Robot> generateRobots(int robotsCount, List<Position> availablePositions) {
        LinkedList<Robot> robots = new LinkedList<>();
        while (robotsCount-- > 0)
            robots.add(new Robot(generatePosition(availablePositions)));
        return robots;
    }

    private static List<JunkPile> generateJunkPiles(int junkPileCount, List<Position> availablePositions) {
        LinkedList<JunkPile> junk = new LinkedList<>();
        while (junkPileCount-- > 0)
            junk.add(new JunkPile(generatePosition(availablePositions)));
        return junk;
    }

    private final Player player;
    private final List<JunkPile> junkPiles;
    private final List<Robot> robots;

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

        List<Position> availablePositions = initializeAvailablePositions(xMax, yMax);
        player = generatePlayer(xMax, yMax, availablePositions);
        robots = generateRobots(robotsCount, availablePositions);
        junkPiles = generateJunkPiles(junkPileCount, availablePositions);
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public List<JunkPile> getJunkPiles() {
        return junkPiles;
    }

    @Override
    public List<Robot> getRobots() {
        return robots;
    }
}
