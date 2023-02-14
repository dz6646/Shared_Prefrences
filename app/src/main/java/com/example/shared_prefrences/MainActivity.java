package com.example.shared_prefrences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int count = 0;
    String name;
    EditText inputName;
    TextView countView;
    SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settings=getSharedPreferences("PREFS_NAME",MODE_PRIVATE);
        inputName = findViewById(R.id.input_name);
        countView = findViewById(R.id.count);
        readShared();
    }

    public void saveToFile(View view) {
        SharedPreferences.Editor editor=settings.edit();
        editor.putInt("count", count);
        name = inputName.getText().toString();
        editor.putString("name", name);
        editor.commit();
        finish();
    }

    public void progCount(View view) {
        count++;
        countView.setText("" + count);
    }

    public void resetCount(View view) {
        count = 0;
        countView.setText("0");
    }

    public void readShared()
    {
        count = settings.getInt("count", 0);
        name = settings.getString("name", "");
        countView.setText("" + count);
        inputName.setText(name);
    }
}