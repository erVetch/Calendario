package com.example.calendariodazero;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_TEXT = "com.example.calendariodazero.EXTRA_TEXT";
    public static String date;
    private Button button;
    CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = (CalendarView) findViewById(R.id.calendarView);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
             date = (month + 1) + "/" + dayOfMonth + "/" + year;
            }
        });
    }
    public void openActivity2() {
        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra(EXTRA_TEXT, date);
        startActivity(intent);
    }
}
