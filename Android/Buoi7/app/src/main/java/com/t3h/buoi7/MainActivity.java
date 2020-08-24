package com.t3h.buoi7;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.t3h.buoi7.models.Question;
import com.t3h.buoi7.models.QuestionsCollection;
import com.t3h.buoi7.views.GameButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imQuestion;
    private TextView tvScore;
    private TextView tvHeart;
    private GameButton[] btnQuestions = new GameButton[16];
    private GameButton[] btnAnswers = new GameButton[16];
    private Button btnNext;
    private int index = -1;
    int score = 0;
    int heart = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        loadQuestion();
    }

    private void initViews() {
        imQuestion = findViewById(R.id.im_question);
        tvHeart = findViewById(R.id.tv_heart);
        tvScore = findViewById(R.id.tv_score);
        btnNext = findViewById(R.id.btn_next);
        btnNext.setOnClickListener(this);
        btnQuestions[0] = findViewById(R.id.btn_question_1);
        btnQuestions[1] = findViewById(R.id.btn_question_2);
        btnQuestions[2] = findViewById(R.id.btn_question_3);
        btnQuestions[3] = findViewById(R.id.btn_question_4);
        btnQuestions[4] = findViewById(R.id.btn_question_5);
        btnQuestions[5] = findViewById(R.id.btn_question_6);
        btnQuestions[6] = findViewById(R.id.btn_question_7);
        btnQuestions[7] = findViewById(R.id.btn_question_8);
        btnQuestions[8] = findViewById(R.id.btn_question_9);
        btnQuestions[9] = findViewById(R.id.btn_question_10);
        btnQuestions[10] = findViewById(R.id.btn_question_11);
        btnQuestions[11] = findViewById(R.id.btn_question_12);
        btnQuestions[12] = findViewById(R.id.btn_question_13);
        btnQuestions[13] = findViewById(R.id.btn_question_14);
        btnQuestions[14] = findViewById(R.id.btn_question_15);
        btnQuestions[15] = findViewById(R.id.btn_question_16);

        btnAnswers[0] = findViewById(R.id.btn_answer_1);
        btnAnswers[1] = findViewById(R.id.btn_answer_2);
        btnAnswers[2] = findViewById(R.id.btn_answer_3);
        btnAnswers[3] = findViewById(R.id.btn_answer_4);
        btnAnswers[4] = findViewById(R.id.btn_answer_5);
        btnAnswers[5] = findViewById(R.id.btn_answer_6);
        btnAnswers[6] = findViewById(R.id.btn_answer_7);
        btnAnswers[7] = findViewById(R.id.btn_answer_8);
        btnAnswers[8] = findViewById(R.id.btn_answer_9);
        btnAnswers[9] = findViewById(R.id.btn_answer_10);
        btnAnswers[10] = findViewById(R.id.btn_answer_11);
        btnAnswers[11] = findViewById(R.id.btn_answer_12);
        btnAnswers[12] = findViewById(R.id.btn_answer_13);
        btnAnswers[13] = findViewById(R.id.btn_answer_14);
        btnAnswers[14] = findViewById(R.id.btn_answer_15);
        btnAnswers[15] = findViewById(R.id.btn_answer_16);
    }

    private void loadQuestion() {
        index++;
        Question question = QuestionsCollection.QUESTIONS[index];
        imQuestion.setImageResource(question.getImage());
        for (int i = 0; i < 16; i++) {
            int visibility = question.getAnswer().length() > i ? View.VISIBLE : View.GONE;
            btnAnswers[i].setVisibility(visibility);
            btnAnswers[i].clear();
            btnQuestions[i].setVisibility(View.VISIBLE);
            btnQuestions[i].setText(question.getQuestion().get(i));
            btnQuestions[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_next) {
            loadQuestion();
            btnNext.setVisibility(View.INVISIBLE);
            return;
        }
        GameButton btn = (GameButton) v;
        for (GameButton b : btnAnswers) {
            if (b.getVisibility() != View.VISIBLE) {
                break;
            }
            if (b.getText().toString().isEmpty()) {
                b.setText(btn);
                break;
            }
        }
        for (GameButton b : btnAnswers) {
            if (b.getVisibility() == View.VISIBLE && b.getText().toString().isEmpty()) {
                return;
            }
        }
        checkResult();
    }

    private void checkResult() {
        String result = "";
        for (GameButton b : btnAnswers) {
            if (b.getText().toString().isEmpty()) {
                break;
            }
            result += b.getText().toString();
        }
        boolean isCorrect = QuestionsCollection.QUESTIONS[index].getAnswer().equalsIgnoreCase(result);
        for (GameButton b : btnAnswers) {
            b.showResult(isCorrect);
        }
        if (isCorrect) {
            MediaPlayer.create(this, R.raw.correct).start();
            score += 100;
            tvScore.setText(score + "");
        } else {
            MediaPlayer.create(this, R.raw.incorrect).start();
            if (heart == 0) {
                AlertDialog dialog = new AlertDialog.Builder(this).create();
                dialog.setMessage("Game over");
                dialog.show();
                return;
            }
            heart--;
            tvHeart.setText(heart + "");
        }
        btnNext.setVisibility(View.VISIBLE);
    }
}
