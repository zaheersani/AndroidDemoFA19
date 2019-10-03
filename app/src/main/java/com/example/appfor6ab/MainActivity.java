package com.example.appfor6ab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    
    private TextView _questionStatement;
    private int _currentQuestion = 0;
    private ArrayList<Question> _questions =
            new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("Msg", "I am creating!");

        if(savedInstanceState != null) {
            this._currentQuestion = savedInstanceState.getInt("index", 0);
        }

        this._questions.add(
          new Question("Oslo is the capital of Denmark", false, "Telenor came from?")
        );
        this._questions.add(new Question(getString(R.string.Q1), true, "Where is Faisal Mosque?"));
        this._questions.add(new Question("Paris is the capital of Germany", false, "Where is Eiffel Tower?"));

        this._questionStatement = findViewById(R.id.textQuestion);
        this._questionStatement.setText(
                this._questions.get(this._currentQuestion).getQuestionText()
        );
    }

    public void onTrueFalseClick(View v) {
        boolean correct = this._questions.get(this._currentQuestion).getCorrectAnswer();
        boolean userChoice = Boolean.parseBoolean( ((Button)v).getText().toString());
        if(correct == userChoice)
            Log.i("Msg", "Answer is Correct");
        else
            Log.i("Msg", "incorrect");
    }

    public void onNextClick(View v) {
        this._currentQuestion++;
        String q = this._questions.get(this._currentQuestion).getQuestionText();
        this._questionStatement.setText(q);
    }

    public void onHintClick(View v) {
        // Create Intent
        Intent intent = new Intent(this, HintActivity.class);
        // Get Hint Text of Current Question from Questions Collection
        String hintOfCurrentQuestion = this._questions.get(this._currentQuestion).getHint();
        // Add Hint text information with intent
        intent.putExtra("hint", hintOfCurrentQuestion);
        // Start a new activity with created Intent
        startActivity(intent);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("Msg", "I am pausing!");
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.i("Msg", "I am Resuming!");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("Msg", "I am Stopping!");
    }

    @Override
    public void onSaveInstanceState(Bundle onSaveState) {
        super.onSaveInstanceState(onSaveState);
        Log.i("Msg", "Saving State!");
        onSaveState.putInt("index", this._currentQuestion);
    }

}
