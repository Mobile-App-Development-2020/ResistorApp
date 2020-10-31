package com.example.resistorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    //Global variable initialisation
    String spinner1Selection, spinner2Selection, spinner3Selection, spinner4Selection, band1, band2, multiplier, tolerance, symbol;
    TextView FinalResult, colour1, colour2, colour3, colour4, LowerLimit, HigherLimit;
    int bandColour,  backgroundColor;
    boolean gigaOhms, megaOhms, kiloOhms = false;
    boolean missingValue, black;
    double lowerLimit, higherLimit;
    Spinner spinner1, spinner2, spinner3, spinner4;
    String empty = "1 + 2 + 3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //General code that is generated on project creation
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //region $TextViews
            LowerLimit =  findViewById(R.id.tvLower);
            FinalResult =  findViewById(R.id.tester);
            HigherLimit =  findViewById(R.id.tvHigher);
            colour1 = findViewById(R.id.tvColour1);
            colour2 = findViewById(R.id.tvColour2);
            colour3 = findViewById(R.id.tvColour3);
            colour4 = findViewById(R.id.tvColour4);
        //endregion TextViews

        //region $Spinners
            //store the spinner from the XML
         spinner1 = findViewById(R.id.spinner1);
         spinner2 = findViewById(R.id.spinner2);
         spinner3 = findViewById(R.id.spinner3);
         spinner4 = findViewById(R.id.spinner4);


          DoSpinners();
    }




    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //store the text of the item the user selects
        String text = parent.getItemAtPosition(position).toString();
        doSpinnerColour(position);
        //store the parent spinner that the selection came from and compare its ID with all four spinners and their IDs to determine which on which spinner the selection was made
            Spinner spinner = (Spinner) parent;
            if(spinner.getId() == R.id.spinner1)
            {
                //change to lowercase to prevent case mismatching
                spinner1Selection = text.toLowerCase();
                int FirstBand = doColour(spinner1Selection);
                colour1.setBackgroundResource(FirstBand);
                backgroundColor = doSpinnerColour(position);
                spinner1.setBackgroundResource(backgroundColor);
                if (backgroundColor == R.color.Black)
                {
                    TextView textView = (TextView) spinner1.getItemAtPosition(1);
                    textView.setTextColor(Color.parseColor("#FFFFFF"));
                }
            }
            else if(spinner.getId() == R.id.spinner2)
            {
                spinner2Selection = text.toLowerCase();
                int SecondBand = doColour(spinner2Selection);
                colour2.setBackgroundResource(SecondBand);
                backgroundColor = doSpinnerColour(position);
                spinner2.setBackgroundResource(backgroundColor);
            }
            else if(spinner.getId() == R.id.spinner3)
            {
                spinner3Selection = text.toLowerCase();
                int ThirdBand = doColour(spinner3Selection);
                colour3.setBackgroundResource(ThirdBand);
                backgroundColor = doSpinnerColour(position);
                spinner3.setBackgroundResource(backgroundColor);
            }
            else if(spinner.getId() == R.id.spinner4)
            {
                spinner4Selection = text.toLowerCase();
                int FourthBand = doColour(spinner4Selection);
                colour4.setBackgroundResource(FourthBand);
                backgroundColor = doSpinnerColour(position);
                spinner4.setBackgroundResource(backgroundColor);
            }
    }

    private int doSpinnerColour(int position) {
        switch (position)
        {
            case 1:
                backgroundColor = R.color.Black;
                break;
            case 2:
                backgroundColor = R.color.Brown;
                break;
            case 3:
                backgroundColor = R.color.Red;
                break;
            case 4:
                backgroundColor = R.color.Orange;
                break;
            case 5:
                backgroundColor = R.color.Yellow;
                break;
            case 6:
                backgroundColor = R.color.Green;
                break;
            case 7:
                backgroundColor = R.color.Blue;
                break;
            case 8:
                backgroundColor = R.color.Violet;
                break;
            case 9:
                backgroundColor = R.color.Grey;
                break;
            case 10:
                backgroundColor = R.color.White;
                break;
            case 11:
                backgroundColor = R.color.Gold;
                break;
            case 12:
                backgroundColor = R.color.Silver;
                break;

            default:
                backgroundColor = R.color.None;
        }
        return backgroundColor;
    }



    private void DoSpinners() {
        // An Adapter object acts as a bridge between an AdapterView and the underlying data for that view. The Adapter provides access to the data items.
        // The Adapter is also responsible for making a View for each item in the data set.
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.bands1And2Array, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.bands1And2Array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.numbers, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.numbers, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter3);
        spinner4.setOnItemSelectedListener(this);
        //endregion Spinners
    }

    //determines which colour the band should be coloured depending on the user's selection. It will return the integer value for that colour.
    private int  doColour(String spinnerSelection) {
        switch (spinnerSelection) {
            case "black":
                bandColour = R.color.Black;
                break;
            case "brown":
                bandColour = R.color.Brown;
                break;
            case "red":
                bandColour = R.color.Red;
                break;
            case "orange":
                bandColour = R.color.Orange;
                break;
            case "yellow":
                bandColour = R.color.Yellow;
                break;
            case "green":
                bandColour = R.color.Green;
                break;
            case "blue":
                bandColour = R.color.Blue;
                break;
            case "violet":
                bandColour = R.color.Violet;
                break;
            case "grey":
                bandColour = R.color.Grey;
                break;
            case "white":
                bandColour = R.color.White;
                break;
            case "gold":
                bandColour = R.color.Gold;
                break;
            case "silver":
                bandColour = R.color.Silver;
                break;
            case "none":
                missingValue = true;
                bandColour = R.color.None;
                break;
            default:
                // code block
        }
        return  bandColour;
    }
    
    public void doCalculate(View view) {
        //reset the bool that will flag the user that a spinner option was not selected
         missingValue = false;
        //get the value for the first band
         band1 = doBand1();
        //get the value for the second band
          band2 = doBand2();
        //get the value for the third band, the multiplier
          multiplier = doMultiplier();
        //get the value for the fourth band, the tolerance
           tolerance = doTolerance();
           double toleranceDouble = Double.parseDouble(tolerance);
        //combine the string values of band 1 and 2. We could have returned doubles here and multiplied the first band by 10 but this way came to me more naturally
        // When we convert the strings to doubles we get the correct values
          String combineBand1AndBand2 = band1 + band2;
        //Convert strings to doubles for use in calculations
        double band1And2 = Double.parseDouble(combineBand1AndBand2);
          double calcMultiplier = Double.parseDouble(multiplier);
        //calculate how many ohms the resistor has the capacity for
            double ohms = band1And2 * calcMultiplier;
        //Convert Ohms to Giga/Mega/KiloOhms if needed
            double ohmsCalculated = OhmsToKOhmsAndMOhms(ohms);
        //Convert the calculated result back to a string for outputting purposes
            String result = String.valueOf(ohmsCalculated);
        //Determine which symbol should be outputted with the calculated result
            symbol = doSymbol();
            lowerLimit = doLowerLimit(toleranceDouble,ohmsCalculated);
            higherLimit = doHigherLimit(toleranceDouble,ohmsCalculated);
        //Output the results to the user
            FinalResult.setText("Optimal Resistance : " + result + symbol);
            LowerLimit.setText("Lower Limit: " + lowerLimit + symbol);
            HigherLimit.setText( "Higher Limit: " + higherLimit + symbol);
        //Quick validation method to ensure that any of the spinners that need to be selected have been left unselected
            doMissing();
    }

    private double doHigherLimit(double toleranceDouble, double ohmsCalculated) {
        higherLimit = ohmsCalculated + ((ohmsCalculated / 100) * toleranceDouble);
        higherLimit = Math.round(higherLimit * 100.0) / 100.0;
        return  higherLimit;
    }

    private double doLowerLimit(double toleranceDouble, double ohmsCalculated) {
        lowerLimit = ohmsCalculated - ((ohmsCalculated / 100) * toleranceDouble);
        lowerLimit = Math.round(lowerLimit * 100.0) / 100.0;
        return  lowerLimit;
    }

    //Convert the Ohms to Giga/Mega/KiloOhms if needed
        private double OhmsToKOhmsAndMOhms(double ohms) {
            if (ohms > 1000000000 )
            {
                ohms = ohms / 1000000000 ;
                gigaOhms = true;
            }
    
            else if (ohms > 1000000)
            {
                ohms = ohms / 1000000;

                megaOhms = true;
            }
            else if(ohms > 1000)
            {
                ohms = ohms / 1000;
                kiloOhms = true;
            }
            return ohms;
        }

    //determine which symbol should be outputted with the final result 
        private String doSymbol() {
            if(gigaOhms == true){
                symbol = "GΩ";
            }
            else if(megaOhms == true){
                symbol = "MΩ";
            }
            else if(kiloOhms == true){
                symbol = "KΩ";
            }
            else{
                symbol = "Ω";
            }
            return symbol;
        }

    //determine which value should be associated with the selection made on the first band/spinner
        private String doBand1() {
            switch(spinner1Selection) {
                case "black":
                case "gold":
                case "silver":
                    band1 = "0";
                    break;
                case "brown":
                    band1 = "1";
                    break;
                case "red":
                    band1 = "2";
                    break;
                case "orange":
                    band1 = "3";
                    break;
                case "yellow":
                    band1 = "4";
                    break;
                case "green":
                    band1 = "5";
                    break;
                case "blue":
                    band1 = "6";
                    break;
                case "violet":
                    band1 = "7";
                    break;
                case "grey":
                    band1 = "8";
                    break;
                case "white":
                    band1 = "9";
                    break;
                case "none":
                    band1 = "0";
                    missingValue = true;
                    break;
                default:
                    // code block
            }
            return band1;
        }

    //determine which value should be associated with the selection made on the second band/spinner
        private String doBand2() {
            switch(spinner2Selection) {
                case "black":
                case "gold":
                case "silver":
                    band2 = "0";
                    break;
                case "none":
                    band2 = "0";
                    missingValue = true;
                    break;
                case "brown":
                    band2 = "1";
                    break;
                case "red":
                    band2 = "2";
                    break;
                case "orange":
                    band2 = "3";
                    break;
                case "yellow":
                    band2 = "4";
                    break;
                case "green":
                    band2 = "5";
                    break;
                case "blue":
                    band2 = "6";
                    break;
                case "violet":
                    band2 = "7";
                    break;
                case "grey":
                    band2 = "8";
                    break;
                case "white":
                    band2 = "9";
                    break;
                default:
                    finish();
            }
            return band2;
        }

    //determine which value should be associated with the selection made on the third band/spinner
        private String doMultiplier() {
            switch(spinner3Selection) {
                case "black":
                    multiplier = "1";
                    break;
                case "brown":
                    multiplier = "10";
                    break;
                case "red":
                    multiplier = "100";
                    break;
                case "orange":
                    multiplier = "1000";
                    break;
                case "yellow":
                    multiplier = "10000";
                    break;
                case "green":
                    multiplier = "100000";
                    break;
                case "blue":
                    multiplier = "1000000";
                    break;
                case "violet":
                    multiplier = "10000000";
                    break;
                case "grey":
                    multiplier = "100000000";
                    break;
                case "white":
                    multiplier = "1000000000";
                    break;
                case "gold":
                    multiplier = "0.1";
                    break;
                case "silver":
                    multiplier = "0.01";
                    break;
                case "none":
                    missingValue = true;
                    multiplier = "0";
                    break;
                default:
                   finish();
            }
            return multiplier;
        }
    //determine which value should be associated with the selection made on the fourth band/spinner
        private String doTolerance() {
            switch(spinner4Selection) {
                case "black":
                case "white":
                case "yellow":
                case "orange":
                    tolerance = "";
                    break;
                case "brown":
                    tolerance = "1";
                    break;
                case "red":
                    tolerance = "2";
                    break;
                case "green":
                    tolerance = "0.5";
                    break;
                case "blue":
                    tolerance = "0.25";
                    break;
                case "violet":
                    tolerance = "0.1";
                    break;
                case "grey":
                    tolerance = "0.05";
                    break;
                case "gold":
                    tolerance = "5";
                    break;
                case "silver":
                    tolerance = "10";
                    break;
                case "none":
                    tolerance = "20";
                    break;
                default:
                    finish();
            }
            return tolerance;
        }

    //Validate that any selections that need to be made are made
    private void doMissing() {
        //if there is a missing value, reset the the result TextView to blank and throw a toast message to the user to notify them that they left a value blank
        if (missingValue == true) {
            FinalResult.setText("");
            LowerLimit.setText("");
            HigherLimit.setText("");
            Toast.makeText(this, "There wasn't enough selections made", Toast.LENGTH_SHORT).show();
        }
    }

    //reset the colours on the image and reset the results TextView
    public void doReset(View view) {
        FinalResult.setText("");
        LowerLimit.setText("");
        HigherLimit.setText("");
        colour1.setBackgroundResource(R.color.None);
        colour2.setBackgroundResource(R.color.None);
        colour3.setBackgroundResource(R.color.None);
        colour4.setBackgroundResource(R.color.None);
        spinner1.setSelection(0);
        spinner2.setSelection(0);
        spinner3.setSelection(0);
        spinner4.setSelection(0);
        setSpinnersToNothingSelected();
        missingValue = false;
        empty = "1 + 2 + 3";
    }

    private void setSpinnersToNothingSelected() {
        spinner1Selection = "none";
        spinner2Selection = "none";
        spinner3Selection = "none";
        spinner4Selection = "none";
    }
}