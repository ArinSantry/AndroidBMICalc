package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class DataActivity extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        updateView(); // update data when activity starts
    }

    public void updateView()
    {
        BMICalc bmiCalc = MainActivity.bmiCalc;
        // update view to current values
        EditText heightET = (EditText) findViewById(R.id.data_height);
        heightET.setText("" + bmiCalc.getHeight());
        EditText weightET = (EditText) findViewById(R.id.data_weight);
        weightET.setText("" + bmiCalc.getWeight());
    }

    public void updateBMIObject()
    {
        BMICalc bmiCalc = MainActivity.bmiCalc;
        // get height input
        EditText heightET = (EditText) findViewById(R.id.data_height);
        String heightString = heightET.getText().toString();
        // get weight input
        EditText weightET = (EditText) findViewById(R.id.data_weight);
        String weightString = weightET.getText().toString();
        // try to set height and weight to inputted values
        try
        {
            float height = Float.parseFloat(heightString);
            bmiCalc.setHeight(height);
            float weight = Float.parseFloat(weightString);
            bmiCalc.setWeight(weight);
        }
        // if failed, reset to default values
        catch (NumberFormatException nfe)
        {
            bmiCalc.setHeight(1.5f);
            bmiCalc.setWeight(50f);
        }
    }

    public void goBack(View v)
    {
        // end this activity and return to main activity
        updateBMIObject();
        this.finish();
    }
}
