package com.example.geniusquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HistoryActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;

    private ImageButton mNextButton;
    private TextView mQuestionTextView;
    private ImageView mImageQuestion;
    private ImageButton mPreviousButton;

    private Question[] mQuestionBank = new Question[]{

            new Question(R.string.first_question,R.drawable.africa_map,false),
            new Question(R.string.second_question,R.drawable.eiffel,false),
            new Question(R.string.third_question,R.drawable.statue_of_liberty,true),
            new Question(R.string.fourth_question,R.drawable.car,true),
            new Question(R.string.fifth_question,R.drawable.clothes,false),
            new Question(R.string.sixth_question,R.drawable.euro,true),
            new Question(R.string.seventh_question,R.drawable.moscow,true),
            new Question(R.string.eight_question,R.drawable.canada,false),
            new Question(R.string.nineth_question,R.drawable.scroll,false),
            new Question(R.string.tenth_question,R.drawable.chile,true),

    };

    private int mCurrentIndex = 0;

    private int score = 0;

    private int questions = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        mQuestionTextView = findViewById(R.id.question);
        mImageQuestion = findViewById(R.id.imageQuestion);

        mTrueButton = findViewById(R.id.true_button);
        mFalseButton = findViewById(R.id.false_button);

        mNextButton = findViewById(R.id.next_button);
        mPreviousButton = findViewById(R.id.back_button);





        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                System.out.println(mCurrentIndex);
                updateQuestion();

            }
        });


        mPreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mCurrentIndex == 0){

                    mCurrentIndex = mQuestionBank.length - 1 % mQuestionBank.length;
                    updateQuestion();
                    System.out.println(mQuestionBank.length - 1);

                } else{

                    mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.length;
                    System.out.println(mCurrentIndex);
                    updateQuestion();

                }

            }
        });


        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkAnswer(true);

                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                System.out.println(mCurrentIndex);

                if (questions == 10){

                    Intent intent = new Intent(getApplicationContext(),ScoreActivity.class);
                    intent.putExtra("Score",score);
                    startActivity(intent);
                    finish();
                } else {

                    updateQuestion();

                }

            }
        });


        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkAnswer(false);

                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                System.out.println(mCurrentIndex);

                if (questions == 10){

                    Intent intent = new Intent(getApplicationContext(),ScoreActivity.class);
                    intent.putExtra("Score",score);
                    startActivity(intent);
                    finish();
                } else {

                    updateQuestion();

                }



            }
        });


        updateQuestion();


    }

    private void updateQuestion(){

        int question = mQuestionBank[mCurrentIndex].getmTextResId();
        int image = mQuestionBank[mCurrentIndex].getmImgResId();
        mQuestionTextView.setText(question);
        mImageQuestion.setImageResource(image);
    }

    private void checkAnswer(boolean userPressedTrue) {

        boolean answerIsTrue = mQuestionBank[mCurrentIndex].ismAnswer();
        boolean answerIsSelected = mQuestionBank[mCurrentIndex].isSelected();
        int messageResId;





        if (!answerIsSelected) {

            mQuestionBank[mCurrentIndex].setSelected(true);
            questions += 1;
            System.out.println("score: " + score);
            System.out.println("Question: " + questions);
            System.out.println(mQuestionBank[mCurrentIndex].isSelected());

            if (userPressedTrue == answerIsTrue) {

                messageResId = R.string.correct_toast;
                score += 1;

            } else {

                messageResId = R.string.incorrect_toast;

            }

            Toast.makeText(getApplicationContext(), messageResId, Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(getApplicationContext(), "Esta pregunta ya ha sido respondida", Toast.LENGTH_SHORT).show();

        }

    }


}
