package com.t3h.baitap;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvName;
    private Random rd = new Random();
    private int sum;
    private int time = 5;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        initViews();

    }

    private void initViews() {
        tvName = findViewById(R.id.tv_name);
        initButton(R.id.btn_box1);
        initButton(R.id.btn_box2);
        initButton(R.id.btn_box3);
        initButton(R.id.btn_box4);
        initButton(R.id.btn_box5);
        initButton(R.id.btn_box6);
        initButton(R.id.btn_box7);
        initButton(R.id.btn_box8);
        initButton(R.id.btn_box9);
    }

    private void initButton(int id) {
        Button btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        time--;
        if (time < 0) {
            return;
        }
        int number = rd.nextInt(15);
        sum += number;
        Button btn = (Button) v;
        btn.setText(number + "");
        btn.setEnabled(false);
        btn.setBackgroundColor(Color.GRAY);
        if (time == 0) {
            if (sum < 50) {
                Toast.makeText(this, "Lose", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Win", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onBackPressed() {
        if (time <= 0) {
            super.onBackPressed();
        } else {
            Toast.makeText(this, "Cannot exit", Toast.LENGTH_SHORT).show();
        }
    }
}
