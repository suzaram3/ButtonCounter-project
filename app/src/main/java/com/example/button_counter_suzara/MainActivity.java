package com.example.button_counter_suzara;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private final String TAG="MainActivity";
    private Button incrementButton;
    private Button decrementButton;
    private Button resetButton;
    private Button randomButton;
    private TextView display;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.displayID);
        incrementButton = findViewById(R.id.incrementButton);
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementCount();
            }
        });
        decrementButton = findViewById(R.id.decrementButton);
        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrementCount();
            }
        });
        resetButton = findViewById(R.id.resetButton);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetCount();
            }
        });
        randomButton = findViewById(R.id.randomButton);
        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomNumber();
            }
        });
    }
    // function to get random number
    private void randomNumber() {
        Random random = new Random();
        int randomInteger = random.nextInt(100);
        display.setText(String.valueOf(randomInteger));
    }
    // function to initialize counter and reset
    private void resetCount() {
        count = 0;
        display.setText(String.valueOf(count));
    }
    // function to increment the count variable
    private void incrementCount() {
        int currentValue = Integer.parseInt(display.getText().toString());
        currentValue++;
        display.setText(String.valueOf(currentValue));
    }
    // function to decrement the count variable
    private void decrementCount() {
        int currentValue = Integer.parseInt(display.getText().toString());
        currentValue--;
        display.setText(String.valueOf(currentValue));
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String counterValue = display.getText().toString();
        outState.putString("display", counterValue);
    }
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String counterValue = savedInstanceState.getString("display");
        display.setText(counterValue);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
    }
    @Override
    protected void onStart() {
        super.onStart();
    }
    @Override
    protected void onStop() {
        super.onStop();
    }
}