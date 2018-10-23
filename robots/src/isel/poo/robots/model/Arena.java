package isel.poo.robots.model;

import isel.poo.robots.model.elements.Element;
import isel.poo.robots.model.elements.JunkPile;
import isel.poo.robots.model.elements.Player;
import isel.poo.robots.model.elements.Robot;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Arena implements Iterable<Element> {

    private static class ElementsIterator implements Iterator<Element> {

        private final Iterator<Element> iterator;

        ElementsIterator(List<Element> elements) {
            this.iterator = elements.iterator();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Element next() {
            return iterator.next();
        }
    }

    private final Player player;
    private final List<JunkPile> junkPiles;
    private final List<Robot> robots;
    private final List<Element> participants;

    private final int xUpperBound, yUpperBound;

    public Arena(int xUpperBound, int yUpperBound, ParticipantsProvider provider) {

        this.player = provider.getPlayer();
        this.junkPiles = provider.getJunkPiles();
        this.robots = provider.getRobots();

        final List<Element> allElements = new LinkedList<>();
        allElements.addAll(junkPiles);
        allElements.addAll(robots);
        allElements.add(player);

        this.participants = allElements;

        this.xUpperBound = xUpperBound;
        this.yUpperBound = yUpperBound;
    }

    public Player getPlayer() {
        return player;
    }

    public List<JunkPile> getJunkPiles() {
        return Collections.unmodifiableList(junkPiles);
    }

    public List<Robot> getRobots() {
        return Collections.unmodifiableList(robots);
    }

    @Override
    public Iterator<Element> iterator() {
        return new ElementsIterator(participants);
    }
}
