package com.t3h.buoi5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = findViewById(R.id.tv_info);
        Intent intent = getIntent();
        String userName = intent.getStringExtra(RegisterActivity.EXTRA_USER_NAME);
        String password = intent.getStringExtra(RegisterActivity.EXTRA_PASSWORD);
        tvInfo.setText(userName + " - " + password);
    }
}
