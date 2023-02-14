package com.example.shared_prefrences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int count = 0;
    EditText inputName = findViewById(R.id.input_name);
    TextView countView = findViewById(R.id.count);
    SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settings=getSharedPreferences("PREFS_NAME",MODE_PRIVATE);



    }

    public void saveToFile(View view) {
        String name;
        SharedPreferences.Editor editor=settings.edit();
        editor.putInt("count", count);
        name = inputName.getText().toString();
        editor.putString("name", name);
        editor.commit();
    }

    public void progCount(View view) {
        count++;
        countView.setText("" + count);
    }
}