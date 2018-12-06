package isel.adeetc.pdm.helloAndroid;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class MainActivity extends Activity {

    private static final float MSG_TEXT_SIZE = 30, BUTTON_TEXT_SIZE = 30;
    private Counter counter;
    private TextView messageBox;
    private MyCustomView customView;

    private void updateView(int counterValue) {
        messageBox.setText(Integer.toString(counterValue));
        customView.setValue(counterValue);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        counter = new Counter();
        counter.addChangeListener(new Counter.ChangeListener() {
            @Override
            public void counterValueChanged(Counter source, int newValue) {
                updateView(newValue);
            }
        });

        messageBox = new TextView(this);
        messageBox.setTextSize(MSG_TEXT_SIZE);

        final LinearLayout buttonPanel = new LinearLayout(this);
        buttonPanel.setOrientation(LinearLayout.HORIZONTAL);

        final Button plusButton = new Button(this);
        plusButton.setText("+");
        plusButton.setTextSize(BUTTON_TEXT_SIZE);

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter.increment();
            }
        });

        final Button minusButton = new Button(this);
        minusButton.setText("-");
        minusButton.setTextSize(BUTTON_TEXT_SIZE);
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter.decrement();
            }
        });

        buttonPanel.addView(plusButton);
        buttonPanel.addView(minusButton);

        final LinearLayout rootPanel = new LinearLayout(this);
        rootPanel.setOrientation(LinearLayout.VERTICAL);

        rootPanel.addView(messageBox);
        rootPanel.addView(buttonPanel);

        customView = new MyCustomView(this);
        rootPanel.addView(customView);
        updateView(counter.getValue());

        customView.setOnSwipeListener(new MyCustomView.OnSwipeListener() {
            @Override
            public boolean onSwipeUp(View source) {
                counter.increment();
                return true;
            }

            @Override
            public boolean onSwipeDown(View source) {
                counter.decrement();
                return true;
            }
        });

        setContentView(rootPanel);
    }
}
