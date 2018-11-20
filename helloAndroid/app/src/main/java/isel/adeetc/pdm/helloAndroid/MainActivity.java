package isel.adeetc.pdm.helloAndroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    private int counterValue = 0;
    private static final float MSG_TEXT_SIZE = 30, BUTTON_TEXT_SIZE = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final TextView messageBox = new TextView(this);
        messageBox.setText(Integer.toString(counterValue));
        messageBox.setTextSize(MSG_TEXT_SIZE);

        final LinearLayout buttonPanel = new LinearLayout(this);
        buttonPanel.setOrientation(LinearLayout.HORIZONTAL);

        final Button plusButton = new Button(this);
        plusButton.setText("+");
        plusButton.setTextSize(BUTTON_TEXT_SIZE);

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterValue += 1;
                messageBox.setText(Integer.toString(counterValue));
            }
        });


        final Button minusButton = new Button(this);
        minusButton.setText("-");
        minusButton.setTextSize(BUTTON_TEXT_SIZE);
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterValue -= 1;
                messageBox.setText(Integer.toString(counterValue));
            }
        });

        buttonPanel.addView(plusButton);
        buttonPanel.addView(minusButton);

        final LinearLayout rootPanel = new LinearLayout(this);
        rootPanel.setOrientation(LinearLayout.VERTICAL);

        rootPanel.addView(messageBox);
        rootPanel.addView(buttonPanel);

        setContentView(rootPanel);
    }
}
