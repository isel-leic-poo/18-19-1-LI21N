package isel.poo.console.tile;

import isel.poo.console.View;

/**
 * Base class hierarchy of Tiles
 */
public abstract class Tile extends View {

    public void setBackground(int color) { bkColor = color; }
    @Override
    public void paint() { }
}
