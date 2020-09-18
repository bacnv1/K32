package com.t3h.buoi12;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.t3h.buoi12.dao.AppDatabase;
import com.t3h.buoi12.models.Student;

public class StudentActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtName;
    private EditText edtSubject;
    private EditText edtScore;
    private Button btnOk;

    private Student student;
    private static final String EXTRA_STUDENT = "extra.STUDENT";

    public static Intent getInstance(Context context, Student student) {
        Intent intent = new Intent(context, StudentActivity.class);
        intent.putExtra(EXTRA_STUDENT, student);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        student = (Student) getIntent().getSerializableExtra(EXTRA_STUDENT);
        initViews();
        showData();
    }

    private void showData() {
        edtName.setText(student.getName());
        edtSubject.setText(student.getSubject());
        edtScore.setText(student.getScore() + "");
    }

    private void initViews() {
        edtName = findViewById(R.id.edt_name);
        edtSubject = findViewById(R.id.edt_subject);
        edtScore = findViewById(R.id.edt_score);
        btnOk = findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name = edtName.getText().toString();
        String subject = edtSubject.getText().toString();
        String score = edtScore.getText().toString();
        if (name.isEmpty() || subject.isEmpty() || score.isEmpty()) {
            Toast.makeText(this, "Data empty", Toast.LENGTH_SHORT).show();
            return;
        }
        student.setName(name);
        student.setScore(Float.parseFloat(score));
        student.setSubject(subject);
        if (student.getId() == 0) {
            AppDatabase.getInstance(this).getAppDao().insert(student);
        } else {
            AppDatabase.getInstance(this).getAppDao().update(student);
        }
        setResult(RESULT_OK);
        finish();
    }
}
