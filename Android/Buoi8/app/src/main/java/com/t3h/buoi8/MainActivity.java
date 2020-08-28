package com.t3h.buoi8;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FaceAdapter.FaceItemListener {

    private RecyclerView rcFace;
    private FaceAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initData();
    }

    private void initData() {
        ArrayList<Face> data = new ArrayList<>();
        data.add(new Face(R.drawable.beauty, "Beauty"));
        data.add(new Face(R.drawable.cry, "Cry"));
        data.add(new Face(R.drawable.what, "What"));
        data.add(new Face(R.drawable.sweet_kiss, "Kiss"));
        data.add(new Face(R.drawable.too_sad, "Sad"));
        data.add(new Face(R.drawable.beauty, "Beauty"));
        data.add(new Face(R.drawable.cry, "Cry"));
        data.add(new Face(R.drawable.what, "What"));
        data.add(new Face(R.drawable.sweet_kiss, "Kiss"));
        data.add(new Face(R.drawable.too_sad, "Sad"));
        data.add(new Face(R.drawable.beauty, "Beauty"));
        data.add(new Face(R.drawable.cry, "Cry"));
        data.add(new Face(R.drawable.what, "What"));
        data.add(new Face(R.drawable.sweet_kiss, "Kiss"));
        data.add(new Face(R.drawable.too_sad, "Sad"));
        data.add(new Face(R.drawable.beauty, "Beauty"));
        data.add(new Face(R.drawable.cry, "Cry"));
        data.add(new Face(R.drawable.what, "What"));
        data.add(new Face(R.drawable.sweet_kiss, "Kiss"));
        data.add(new Face(R.drawable.too_sad, "Sad"));
        adapter.setData(data);
    }

    private void initViews() {
        rcFace = findViewById(R.id.rc_face);
        adapter = new FaceAdapter(getLayoutInflater());
        adapter.setListener(this);
        rcFace.setAdapter(adapter);
    }

    @Override
    public void onFaceItemClicked(Face face) {
        for (Face f : adapter.getData()) {
            f.setSelected(false);
        }
        face.setSelected(true);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFaceItemLongClicked(final Face face) {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Ban co muon huy lua chon")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        adapter.getData().remove(face);
                        adapter.notifyDataSetChanged();
                    }
                }).setNegativeButton("Khong", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                })
                .setIcon(R.drawable.ic_baseline_device_unknown_24)
                .setMessage("Ban co thuc su muon xoa lua chon")
                .create();
        alertDialog.show();
    }
}