package com.example.bmicalculator;

import android.content.Context;

import java.text.DecimalFormat;

public class BMICalc {

    DecimalFormat BMI = new DecimalFormat("##.0");
    private float height;
    private float weight;
    private float bmi;

    public BMICalc()
    {
        setHeight(1.5f);
        setWeight(50f);
    }

    public void setHeight(float newHeight)
    {
        if (newHeight >= 0)
            height = newHeight;
    }

    public void setWeight(float newWeight)
    {
        if (newWeight >= 0)
            weight = newWeight;
    }

    public float getHeight()
    {
        return height;
    }

    public float getWeight()
    {
        return weight;
    }

    public float getBMI()
    {
        bmi = weight / (height * height);
        return bmi;
    }

    public String getFormattedBMI()
    {
        return BMI.format(getBMI());
    }

    public String getBMIResult()
    {
        if (bmi <= 18.5f)
            return "Underweight";
        else if (bmi <= 24.9f)
            return "Healthy weight";
        else if (bmi <= 29.9f)
            return "Overweight";
        else
            return "Obese";
    }
}
