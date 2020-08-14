package com.t3h.buoi4;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = "MainActivity";
    private EditText edtNumberOne;
    private EditText edtNumberTwo;
    private Button btnSum;
    private TextView tvSum;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "onCreate");
        initViews();
    }

    private void initViews() {
        edtNumberOne = findViewById(R.id.edt_number_1);
        edtNumberTwo = findViewById(R.id.edt_number_2);
        btnSum = findViewById(R.id.btn_sum);
        tvSum = findViewById(R.id.tv_sum);
        btnSum.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }

    @Override
    public void onClick(View v) {
        String number1 = edtNumberOne.getText().toString();
        String number2 = edtNumberTwo.getText().toString();
        if (number1.isEmpty() || number2.isEmpty()) {
            Toast.makeText(this, "Please input",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        int sum = Integer.parseInt(number1) + Integer.parseInt(number2);
        tvSum.setText(sum + "");
    }
}
