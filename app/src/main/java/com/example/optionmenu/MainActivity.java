package com.example.optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout baseLayout;
    Button btn1;
    float rotation = 0;
    float scale = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("배경색 바꾸기");
        baseLayout = (ConstraintLayout) findViewById(R.id.baseLayout);
        btn1 = (Button) findViewById(R.id.btn1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //메뉴만드는거
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menuxml, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //메뉴 선택하는거
        switch (item.getItemId()) {
            case R.id.itemRed:
                baseLayout.setBackgroundColor(Color.RED);
                return true;

            case R.id.itemGreen:
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;

            case R.id.itemBlue:
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;

            case R.id.itemRotate:
                rotation = rotation + 45;
                btn1.setRotation(rotation);
                return true;

            case R.id.itemRotate2:
                rotation = rotation - 45;
                btn1.setRotation(rotation);
                return true;

            case R.id.itemSize:
                if (scale <= 3.5) {
                    scale = scale + 0.5f;
                    btn1.setScaleX(scale);
                    btn1.setScaleY(scale);
                    Log.d("scale+", String.valueOf(scale));
                    return true;
                } else {
                    Toast.makeText(this, "더이상 확대할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    return true;
                }

            case R.id.itemSize2:
                if (scale >= 1) {
                    scale = scale - 0.5f;
                    btn1.setScaleX(scale);
                    btn1.setScaleY(scale);
                    Log.d("scale-", String.valueOf(scale));
                    return true;
                } else {
                    Toast.makeText(this, "더이상 축소할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    return true;
                }

        }
        return super.onOptionsItemSelected(item);
    }
}