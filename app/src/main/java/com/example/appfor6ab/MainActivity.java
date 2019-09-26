package com.example.appfor6ab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button _btnSave;
    private TextView _questionStatement;
    private int _currectQuestion = 0;
    private ArrayList<Question> _questions =
            new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this._btnSave = findViewById(R.id.btnSave);

        this._btnSave.setText("Login");

//        this._btnSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this,
//                        "Button Clicked!",
//                        Toast.LENGTH_SHORT).show();
//            }
//        });

        this._questions.add(
          new Question("Class will end at 13:00", false)
        );
        this._questions.add(new Question(getString(R.string.Q1), true));
        this._questions.add(new Question("Paris is the capital of Germany", false));

        this._questionStatement = findViewById(R.id.textQuestion);
        this._questionStatement.setText(
                this._questions.get(0).getQuestionText()
        );
    }

    public void onButtonClick(View v) {
        Button b = (Button)v;
        Toast.makeText(MainActivity.this,
                b.getText().toString(),
                Toast.LENGTH_SHORT).show();
    }

    public void onTrueFalseClick(View v) {
        //Toast.makeText()
        boolean correct = this._questions.get(this._currectQuestion).getCorrectAnswer();
        boolean userChoice = Boolean.parseBoolean( ((Button)v).getText().toString());
        if(correct == userChoice)
            Log.i("Msg", "Answer is Correct");
        else
            Log.i("Msg", "incorrect");

//        Log.i("Msg", Boolean.toString(userChoice));
    }

    public void onNextClick(View v) {
        this._currectQuestion++;
        String q = this._questions.get(this._currectQuestion).getQuestionText();
        this._questionStatement.setText(q);
    }
}
