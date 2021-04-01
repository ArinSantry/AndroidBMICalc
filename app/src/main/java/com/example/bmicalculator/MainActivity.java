package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    public static BMICalc bmiCalc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bmiCalc = new BMICalc();
        setContentView(R.layout.activity_main);
    }

    public void onStart()
    {
        // update the view when the app starts
        super.onStart();
        updateView();
    }

    public void updateView()
    {
        // set te weight
        TextView weightTV = (TextView) findViewById(R.id.weight);
        weightTV.setText("" + bmiCalc.getWeight());
        // set the height
        TextView heightTV = (TextView) findViewById(R.id.height);
        heightTV.setText("" + bmiCalc.getHeight());
        // set the BMI (numeric value)
        TextView bmiTV = (TextView) findViewById(R.id.bmi);
        bmiTV.setText(bmiCalc.getFormattedBMI());
        // set the BMI class (under/healthy/over weight)
        TextView bmiResultTV = (TextView) findViewById(R.id.bmiResult);
        bmiResultTV.setText(bmiCalc.getBMIResult());
    }

    public void modifyData(View v)
    {
        // change view to modify data screen
        Intent myIntent = new Intent(this, DataActivity.class);
        startActivity(myIntent);
    }
}
