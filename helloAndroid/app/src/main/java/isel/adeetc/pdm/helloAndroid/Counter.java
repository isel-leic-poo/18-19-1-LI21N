package isel.adeetc.pdm.helloAndroid;

import java.util.LinkedList;
import java.util.List;

public class Counter {

    interface ChangeListener {
        void counterValueChanged(Counter source, int newValue);
    }

    private int counterValue = 0;
    private List<ChangeListener> listeners = new LinkedList<>();

    private void fireChangeEvent() {
        for (ChangeListener listener : listeners) {
            listener.counterValueChanged(this, counterValue);
        }
    }

    public void addChangeListener(ChangeListener listener) {
        listeners.add(listener);
    }

    public void removeChangeListener(ChangeListener listener) {
        listeners.remove(listener);
    }

    public int getValue() {
        return counterValue;
    }

    public void increment() {
        counterValue += 1;
        fireChangeEvent();
    }

    public void decrement() {
        counterValue -= 1;
        fireChangeEvent();
    }
}
