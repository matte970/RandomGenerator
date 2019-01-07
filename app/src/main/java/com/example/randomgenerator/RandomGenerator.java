package com.example.randomgenerator;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.Random;

public class RandomGenerator extends AppCompatActivity {

    int randomNumber;
    long lastRandomTime;
    long counter;
    long difference;
    long delayTime = 1000;
    String name;
    String number;
    TextView O2Values = (TextView) findViewById(R.id.O2Values);
    CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_generator);
        lastRandomTime = 900;
        counter = 0;
    }

    {
        difference = SystemClock.uptimeMillis() - lastRandomTime;

        if (difference == delayTime) {
            Random r = new Random();
            if (!checkBox.isChecked()) {
                randomNumber = r.nextInt(101 - 90) + 90;
            } else {
                randomNumber = r.nextInt(91 - 60) + 60;
            }

            lastRandomTime = SystemClock.uptimeMillis(); //Systemlaufzeit
            counter++;
            number = Long.toString(counter);
            name = "RandomNumber" + number;

            OxyValues OxyValues = new OxyValues(randomNumber,System.currentTimeMillis());


            O2Values.setText(randomNumber);
        }
    }

}
