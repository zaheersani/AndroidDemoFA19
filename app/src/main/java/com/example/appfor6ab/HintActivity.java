package com.example.appfor6ab;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;

import android.os.Bundle;
import android.widget.TextView;

public class HintActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);
    }

    public void onClickRevealHint(View v) {
        Intent intentReceived = getIntent();
        String hintText = intentReceived.getStringExtra("hint");
        TextView textHintText = findViewById(R.id.textHintText);
        textHintText.setText(hintText);
    }
}
