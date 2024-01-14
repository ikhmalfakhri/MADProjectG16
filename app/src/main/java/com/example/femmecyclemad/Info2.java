package com.example.femmecyclemad;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Info2 extends AppCompatActivity {

    TextView textView, textView2;
    NumberPicker numberPicker;

    private Button button1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info2);

        button1  = (Button) findViewById(R.id.buttonMenu3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }


        });

        numberPicker = findViewById(R.id.numberpicker1);
        textView = findViewById(R.id.titlePhase);
        textView2 = findViewById(R.id.textFood);



        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(28);

        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                if (newVal > 0 && newVal <6){
                    textView.setText(String.format(": Menstrual Phase"));
                    textView2.setText(String.format("Iron-rich Foods:\n" +
                            "\n" +
                            "Lean meats (chicken, turkey)\n" +
                            "Fish (especially salmon and tuna)\n" +
                            "Lentils and beans\n" +
                            "Leafy green vegetables (spinach, kale)\n\n" +
                            "Hydration:\n" +
                            "\n" +
                            "Drink plenty of water to stay hydrated, which can help alleviate bloating."));
                } else if(newVal > 5 && newVal <11){
                    textView.setText(String.format(": Follicular Phase"));
                    textView2.setText(String.format("Whole Grains:\n" +
                            "\n" +
                            "Brown rice\n" +
                            "Quinoa\n" +
                            "Oats\n\n" +
                            "Fruits and Vegetables:\n" +
                            "\n" +
                            "Berries\n" +
                            "Broccoli\n" +
                            "Citrus fruits\n" +
                            "Carrots\n\n"));
                } else if(newVal > 10 && newVal <19){
                    textView.setText(String.format(": Ovulation Phase"));
                    textView2.setText(String.format("Omega-3 Fatty Acids:\n" +
                            "\n" +
                            "Fatty fish (salmon, mackerel)\n" +
                            "Chia seeds\n" +
                            "Flaxseeds\n" +
                            "Walnuts\n\n" +
                            "Colorful Vegetables:\n" +
                            "\n" +
                            "Bell peppers\n" +
                            "Tomatoes\n" +
                            "Dark leafy greens"));}
                else {
                    textView.setText(String.format(": Luteal Phase"));
                    textView2.setText(String.format("Complex Carbohydrates:\n" +
                            "\n" +
                            "Whole grain bread\n" +
                            "Sweet potatoes\n" +
                            "Legumes\n\n" +
                            "Magnesium-rich Foods:\n" +
                            "\n" +
                            "Bananas\n" +
                            "Avocados\n" +
                            "Almonds\n\n" +
                            "Calcium Sources:\n" +
                            "\n" +
                            "Dairy or fortified plant-based milk\n"));
                }
            }

        });
    }


}