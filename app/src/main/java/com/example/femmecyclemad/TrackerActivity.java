package com.example.femmecyclemad;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TrackerActivity extends AppCompatActivity {

    private SimpleDateFormat dtf = new SimpleDateFormat("dd MM yyyy");
    private DatePickerDialog datePickerDialog;
    private Button dateButton;
    TextView textView;

    Button submitBtn ,buttont;

    NumberPicker numberPicker1, numberPicker2;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);

        numberPicker1 = findViewById(R.id.numberpickerCD);
        numberPicker2 = findViewById(R.id.numberpickerPD);

        numberPicker1.setMinValue(21);
        numberPicker1.setMaxValue(35);

        numberPicker2.setMinValue(1);
        numberPicker2.setMaxValue(10);

        dateButton = findViewById(R.id.buttonSubmit);
        dateButton.setText("ENTER DATE");
        initDatePicker();

        buttont = (Button) findViewById(R.id.buttonBackt);
        buttont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });


        /*numberPicker1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                initDatePicker(numberPicker2.getValue(),numberPicker1.getValue());
                dateButton = findViewById(R.id.buttonSubmit);
                dateButton.setText(getTodaysDate());
                numberPicker2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                    @Override
                    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                        initDatePicker(numberPicker2.getValue(),numberPicker1.getValue());
                        dateButton = findViewById(R.id.buttonSubmit);
                        dateButton.setText(getTodaysDate());

                    }
                });
            }
        });*/


    }

    private String getTodaysDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day,month,year);

    }

    private String makeDateString(int day, int month, int year){
        if(month<10){
            return day+" 0"+month+" "+year;
        } else {
            return day+" "+month+" "+year;
        }
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = makeDateString(dayOfMonth, month, year);
                dateButton.setText(date);
                Calendar cal1 = Calendar.getInstance();
                try {
                    cal1.setTime(dtf.parse(date));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }



                submitBtn = findViewById(R.id.trackerSubmit);
                submitBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        numberPicker1 = findViewById(R.id.numberpickerCD);
                        int cd = numberPicker1.getValue();

                        numberPicker2 = findViewById(R.id.numberpickerPD);
                        int pd = numberPicker2.getValue();

                        cal1.add(Calendar.DAY_OF_MONTH, pd-1);
                        String dateEndP = dtf.format(cal1.getTime());

                        cal1.add(Calendar.DAY_OF_MONTH, 6);
                        String dateFPs = dtf.format(cal1.getTime());
                        cal1.add(Calendar.DAY_OF_MONTH, 4);
                        String dateFPe = dtf.format(cal1.getTime());

                        cal1.add(Calendar.DAY_OF_MONTH, (cd-(pd+6+4-1)));
                        String dateNPs = dtf.format(cal1.getTime());
                        cal1.add(Calendar.DAY_OF_MONTH, pd-1);
                        String dateNPe = dtf.format(cal1.getTime());

                        textView = findViewById(R.id.textTracker);
                        textView.setText("Your Period Started: \n"+date+" - "+dateEndP+
                                "\n\nYour Fertile Period: \n"+dateFPs+" - "+dateFPe+
                                "\n\nYour Next Period: \n"+dateNPs+" - "+dateNPe);

                        try {
                            cal1.setTime(dtf.parse(date));
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                    }

                });


            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
    }
    public void openDatePicker(View view) {
        datePickerDialog.show();
    }
}
