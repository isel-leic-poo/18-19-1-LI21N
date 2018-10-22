package isel.poo.robots.view;

import isel.leic.pg.Console;
import isel.poo.console.tile.Tile;
import isel.poo.robots.model.elements.Element;
import isel.poo.robots.model.elements.JunkPile;
import isel.poo.robots.model.elements.Robot;

public class CellTile extends Tile {

    private final Element element;

    public CellTile() {
        this(null);
    }

    public CellTile(Element element) {
        this.element = element;
        setSize(1, 1);
    }

    @Override
    public void paint() {
        super.paint();
        if (element == null) printEmptyTile();
        else printElementTile();
    }

    private void printElementTile() {
        // This is ugly (breaks, for instance, the OCP principle). You can do better... ;)
        char elementSymbol = '@';
        int color = Console.BLACK;
        if (element instanceof Robot)
            elementSymbol = '+';
        else if (element instanceof JunkPile)
            elementSymbol = '*';

        Console.setBackground(color);
        print(0, 0, elementSymbol);
    }

    private void printEmptyTile() {
        print(0, 0, ' ');
    }
}
