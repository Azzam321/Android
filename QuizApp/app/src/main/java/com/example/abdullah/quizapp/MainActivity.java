package com.example.abdullah.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int totalCorrect = 0;
    Button submit;
    EditText que3, que5;
    CheckBox choice1, choice2, choice3;
    RadioGroup Ques1, Ques2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Ques1 = (RadioGroup) findViewById(R.id.q1);
        choice1 = (CheckBox) findViewById(R.id.checkBox1);
        choice2 = (CheckBox) findViewById(R.id.checkBox2);
        choice3 = (CheckBox) findViewById(R.id.checkBox3);
        que3 = (EditText) findViewById(R.id.q3);
        que5 = (EditText) findViewById(R.id.q5);
        Ques2 = (RadioGroup) findViewById(R.id.q2);
        submit = (Button) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkSubmittion();
                Toast.makeText(MainActivity.this, "Total correct answer " + totalCorrect + " out of 5", Toast.LENGTH_LONG).show();
                totalCorrect = 0;
            }

        });
    }

    private void checkSubmittion() {

        if (R.id.radio13 == Ques1.getCheckedRadioButtonId()) {
            totalCorrect++;
        }
        if (R.id.radio23 == Ques2.getCheckedRadioButtonId()) {
            totalCorrect++;
        }

        if (que3.getText().toString().equalsIgnoreCase("even"))
            totalCorrect++;

        if (choice1.isChecked() && choice2.isChecked() && !choice3.isChecked())
            totalCorrect++;
        try {
            if (Integer.parseInt(que5.getText().toString()) == 136)
                totalCorrect++;
        } catch (NumberFormatException nfe) {
            nfe.getStackTrace();
            que5.setError("The answer should be numeric");
        }
    }
}









