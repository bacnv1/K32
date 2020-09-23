package com.t3h.buoi14;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;

public class MainActivity extends AppCompatActivity implements FileAdapter.FileItemListener, View.OnClickListener, FileManager.FileDownloadCallback {

    private RecyclerView rcFile;
    private FileAdapter adapter;
    private FileManager manager = new FileManager();

    private EditText edtDownload;
    private Button btnDownload;

    private final String[] PERMISSIONS = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    private final String ROOT = Environment.getExternalStorageDirectory()
            .getPath();
    private String currentPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        if (checkPermission(PERMISSIONS, true)) {
            loadFile(ROOT);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (checkPermission(PERMISSIONS, false)) {
            loadFile(ROOT);
        }
    }

    private boolean checkPermission(String[] permissions, boolean withRequest) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (String p : permissions) {
                if (checkSelfPermission(p) != PackageManager.PERMISSION_GRANTED) {
                    if (withRequest) {
                        requestPermissions(permissions, 0);
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private void loadFile(String path) {
        currentPath = path;
        adapter.setData(manager.getFiles(path));
    }

    private void initViews() {
        rcFile = findViewById(R.id.rc_file);
        adapter = new FileAdapter(getLayoutInflater());
        adapter.setListener(this);
        rcFile.setAdapter(adapter);

        edtDownload = findViewById(R.id.edt_download);
        btnDownload = findViewById(R.id.btn_download);
        btnDownload.setOnClickListener(this);
    }

    @Override
    public void onDirectoryClicked(File f) {
        loadFile(f.getPath());
    }

    @Override
    public void onFileClicked(File f) {

    }

    @Override
    public void onBackPressed() {
        if (currentPath.equals(ROOT)) {
            super.onBackPressed();
        } else {
            File f = new File(currentPath);
            String parent = f.getParent();
            loadFile(parent);
        }
    }

    @Override
    public void onClick(View v) {
        String link = edtDownload.getText().toString();
        String type = ".jpg";
        manager.download(link, type, this);
    }

    @Override
    public void onSuccess(String path) {
    }

    @Override
    public void onFail(Exception ex) {

    }
}