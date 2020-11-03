package com.t3h.mp3player;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SongAdapter.SongItemListener {

    private RecyclerView rcSong;
    private SongAdapter adapter;
    private MP3Service service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (checkPermission(new String[] {
                Manifest.permission.READ_EXTERNAL_STORAGE
        }, true)) {
            initViews();
        }
    }

    private boolean checkPermission(String[] permissions, boolean request) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (String p : permissions){
                if (checkSelfPermission(p) != PackageManager.PERMISSION_GRANTED) {
                    if (request) {
                        requestPermissions(permissions, 0);
                    }
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (checkPermission(permissions, false)) {
            initViews();
        }
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MP3Service.MP3Binder binder = (MP3Service.MP3Binder) iBinder;
            service = binder.getService();
            adapter.setData(service.getData());
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    private void initViews() {
        rcSong = findViewById(R.id.rc_song);
        adapter = new SongAdapter(getLayoutInflater());
        rcSong.setAdapter(adapter);
        adapter.setListener(this);

        Intent intent = new Intent(this, MP3Service.class);
        startService(intent);
        bindService(intent, connection, BIND_AUTO_CREATE);
    }

    @Override
    public void onItemClicked(int position) {
        service.getPlayer().create(position);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }
}