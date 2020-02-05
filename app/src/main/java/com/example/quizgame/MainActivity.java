package com.example.quizgame;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    Button subject1;
    Button subject2;
    Button subject3;
    Button subject4;

    FloatingActionButton settings;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        subject1 = (Button) findViewById(R.id.subject1);
        subject2 = (Button) findViewById(R.id.subject2);
        subject3 = (Button) findViewById(R.id.subject3);
        subject4 = (Button) findViewById(R.id.subject4);

        final int percentage_set = getIntent().getIntExtra("PERCENTAGE", 60);
        final int num_questions_set = getIntent().getIntExtra("NUM_QUESTIONS", 10);



        subject1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), QuestionPage.class);
                intent.putExtra("CATEGORY", 1);
                intent.putExtra("PERCENTAGE", percentage_set);
                intent.putExtra("NUM_QUESTIONS", num_questions_set);
                startActivity(intent);
            }
        });

        subject2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), QuestionPage.class);
                intent.putExtra("CATEGORY", 2);
                intent.putExtra("PERCENTAGE", percentage_set);
                intent.putExtra("NUM_QUESTIONS", num_questions_set);
                startActivity(intent);
            }
        });

        subject3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), QuestionPage.class);
                intent.putExtra("CATEGORY", 3);
                intent.putExtra("PERCENTAGE", percentage_set);
                intent.putExtra("NUM_QUESTIONS", num_questions_set);
                startActivity(intent);
            }
        });

        subject4.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), QuestionPage.class);
                intent.putExtra("CATEGORY", 4);
                intent.putExtra("PERCENTAGE", percentage_set);
                intent.putExtra("NUM_QUESTIONS", num_questions_set);
                startActivity(intent);
            }
        });

        // this is to get to the settings page

        settings = (FloatingActionButton) findViewById(R.id.setting_btn2);
        settings.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SettingsPage.class));

            }
        });
    }

}




