package isel.poo.robots;

import isel.poo.robots.model.Direction;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class DirectionKeyMap {

    private final Map<Integer, Direction> keyMap;

    public DirectionKeyMap() {
        keyMap = new HashMap<>();
        keyMap.put(KeyEvent.VK_W, Direction.N);
        keyMap.put(KeyEvent.VK_Q, Direction.NW);
        keyMap.put(KeyEvent.VK_A, Direction.W);
        keyMap.put(KeyEvent.VK_Z, Direction.SW);
        keyMap.put(KeyEvent.VK_X, Direction.S);
        keyMap.put(KeyEvent.VK_C, Direction.SE);
        keyMap.put(KeyEvent.VK_D, Direction.E);
        keyMap.put(KeyEvent.VK_E, Direction.NE);
    }

    public Direction getDirection(int key) {
        return keyMap.get(key);
    }
}
