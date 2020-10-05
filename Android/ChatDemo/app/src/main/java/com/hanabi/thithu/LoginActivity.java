package com.hanabi.thithu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hanabi.thithu.api.ApiBuilder;
import com.hanabi.thithu.models.User;
import com.hanabi.thithu.utils.DialogUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity implements View.OnClickListener, Callback<User> {

    public static final int REQUEST_CODE_LOGIN = 1;

    private EditText edtUsername, edtPassword;
    private Button btnLogin, btnRes;
    private AlertDialog dialog;

    public LoginActivity() {
        super("LoginActivity");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }

    private void initViews() {
        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);
        btnRes = findViewById(R.id.btn_res);

        btnLogin.setOnClickListener(this);
        btnRes.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    showAlertDialog();
                    break;
                }
                DialogUtils.show(this);
                ApiBuilder.getInstance().login(username, password)
                        .enqueue(this);
                break;
            case R.id.btn_ok:
                dialog.dismiss();
            case R.id.btn_res:
                changeRes();
                break;
            case R.id.btn_cancel:
                dialog.dismiss();
                break;
        }
    }

    private void changeRes() {
        Intent intent = new Intent(this, ReginsterActivity.class);
        startActivityForResult(intent, REQUEST_CODE_LOGIN);
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        View view = getLayoutInflater().inflate(R.layout.alert_login, null);
        Button btnOk = view.findViewById(R.id.btn_ok);
        Button btnCancel = view.findViewById(R.id.btn_cancel);
        btnOk.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        builder.setView(view);

        dialog = builder.create();
        dialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_LOGIN) {
            if (resultCode == Activity.RESULT_OK) {
                edtUsername.setText(data.getStringExtra(ReginsterActivity.EXTRA_USERNAME));
                edtPassword.setText(data.getStringExtra(ReginsterActivity.EXTRA_PASSWORD));
            }
        }
    }

    @Override
    public void onResponse(Call<User> call, Response<User> response) {
        DialogUtils.dismiss();
        User user = response.body();
        Intent intent = new Intent(this, ListMessenga.class);
        intent.putExtra(User.class.getName(), user);
        startActivity(intent);
        finish();
    }

    @Override
    public void onFailure(Call<User> call, Throwable t) {
        DialogUtils.dismiss();
        Toast.makeText(this, t.getMessage(),
                Toast.LENGTH_SHORT).show();
    }
}