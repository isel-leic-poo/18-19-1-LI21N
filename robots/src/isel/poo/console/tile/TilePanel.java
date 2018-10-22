package isel.poo.console.tile;

import isel.poo.console.ParentView;
import isel.poo.console.View;
import isel.leic.pg.Console;
import isel.leic.pg.Location;

public class TilePanel extends ParentView {
    private final Tile[][] tiles;
    private final int side;

    public TilePanel(int tilesHeight, int tilesWidth, int tileSide) {
        super(0,0, Console.BLACK);
        tiles = new Tile[tilesHeight][tilesWidth];
        side = tileSide;
        height = tilesHeight * side;
        width = tilesWidth * side;
    }

    public Location getModelPosition(int line, int col) {
        assert(parent==null);
        int l = (line-top) / side;
        int c = (col-left) / side;
        return  (l<0 || c<0 || l >= tiles.length || c>= tiles[0].length) ? null : new Location(l , c);
    }

    public void setTile(int l, int c, Tile t) {
        Tile old = tiles[l][c];
        if (old!=null) children.remove(old);
        tiles[l][c] = t;
        addTile(l, c, t);
        t.repaint();
    }

    private void addTile(int l, int c, Tile t) {
        addView(t);
        t.setOrig(l * side, c * side);
        t.setBackground(l%2==0 && c%2!=0 || l%2!=0 && c%2==0 ? Console.GRAY:Console.LIGHT_GRAY);
    }

    public Tile getTile(int l, int c) {
        return tiles[l][c];
    }
}
