package isel.poo.console;

import java.util.LinkedList;

/**
 * View that additionally contains the list of children.<br/>
 * The paint() method calls the paint of each child.
 */
public class ParentView extends View {
    protected LinkedList<View> children = new LinkedList<>();

    public ParentView(int top, int left, int height, int width, int bkColor) {
        super(top,left,height,width,bkColor);
    }
    public ParentView(int top, int left, int bkColor) {
        super(top,left,bkColor);
    }
    public ParentView() { }

    /**
     * Adds view to child list
     * @param v The child view
     */
    @Override
    public void addView(View v) {
        super.addView(v);
        children.add(v);
    }

    /**
     * Paints all children
     */
    @Override
    public void paint() {
        for (View child : children) child.paint();
    }
}
