package isel.adeetc.pdm.helloAndroid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class MyCustomView extends View {

    @SuppressLint("ClickableViewAccessibility")
    private void initBehaviour() {
        this.setOnTouchListener(new View.OnTouchListener() {
            MotionEvent.PointerCoords coords = new MotionEvent.PointerCoords();
            int startY;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getPointerCount() != 1)
                    return false;

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    event.getPointerCoords(0, coords);
                    startY = (int) coords.y;
                }
                else {
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        event.getPointerCoords(0, coords);
                        int endY = (int) coords.y;
                        if (endY - startY > 0 ) fireOnSwipeDown();
                        else fireOnSwipeUp();

                    }
                }

                return true;

            }
        });
    }

    interface OnSwipeListener {
        boolean onSwipeUp(View source);
        boolean onSwipeDown(View source);
    }

    private OnSwipeListener listener;

    private void fireOnSwipeUp() {
        if (listener != null)
            listener.onSwipeUp(MyCustomView.this);
    }

    private void fireOnSwipeDown() {
        if (listener != null)
            listener.onSwipeDown(MyCustomView.this);
    }

    private int currentValue;
    private final Paint brush;

    public MyCustomView(Context context) {
        super(context);
        brush = new Paint();
        brush.setStrokeWidth(3);
        brush.setColor(Color.RED);
        initBehaviour();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int computedY = this.getHeight() / 2 - currentValue * 30;
        canvas.drawLine(0, computedY, this.getWidth(), computedY, brush);
    }

    public void setValue(int value) {
        currentValue = value;
        this.invalidate();
    }

    public void setOnSwipeListener(OnSwipeListener listener) {
        this.listener = listener;
    }
}
