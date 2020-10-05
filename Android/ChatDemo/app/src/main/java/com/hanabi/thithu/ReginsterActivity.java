package com.hanabi.thithu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hanabi.thithu.api.ApiBuilder;
import com.hanabi.thithu.utils.DialogUtils;

import java.util.regex.Pattern;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

public class ReginsterActivity extends BaseActivity implements View.OnClickListener {

    public static final String EXTRA_USERNAME = "extra.USERNAME";
    public static final String EXTRA_PASSWORD = "extra.PASSWORD";
    private EditText edtUsername, edtPassword, edtRePass;
    private Button btnSignIn, btnCancel;

    public ReginsterActivity() {
        super("ReginsterActivity");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reginster);
        initViews();
    }

    private void initViews() {
        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);
        edtRePass = findViewById(R.id.edt_re_password);
        btnCancel = findViewById(R.id.btn_cancel);
        btnSignIn = findViewById(R.id.btn_sign_in);

        btnCancel.setOnClickListener(this);
        btnSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_sign_in:
                Pattern patternMail = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
                Pattern patternUsername = Pattern.compile("[^a-z ]");

                final String username = edtUsername.getText().toString();
                final String password = edtPassword.getText().toString();
                String rePassword = edtRePass.getText().toString();
                if (username.isEmpty()) {
                    edtUsername.setError("Can not empty");
                    break;
                }
                if (patternUsername.matcher(username).matches()) {
                    edtUsername.setError("Wrong format");
                    break;
                }
                if (password.isEmpty()) {
                    edtPassword.setError("Can not empty");
                    break;
                }
                if (rePassword.isEmpty()) {
                    edtRePass.setError("Can not empty");
                    break;
                }
                if (!password.equals(rePassword)) {
                    edtRePass.setError("Re password not equal password");
                    break;
                }
                DialogUtils.show(this);
                ApiBuilder.getInstance().register(username, password, "BacNV")
                        .enqueue(new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                                DialogUtils.dismiss();
                                changeLogin(username, password);
                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                                DialogUtils.dismiss();
                                Toast.makeText(ReginsterActivity.this,
                                        throwable.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        });
                break;
            case R.id.btn_cancel:
                finish();
                break;
        }
    }

    private void changeLogin(String username, String password) {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra(EXTRA_USERNAME, username);
        intent.putExtra(EXTRA_PASSWORD, password);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}