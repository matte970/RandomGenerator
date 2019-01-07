package com.example.randomgenerator;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;

import java.util.Random;

public class RandomGenerator extends AppCompatActivity {

    /**
     * int randomNumber;
     * long lastRandomTime;
     * long counter;
     * long difference;
     * long delayTime = 1000;
     * String name;
     * String number;
     * TextView O2Values = (TextView) findViewById(R.id.O2Values);
     * CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox);
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_generator);
        /** lastRandomTime = 900;
         counter = 0;*/
    }

    Handler handler = new Handler();

    private Runnable runnableCode = new Runnable() {
        @Override
        public void run() {

            Random r = new Random();
            Switch critical = (Switch) findViewById(R.id.switch1);
            TextView O2Values = (TextView) findViewById(R.id.O2Values);

            int randomNumber;
            if (!critical.isChecked()) {
                randomNumber = r.nextInt(11) + 90;
            } else {
                randomNumber = r.nextInt(31) + 60;
            }

            OxyValues OxyValues = new OxyValues(randomNumber, System.currentTimeMillis());
            Toast check = Toast.makeText(getApplicationContext(), "" + OxyValues.getValue(), Toast.LENGTH_SHORT);
            check.show();

            O2Values.setText("" + OxyValues.getValue());


            // Repeat this the same runnable code block again another 2 seconds
            // 'this' is referencing the Runnable object
            handler.postDelayed(this, 4000);
        }

    };

    public void startGenerator(android.view.View next) {

        handler.post(runnableCode);

    }

    public void stopGenerator(android.view.View next) {

        handler.removeCallbacks(runnableCode);

    }
}


/**
 * {
 * while (counter < 500) {
 * difference = SystemClock.uptimeMillis() - lastRandomTime;
 * <p>
 * if (difference == delayTime) {
 * Random r = new Random();
 * if (!checkBox.isChecked()) {
 * randomNumber = r.nextInt(101 - 90) + 90;
 * } else {
 * randomNumber = r.nextInt(91 - 60) + 60;
 * }
 * <p>
 * lastRandomTime = SystemClock.uptimeMillis(); //Systemlaufzeit
 * counter++;
 * number = Long.toString(counter);
 * name = "RandomNumber" + number;
 * <p>
 * OxyValues OxyValues = new OxyValues(randomNumber, System.currentTimeMillis());
 * <p>
 * <p>
 * O2Values.setText(OxyValues.getValue());
 * }
 * }
 * }
 */


