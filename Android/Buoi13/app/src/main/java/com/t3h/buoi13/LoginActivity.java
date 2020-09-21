package com.t3h.buoi13;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.t3h.buoi13.utils.SharedUtils;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtUserName;
    private EditText edtPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        loadData();
    }

    private void loadData() {
        String userName = SharedUtils.getInstance(this)
                .getString(SharedUtils.KEY_USER_NAME);
        String password = SharedUtils.getInstance(this)
                .getString(SharedUtils.KEY_PASSWORD);
        edtUserName.setText(userName);
        edtPassword.setText(password);
    }

    private void initViews() {
        edtUserName = findViewById(R.id.edt_user_name);
        edtPassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String userName = edtUserName.getText().toString();
        String password = edtPassword.getText().toString();
        if (userName.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show();
            return;
        }
        SharedUtils.getInstance(this).putString(
                SharedUtils.KEY_USER_NAME, userName
        );
        SharedUtils.getInstance(this).putString(
                SharedUtils.KEY_PASSWORD, password
        );
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
