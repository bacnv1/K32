package com.t3h.mp3player;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SongAdapter.SongItemListener {

    private SystemData data;
    private ArrayList<Song> arr;
    private RecyclerView rcSong;
    private SongAdapter adapter;
    private SongPlayer player;

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

    private void initViews() {
        data = new SystemData(this);
        arr = data.getData();
        player = new SongPlayer(arr, this);
        rcSong = findViewById(R.id.rc_song);
        adapter = new SongAdapter(getLayoutInflater());
        rcSong.setAdapter(adapter);
        adapter.setData(arr);
        adapter.setListener(this);
    }

    @Override
    public void onItemClicked(int position) {
        player.create(position);
    }
}