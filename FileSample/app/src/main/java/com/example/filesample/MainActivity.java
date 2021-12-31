package com.example.filesample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class MainActivity extends AppCompatActivity {
EditText edtcontent
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_permission);
edtcontent = findViewById(R.id.edtcontent);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.Btnread:

                try {
                    String path = Environment.getExternalStorageDirectory().getAbsolutePath();
                    Log.i("file",path);
                    FileInputStream inputStream = new FileInputStream(path + "test.text");
                    try {
                        byte data[]=new byte[inputStream.available()];
                        inputStream.read(data);
                        String str= new String(data);
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                break;
            case R.id.Btnwrite:
                String path = Environment.getExternalStorageDirectory().getAbsolutePath();
                FileOutputStream outputStream = null;
                try {
                    outputStream = new FileOutputStream(path + "test.text");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    outputStream.write(edtcontent.getText().toString().getBytes());

                    outputStream.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}