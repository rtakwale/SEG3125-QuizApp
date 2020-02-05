package com.example.quizgame;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.security.auth.Subject;

public class QuestionPage<subject> extends AppCompatActivity{

    private TextView questionView;
    private TextView indexView;
    private Button answer1_btn;
    private Button answer2_btn;
    private Button answer3_btn;
    private Button answer4_btn;

    private String rightAnswer;
    private int questionCount = 1;
    private int rightAnswerCount = 0;

    // by default, there are 10 questions in a quiz
    private int QUESTION_COUNT = 10;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

 //   int subject_category = getIntent().getIntExtra("CATEGORY", 0);


    String quizMathData[][] = {
            // {"Math Equation", "Right Answer", "Choice1", "Choice2", "Choice3"}
            {"5 + 5", "10", "11", "8", "9"},
            {"5/2", "2.5", "3", "2", "2.25"},
            {"2 * 3", "6", "0", "12", "5"},
            {"1023 * 0", "0", "1023", "1", "-1023"},
            {"5 + 5", "10", "11", "8", "9"},
            {"5/2", "2.5", "3", "2", "2.25"},
            {"2 * 3", "6", "0", "12", "5"},
            {"1023 * 0", "0", "1023", "1", "-1023"},
            {"5 + 6", "11", "10", "8", "9"},
            {"6/2", "3", "3.3", "2", "2.25"},
            {"3 * 3", "9", "0", "12", "5"},
            {"9999 * 0", "0", "9999", "1", "-9999"},
            {"4 + 4", "8", "11", "44", "9"},
            {"10/2", "25", "3", "2", "2.25"},
            {"5 * 5", "25", "0", "10", "5"},
            {"1023 * 0", "0", "1023", "1", "-1023"},
            {"5 + 5", "10", "11", "8", "9"},
            {"5/2", "2.5", "3", "2", "2.25"},
            {"2 * 3", "6", "0", "12", "5"},
            {"1023 * 0", "0", "1023", "1", "-1023"},
            {"5 + 5", "10", "11", "8", "9"},
            {"5/2", "2.5", "3", "2", "2.25"},
            {"2 * 3", "6", "0", "12", "5"},
            {"1023 * 0", "0", "1023", "1", "-1023"}
    };


    String quizCityData[][] = {
            // {"Country", "Right Answer", "Choice1", "Choice2", "Choice3"}
            {"China", "Beijing", "Jakarta", "Manila", "Stockholm"},
            {"India", "New Delhi", "Beijing", "Bangkok", "Seoul"},
            {"Indonesia", "Jakarta", "Manila", "New Delhi", "Kuala Lumpur"},
            {"Japan", "Tokyo", "Bangkok", "Taipei", "Jakarta"},
            {"Thailand", "Bangkok", "Berlin", "Havana", "Kingston"},
            {"Brazil", "Brasilia", "Havana", "Bangkok", "Copenhagen"},
            {"Canada", "Ottawa", "Bern", "Copenhagen", "Jakarta"},
            {"Cuba", "Havana", "Bern", "London", "Mexico City"},
            {"Mexico", "Mexico City", "Ottawa", "Berlin", "Santiago"},
            {"United States", "Washington D.C.", "San Jose", "Buenos Aires", "Kuala Lumpur"},
            {"France", "Paris", "Ottawa", "Copenhagen", "Tokyo"},
            {"Germany", "Berlin", "Copenhagen", "Bangkok", "Santiago"},
            {"Italy", "Rome", "London", "Paris", "Athens"},
            {"Spain", "Madrid", "Mexico City", "Jakarta", "Havana"},
            {"United Kingdom", "London", "Rome", "Paris", "Singapore"},
            {"Canada", "Ottawa", "Bern", "Copenhagen", "Jakarta"},
            {"Cuba", "Havana", "Bern", "London", "Mexico City"},
            {"Mexico", "Mexico City", "Ottawa", "Berlin", "Santiago"},
            {"United States", "Washington D.C.", "San Jose", "Buenos Aires", "Kuala Lumpur"},
            {"France", "Paris", "Ottawa", "Copenhagen", "Tokyo"},
            {"Germany", "Berlin", "Copenhagen", "Bangkok", "Santiago"},
            {"Italy", "Rome", "London", "Paris", "Athens"},
            {"Spain", "Madrid", "Mexico City", "Jakarta", "Havana"},
            {"United Kingdom", "London", "Rome", "Paris", "Singapore"}
    };

    String quizDataStructuresData[][] = {
            // {"Country", "Right Answer", "Choice1", "Choice2", "Choice3"}
            {"Heaps: insert E()", "O(log n)", "O(n)", "O(n2)", "O(1)"},
            {"Heaps: remove E()", "O(log n)", "O(n)", "O(n2)", "O(1)"},
            {"Heaps: minKey", "O(1)", "O(log n)", "O(n)", "O(n2)"},
            {"Binary Search Tree: worst case", "O(n)", "O(1)", "O(log n)", "O(n2)"},
            {"Binary Search Tree: best case", "O(log n)", "O(1)", "O(n)", "O(n2)"},
            {"Heaps: insert E()", "O(log n)", "O(n)", "O(n2)", "O(1)"},
            {"Heaps: remove E()", "O(log n)", "O(n)", "O(n2)", "O(1)"},
            {"Heaps: minKey", "O(1)", "O(log n)", "O(n)", "O(n2)"},
            {"Binary Search Tree: worst case", "O(n)", "O(1)", "O(log n)", "O(n2)"},
            {"Binary Search Tree: best case", "O(log n)", "O(1)", "O(n)", "O(n2)"},
            {"Heaps: insert E()", "O(log n)", "O(n)", "O(n2)", "O(1)"},
            {"Heaps: remove E()", "O(log n)", "O(n)", "O(n2)", "O(1)"},
            {"Heaps: minKey", "O(1)", "O(log n)", "O(n)", "O(n2)"},
            {"Binary Search Tree: worst case", "O(n)", "O(1)", "O(log n)", "O(n2)"},
            {"Binary Search Tree: best case", "O(log n)", "O(1)", "O(n)", "O(n2)"},
            {"Heaps: insert E()", "O(log n)", "O(n)", "O(n2)", "O(1)"},
            {"Heaps: remove E()", "O(log n)", "O(n)", "O(n2)", "O(1)"},
            {"Heaps: minKey", "O(1)", "O(log n)", "O(n)", "O(n2)"},
            {"Binary Search Tree: worst case", "O(n)", "O(1)", "O(log n)", "O(n2)"},
            {"Binary Search Tree: best case", "O(log n)", "O(1)", "O(n)", "O(n2)"},
            {"Heaps: insert E()", "O(log n)", "O(n)", "O(n2)", "O(1)"},
            {"Heaps: remove E()", "O(log n)", "O(n)", "O(n2)", "O(1)"},
            {"Heaps: minKey", "O(1)", "O(log n)", "O(n)", "O(n2)"},
            {"Binary Search Tree: worst case", "O(n)", "O(1)", "O(log n)", "O(n2)"},
            {"Binary Search Tree: best case", "O(log n)", "O(1)", "O(n)", "O(n2)"}
    };


    FloatingActionButton settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        indexView = (TextView) findViewById(R.id.indexView);
        questionView = (TextView) findViewById(R.id.questionView);
        answer1_btn = (Button) findViewById(R.id.answer1_btn);
        answer2_btn = (Button) findViewById(R.id.answer2_btn);
        answer3_btn = (Button) findViewById(R.id.answer3_btn);
        answer4_btn = (Button) findViewById(R.id.answer4_btn);

        int subject_category = getIntent().getIntExtra("CATEGORY", 0);
        QUESTION_COUNT = getIntent().getIntExtra("NUM_QUESTIONS", 10);

        String quizData[][];

        if (subject_category == 1){
            quizData = quizMathData;
        }
        else if (subject_category == 2){
            quizData = quizCityData;
        }
        else if (subject_category == 3) {
            quizData = quizDataStructuresData;
        }
        else{
            quizData = quizDataStructuresData;
        }


        // here we create quizMathArray from quizMathData

        for (int i = 0; i < quizData.length; i++) {

            // prepare array
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]); //question
            tmpArray.add(quizData[i][1]); // right answer
            tmpArray.add(quizData[i][2]); // 1st choice
            tmpArray.add(quizData[i][3]); // 2nd choice
            tmpArray.add(quizData[i][4]); // 3rd choice

            // add tmpArray to quizMathArray
            quizArray.add(tmpArray);
        }

        showNextQuestion();
    }

    public void showNextQuestion() {
        indexView.setText("Question " + questionCount);

        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());

        ArrayList<String> quiz = quizArray.get(randomNum);

        questionView.setText(quiz.get(0));
        rightAnswer = quiz.get(1);

        // now we shuffle the possible answers
        quiz.remove(0);
        Collections.shuffle(quiz);

        // set choices
        answer1_btn.setText(quiz.get(0));
        answer2_btn.setText(quiz.get(1));
        answer3_btn.setText(quiz.get(2));
        answer4_btn.setText(quiz.get(3));

        //remove the question from the list
        quizArray.remove(randomNum);
    }

    public void checkAnswer(View view){
        Button answer_btn = (Button)findViewById(view.getId());
        String btn_text = answer_btn.getText().toString();

        String alertTitle;

        if(btn_text.equals(rightAnswer)){
            alertTitle = "Correct!";
            rightAnswerCount++;

        }else{
            alertTitle = "Incorrect!";
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("Answer : " + rightAnswer);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialogInterface, int i){
            // i think i should change QUESTION_COUNT to be the number of questions that user chose
            if (questionCount == QUESTION_COUNT){
                Intent intent = new Intent(getApplicationContext(), SummaryPage.class);
                intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount);
                intent.putExtra("NUM_OF_QUESTIONS", QUESTION_COUNT);
                intent.putExtra("PERCENTAGE", getIntent().getIntExtra("PERCENTAGE", 60));

                startActivity(intent);


                    }else{
                        questionCount++;
                        showNextQuestion();
            }

                    }
                });
        builder.setCancelable(false);
        builder.show();



    // this is to get to the settings page

        settings = (FloatingActionButton) findViewById(R.id.setting_btn);
        settings.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuestionPage.this, SettingsPage.class));

            }
        });

    }
}
