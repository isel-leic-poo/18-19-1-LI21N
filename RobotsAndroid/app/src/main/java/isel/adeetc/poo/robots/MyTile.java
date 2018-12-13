package isel.adeetc.poo.robots;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import pt.isel.poo.tile.Tile;

class MyTile implements Tile {

    private final Paint brush;
    private final boolean state;

    public MyTile(boolean someState) {
        brush = new Paint();
        brush.setColor(Color.RED);
        brush.setStrokeWidth(5);
        state = someState;
    }

    @Override
    public void draw(Canvas canvas, int side) {
        if (state)
            canvas.drawLine(0, 0, side, side, brush);
        else
            canvas.drawLine(side, 0, 0, side, brush);
    }

    @Override
    public boolean setSelect(boolean selected) {
        return false;
    }

    public boolean getState() {
        return state;
    }
}
