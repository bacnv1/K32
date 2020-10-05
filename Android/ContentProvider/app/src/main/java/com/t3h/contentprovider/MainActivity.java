package com.t3h.contentprovider;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.t3h.contentprovider.adapter.SongAdapter;
import com.t3h.contentprovider.model.Song;
import com.t3h.contentprovider.utils.SystemData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MediaController mediaController;
    private ArrayList<Song> songs;

    private String[] permissions = {
            Manifest.permission.READ_EXTERNAL_STORAGE
    };
    private boolean isPlaying;
    private RecyclerView rvSongs;
    private ImageView btnNext, btnPrev, btnPlay;
    private TextView tvTitle;
    private SeekBar seekBar;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvSongs = findViewById(R.id.rv_songs);
        btnNext = findViewById(R.id.btn_next);
        btnPlay = findViewById(R.id.btn_play);
        btnPrev = findViewById(R.id.btn_prev);
        seekBar = findViewById(R.id.sb_time);
        tvTitle = findViewById(R.id.tv_title);

        btnPrev.setOnClickListener(this);
        btnPlay.setOnClickListener(this);
        btnNext.setOnClickListener(this);

        if (checkPermission()) {
            init();
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(permissions, 0);
            }
        }
    }

    private boolean checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (String p : permissions) {
                if (checkSelfPermission(p)
                        == PackageManager.PERMISSION_DENIED) {
                    return false;
                }
            }
        }
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onRequestPermissionsResult(
            int requestCode,
            @NonNull String[] permissions,
            @NonNull int[] grantResults
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (checkPermission()) {
            init();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void init() {
        //setup recyclerview
        SongAdapter songAdapter = new SongAdapter(getLayoutInflater());
        rvSongs.setAdapter(songAdapter);

        //get data from content provider
        SystemData systemData = new SystemData(this);
        songs = systemData.getDataFromContentProvider();

        //set data to adapter
        songAdapter.setData(songs);

        mediaController = new MediaController(songs, this) {
            @Override
            public void create(int index) {
                super.create(index);
                tvTitle.setText(songs.get(index).getTitle());
            }

            @Override
            public void start() {
                super.start();
                isPlaying = true;
            }

            @Override
            public void pause() {
                super.pause();
                isPlaying = false;
            }
        };
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_prev:
                mediaController.change(-1);
                break;
            case R.id.btn_play:
                if (isPlaying) {
                    btnPlay.setImageResource(
                            R.drawable.ic_baseline_play_circle_filled_24);
                    mediaController.pause();
                } else {
                    btnPlay.setImageResource(
                            R.drawable.ic_baseline_pause_circle_filled_24);
                    mediaController.start();
                }
                break;
            case R.id.btn_next:
                mediaController.change(1);
                break;
        }
    }
}