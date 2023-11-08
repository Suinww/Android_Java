package com.example.rnw_sd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileInputStream;

public class MainActivity extends AppCompatActivity {
    Button mkdir, rmdir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mkdir = (Button) findViewById(R.id.mkdir);
        rmdir = (Button) findViewById(R.id.rmdir);

        ActivityCompat.requestPermissions(this, new String[]
                {Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);
        // 권한 요청

        String strSDpath = Environment.getExternalStorageDirectory().getAbsolutePath();
        final File myDir = new File(strSDpath + "/mydir");

        mkdir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDir.mkdir();
            }
        });
        rmdir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDir.delete();
            }
        });
    }
}