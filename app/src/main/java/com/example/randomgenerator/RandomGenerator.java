package com.example.randomgenerator;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;

import java.util.Random;

public class RandomGenerator extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_generator);
    }

    Handler handler = new Handler();

    private Runnable runnableCode = new Runnable() {
        @Override
        /**
         * Code running periodically
         * */
        public void run() {

            Random r = new Random();
            Switch critical = (Switch) findViewById(R.id.switch1);
            TextView O2Values = (TextView) findViewById(R.id.O2Values);
            /**
             * Checks for mode (stable/critical) and assigns a Value for y-axis
             */
            int randomNumber;
            if (!critical.isChecked()) {
                randomNumber = r.nextInt(11) + 90;
            } else {
                randomNumber = r.nextInt(31) + 60;
            }

            /**
             * Assigns value for x-axis using the app timestamp in Unix time
             * */

            OxyValues OxyValues = new OxyValues(randomNumber, System.currentTimeMillis());

            /**
             * Displays a Toast whit the x and y values
             * */

            Toast check = Toast.makeText(getApplicationContext(), "" + OxyValues.getValue() + "  " + OxyValues.getTime(), Toast.LENGTH_SHORT);
            check.show();

            O2Values.setText("" + OxyValues.getValue());


            /**
             * Repeat this the same runnable code block again another 2 seconds
             */

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


