package com.example.booking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    Chronometer chronometer;
    Button btnStart, btnEnd;
    RadioButton rdoCal, rdoTime;
    CalendarView calView;
    TimePicker timePick;
    TextView yyyy, mm, dd, hh, nn;
    int selectYear, selectMonth, selectDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약 앱");

        chronometer = (Chronometer) findViewById(R.id.chronometer);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnEnd = (Button) findViewById(R.id.btnEnd);
        rdoCal = (RadioButton) findViewById(R.id.rdoCal);
        rdoTime = (RadioButton) findViewById(R.id.rdoTime);
        calView = (CalendarView) findViewById(R.id.calView);
        timePick = (TimePicker) findViewById(R.id.timePick);
        yyyy = (TextView) findViewById(R.id.yyyy);
        mm = (TextView) findViewById(R.id.mm);
        dd = (TextView) findViewById(R.id.dd);
        hh = (TextView) findViewById(R.id.hh);
        nn = (TextView) findViewById(R.id.nn);

        calView.setVisibility(View.INVISIBLE);
        timePick.setVisibility(View.INVISIBLE);

        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePick.setVisibility(View.INVISIBLE);
                calView.setVisibility(View.VISIBLE);
            }
        });
        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calView.setVisibility(View.INVISIBLE);
                timePick.setVisibility(View.VISIBLE);
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                chronometer.setTextColor(Color.RED);
                yyyy.setText(Integer.toString(selectYear));
                mm.setText(Integer.toString(selectMonth));
                dd.setText(Integer.toString(selectDay));
                hh.setText(Integer.toString(timePick.getCurrentHour()));
                nn.setText(Integer.toString(timePick.getCurrentMinute()));
            }
        });
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.stop();
                chronometer.setTextColor(Color.BLUE);
            }
        });

        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                selectYear = i;
                selectMonth = i1+1;
                selectDay = i2;
            }
        });
    }
}