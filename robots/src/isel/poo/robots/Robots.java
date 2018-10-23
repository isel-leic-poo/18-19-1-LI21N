package isel.poo.robots;

import isel.leic.pg.Console;
import isel.poo.console.Window;
import isel.poo.console.tile.TilePanel;
import isel.poo.robots.model.Arena;
import isel.poo.robots.model.ParticipantsProvider;
import isel.poo.robots.model.elements.Element;
import isel.poo.robots.model.elements.JunkPile;
import isel.poo.robots.model.elements.Player;
import isel.poo.robots.model.elements.Robot;
import isel.poo.robots.model.providers.RandomPositionProvider;
import isel.poo.robots.view.CellTile;

import java.awt.event.KeyEvent;
import java.util.Iterator;

public class Robots {

    private static final int WINDOW_WIDTH = 30, WINDOW_HEIGHT = 30;

    private final int width, height;
    private final Arena model;
    private final Window window;

    public Robots() {
        width = WINDOW_WIDTH - 4;
        height = WINDOW_HEIGHT - 4;
        window = new Window("Robots", height, width);
        window.clear();
        final ParticipantsProvider provider = new RandomPositionProvider(width, height, 0, 30);
        model = new Arena(width, height, provider);
    }

    public void run() {

        final TilePanel arenaView = new TilePanel(height,width,1);
        window.setContent(arenaView);
        arenaView.center(height, width);

        for (Element element: model) {
            arenaView.setTile(
                    element.getY(), element.getX(), new CellTile(element));
        }

        while(true) {
            int key = Console.waitKeyPressed(0);
            switch (key) {
                case KeyEvent.VK_ESCAPE:
                    window.close();
                    return;
            }
        }
    }
}
