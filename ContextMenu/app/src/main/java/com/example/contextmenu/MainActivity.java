package com.example.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2;
    ConstraintLayout baseLayout;
    float rotation = 0;
    float scale = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        registerForContextMenu(btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        registerForContextMenu(btn2);
        baseLayout = (ConstraintLayout) findViewById(R.id.baseLayout);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        if (v == btn1) {
            menu.setHeaderTitle("배경색 변경");
            menuInflater.inflate(R.menu.menu1xml, menu);
        }
        if (v == btn2) {
            menuInflater.inflate(R.menu.menu2xml, menu);
        }

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
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
                btn2.setRotation(rotation);
                return true;

            case R.id.itemRotate2:
                rotation = rotation - 45;
                btn2.setRotation(rotation);
                return true;

            case R.id.itemSize:
                if (scale <= 3.5) {
                    scale = scale + 0.5f;
                    btn2.setScaleX(scale);
                    btn2.setScaleY(scale);
                    Log.d("scale+", String.valueOf(scale));
                    return true;
                } else {
                    Toast.makeText(this, "더이상 확대할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    return true;
                }

            case R.id.itemSize2:
                if (scale >= 1) {
                    scale = scale - 0.5f;
                    btn2.setScaleX(scale);
                    btn2.setScaleY(scale);
                    Log.d("scale-", String.valueOf(scale));
                    return true;
                } else {
                    Toast.makeText(this, "더이상 축소할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    return true;
                }
        }
        return super.onContextItemSelected(item);
    }
}
