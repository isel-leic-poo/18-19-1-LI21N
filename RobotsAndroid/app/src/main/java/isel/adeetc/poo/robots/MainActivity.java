package isel.adeetc.poo.robots;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import pt.isel.poo.tile.Img;
import pt.isel.poo.tile.OnTileTouchListener;
import pt.isel.poo.tile.Tile;
import pt.isel.poo.tile.TilePanel;
import pt.isel.poo.tile.TileView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TilePanel panel = findViewById(R.id.panel);
        for(int hIdx = 0; hIdx < panel.getHeightInTiles(); ++hIdx)
            for(int wIdx = 0; wIdx < panel.getWidthInTiles(); ++wIdx)
                panel.setTile(wIdx, hIdx, new MyTile((hIdx + wIdx) % 2 == 0));

        panel.setTile(0, 0, new ImageTile(new Img(this, R.drawable.robot)));
        panel.setListener(new OnTileTouchListener() {
            @Override
            public boolean onClick(int xTile, int yTile) {
                final MyTile clickedTile = (MyTile) panel.getTile(xTile, yTile);
                panel.setTile(xTile, yTile, new MyTile(!clickedTile.getState()));
                return true;
            }

            @Override
            public boolean onDrag(int xFrom, int yFrom, int xTo, int yTo) {
                return false;
            }

            @Override
            public void onDragEnd(int x, int y) { }

            @Override
            public void onDragCancel() { }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
