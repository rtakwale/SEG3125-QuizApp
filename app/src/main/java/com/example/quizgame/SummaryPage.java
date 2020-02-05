package com.example.quizgame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SummaryPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        TextView resultView = (TextView)findViewById(R.id.resultView);
        TextView percentageView = (TextView)findViewById(R.id.percentageView);
        TextView messageView = (TextView)findViewById(R.id.messageView);

        double score = getIntent().getIntExtra("RIGHT_ANSWER_COUNT", 0);
        double total = getIntent().getIntExtra("NUM_OF_QUESTIONS", 0);
        int goal_percentage = getIntent().getIntExtra("PERCENTAGE", 60);


        resultView.setText("Final score: " + score + "/" + total);
        double percentage = ((score/total)*100);

        percentageView.setText(percentage + "%");

        if (percentage > goal_percentage){
            messageView.setText("You passed the quiz!");
        }else{
            messageView.setText("You failed the quiz!");
        }
    }

    public void returnMain(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("NUM_QUESTIONS", getIntent().getIntExtra("NUM_OF_QUESTIONS", 0));
        startActivity(intent);
    }
}




