package com.t3h.buoi7.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Question {
    private int image;
    private String answer;
    private ArrayList<String> question;
    private Random rd = new Random();
    public Question(int image, String answer) {
        this.image = image;
        this.answer = answer;
        genQuestion();
    }

    private void genQuestion() {
        String question = answer;
        for (int i = question.length(); i < 16; i++) {
            question += (char) (rd.nextInt(26) + 65);
        }
        this.question = new ArrayList<>();
        for (char c: question.toCharArray()) {
            this.question.add((c + "").toUpperCase());
        }
        Collections.shuffle(this.question);

    }

    public int getImage() {
        return image;
    }

    public String getAnswer() {
        return answer;
    }

    public ArrayList<String> getQuestion() {
        return question;
    }
}
