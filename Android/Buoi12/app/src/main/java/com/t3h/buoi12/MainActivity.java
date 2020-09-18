package com.t3h.buoi12;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.t3h.buoi12.dao.AppDatabase;
import com.t3h.buoi12.models.Student;

public class MainActivity extends AppCompatActivity implements StudentAdapter.StudentItemLister, View.OnClickListener {

    private RecyclerView rcStudent;
    private FloatingActionButton btnAdd;
    private StudentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        loadData();
    }

    private void loadData() {
        adapter.setData(AppDatabase.getInstance(this).getAppDao().get());
    }

    private void initViews() {
        rcStudent = findViewById(R.id.rc_student);
        btnAdd = findViewById(R.id.btn_add);
        adapter = new StudentAdapter(getLayoutInflater());
        adapter.setLister(this);
        rcStudent.setAdapter(adapter);
        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onItemClicked(Student student) {
        Intent intent = StudentActivity.getInstance(this, student);
        startActivityForResult(intent, 0);
    }

    @Override
    public void onItemLongClicked(Student student) {

    }

    @Override
    public void onClick(View v) {
        Intent intent = StudentActivity.getInstance(this, new Student());
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            loadData();
        }
    }
}