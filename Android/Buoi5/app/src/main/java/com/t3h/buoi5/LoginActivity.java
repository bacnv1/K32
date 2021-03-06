package com.t3h.buoi5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int REQUEST_REGISTER = 1;
    private EditText edtUserName;
    private EditText edtPassword;
    private Button btnLogin;
    private Button btnRegister;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }

    private void initViews() {
        edtUserName = findViewById(R.id.edt_user_name);
        edtPassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                String userName = edtUserName.getText().toString();
                String password = edtPassword.getText().toString();
                if (userName.isEmpty() || password.isEmpty()) {
                    Toast.makeText(this, "User name and password is empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intentMain = new Intent(this, MainActivity.class);
                intentMain.putExtra(RegisterActivity.EXTRA_USER_NAME, userName);
                intentMain.putExtra(RegisterActivity.EXTRA_PASSWORD, password);
                startActivity(intentMain);
                finish();
                break;
            case R.id.btn_register:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivityForResult(intent, REQUEST_REGISTER);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_REGISTER) {
            if (resultCode == RESULT_OK) {
                String userName = data.getStringExtra(RegisterActivity.EXTRA_USER_NAME);
                String password = data.getStringExtra(RegisterActivity.EXTRA_PASSWORD);
                edtPassword.setText(password);
                edtUserName.setText(userName);
            } else {
                Toast.makeText(this, "Register cancelled", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
