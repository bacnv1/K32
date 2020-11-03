package com.t3h.mp3player;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

import java.util.ArrayList;

public class SongPlayer implements MediaPlayer.OnCompletionListener {
    private ArrayList<Song> arr;
    private int index = 0;
    private MediaPlayer player;
    private Context context;

    public SongPlayer(ArrayList<Song> arr, Context context) {
        this.arr = arr;
        this.context = context;
    }

    public void create(int index) {
        this.index = index;
        release();
        player = MediaPlayer.create(context, Uri.parse(arr.get(index).getData()));
        start();
        player.setOnCompletionListener(this);
    }

    public void start() {
        if (player != null) {
            player.start();
        }
    }

    public void pause() {
        if (player != null) {
            player.pause();
        }
    }

    public void release() {
        if (player != null) {
            player.release();
        }
    }

    public void seek(int position) {
        if (player != null) {
            player.seekTo(position);
        }
    }

    public void loop(boolean isLooping) {
        if (player != null) {
            player.setLooping(isLooping);
        }
    }

    public int getDuration() {
        return player == null ? 0 : player.getDuration();
    }

    public int getPosition() {
        return player == null ? 0 : player.getCurrentPosition();
    }

    // 1 next
    // -1 prev
    public void change(int value) {
        index += value;
        if (index >= arr.size()) {
            index = 0;
        } else if (index < 0) {
            index = arr.size() - 1;
        }
        create(index);
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        change(1);
    }

    public int getIndex() {
        return index;
    }

    public boolean isPlaying() {
        return player == null ? false : player.isPlaying();
    }
}
