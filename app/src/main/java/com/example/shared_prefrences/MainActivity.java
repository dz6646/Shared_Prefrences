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

    /**
     * Function that saves the count and name in a shared preference file
     *
     * <p>Used in the exit button
     *
     * @author Dan Zhuravlov
     * @param view the screen
     */
    public void saveToFile(View view) {
        SharedPreferences.Editor editor=settings.edit();
        editor.putInt("count", count);
        name = inputName.getText().toString();
        editor.putString("name", name);
        editor.commit();
        finish();
    }

    /**
     * Function that progresses the count every click
     *
     * <p>Used in the count button
     *
     * @author Dan Zhuravlov
     * @param view the screen
     */
    public void progCount(View view) {
        count++;
        countView.setText("" + count);
    }

    /**
     * Function that resets the button and name
     *
     * <p>Used in the reset button
     *
     * @author Dan Zhuravlov
     * @param view the screen
     */
    public void resetCount(View view) {
        count = 0;
        name = "";
        inputName.setText("");
        countView.setText("0");
    }

    /**
     * Function that loads the shared pref file into the program
     *
     * <p>Used in the creating of the program
     *
     * @author Dan Zhuravlov
     */
    public void readShared()
    {
        count = settings.getInt("count", 0);
        name = settings.getString("name", "");
        countView.setText("" + count);
        inputName.setText(name);
    }
}