package isel.poo.robots;

import isel.leic.pg.Console;
import isel.poo.console.Window;
import isel.poo.console.tile.TilePanel;
import isel.poo.robots.model.Arena;
import isel.poo.robots.model.Direction;
import isel.poo.robots.model.ParticipantsProvider;
import isel.poo.robots.model.Position;
import isel.poo.robots.model.elements.Actor;
import isel.poo.robots.model.elements.Element;
import isel.poo.robots.model.elements.Robot;
import isel.poo.robots.model.providers.RandomPositionProvider;
import isel.poo.robots.view.CellTile;

import java.awt.event.KeyEvent;

public class Robots {

    private static final int WINDOW_WIDTH = 30, WINDOW_HEIGHT = 30;

    private final int width, height;
    private final Arena model;
    private final Window window;
    private final DirectionKeyMap keyMap;

    public Robots() {
        width = WINDOW_WIDTH - 4;
        height = WINDOW_HEIGHT - 4;
        window = new Window("Robots", height, width);
        window.clear();
        final ParticipantsProvider provider = new RandomPositionProvider(width, height, 0, 1);
        model = new Arena(width, height, provider);
        keyMap = new DirectionKeyMap();
    }

    public void run() {

        final TilePanel arenaView = new TilePanel(height,width,1);
        window.setContent(arenaView);
        arenaView.center(height, width);

        for (int column = 0; column < width; ++column) {
            for (int line = 0; line < height; ++line) {
                Element element = model.getElementAt(line, column);
                arenaView.setTile(line, column, new CellTile(element));
            }
        }

        initBehaviour(arenaView);

        while(true) {
            int key = Console.waitKeyPressed(0);
            Direction direction = null;
            switch (key) {
                case KeyEvent.VK_ESCAPE:
                    window.close();
                    return;
                case KeyEvent.VK_S:
                    model.jumpPlayer();
                    break;
                default:
                    direction = keyMap.getDirection(key);
                    break;
            }

            Console.waitKeyReleased(key);

            if (direction != null) {
                model.movePlayer(direction);
                if (model.isGameOver()) {
                    System.out.println("Game Over");
                    window.close();
                    return;
                }
            }
        }
    }

    private void initBehaviour(TilePanel arenaView) {
        Actor.StateChangeListener listener = new Actor.StateChangeListener() {
            @Override
            public void positionChanged(Actor source, Position oldPosition, Position newPosition) {
                arenaView.setTile(oldPosition.y, oldPosition.x, new CellTile(null));
                arenaView.setTile(newPosition.y, newPosition.x, new CellTile(source));
            }
        };

        model.getPlayer().addListener(listener);
        for (Robot robot : model.getRobots()) {
            robot.addListener(listener);
        }
    }
}
