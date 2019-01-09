package com.example.randomgenerator;

import android.content.Intent;
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

    int value;

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
            boolean b;
            randomNumber = r.nextInt(4) + 0;
            b = r.nextBoolean();

            if (b) {
                value += randomNumber;
            } else {
                value -= randomNumber;
            }

            if (!critical.isChecked()) {
                if (value > 100 || value < 90) {
                    value = 95;
                }
            } else {
                if (value > 90 || value < 60) {
                    value = 89;
                }
            }

            /**
             * Assigns value for x-axis using the app timestamp in Unix time
             * */
            long time = System.currentTimeMillis();
            OxyValues OxyValues = new OxyValues(value, time);

            /**
             * Displays a Toast whit the x and y values
             * */

//            Toast check = Toast.makeText(getApplicationContext(), "" + OxyValues.getValue() + "  " + OxyValues.getTime(), Toast.LENGTH_SHORT);
//            check.show();
            /**
             * Displays the Value on the screen
             * */
            O2Values.setText("" + OxyValues.getValue());

            /**
             * Sends an Intent with the attributes of @link OxyValues as a broadcast
             *  */
            Intent intent = new Intent();
            intent.setAction("PulsOXyMax");
            intent.putExtra("Ox", OxyValues);
            intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
            sendBroadcast(intent);


            /**
             * Repeat this the same runnable code block again another 4 seconds
             */

            handler.postDelayed(this, 4000);
        }

    };

    public void startGenerator(android.view.View next) {

        handler.post(runnableCode);
        value = 95;


    }

    public void stopGenerator(android.view.View next) {

        handler.removeCallbacks(runnableCode);

    }
}


