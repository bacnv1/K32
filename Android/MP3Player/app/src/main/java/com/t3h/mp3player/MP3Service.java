package com.t3h.mp3player;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.widget.RemoteViews;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import java.util.ArrayList;

public class MP3Service extends Service {

    private SongPlayer player;
    private ArrayList<Song> data;
    private SystemData systemData;
    private RemoteViews remoteViews;

    private final String ACTION_NEXT = "action.next";
    private final String ACTION_PREV = "action.prev";
    private final String ACTION_PLAY = "action.play";
    private final String ACTION_EXIT = "action.exit";

    @Override
    public void onCreate() {
        super.onCreate();
        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION_EXIT);
        filter.addAction(ACTION_NEXT);
        filter.addAction(ACTION_PREV);
        filter.addAction(ACTION_PLAY);
        registerReceiver(receiver, filter);

        systemData = new SystemData(this);
        data = systemData.getData();
        player = new SongPlayer(data, this) {
            @Override
            public void start() {
                super.start();
                pushNoti();
            }

            @Override
            public void pause() {
                super.pause();
                pushNoti();
            }
        };
        remoteViews = new RemoteViews(getPackageName(), R.layout.noti_mp3);
        setAction(ACTION_PLAY, R.id.im_play);
        setAction(ACTION_EXIT, R.id.im_exit);
        setAction(ACTION_NEXT, R.id.im_next);
        setAction(ACTION_PREV, R.id.im_prev);
    }

    private void setAction(String action, int id) {
        Intent intent = new Intent(action);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this, 0, intent, 0);
        remoteViews.setOnClickPendingIntent(id, pendingIntent);
    }

    private void pushNoti() {
        String channel = "MP3Channel";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            NotificationChannel c = new NotificationChannel(
                    channel, channel, NotificationManager.IMPORTANCE_LOW
            );
            manager.createNotificationChannel(c);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(
                this, channel
        );
        Song s = data.get(player.getIndex());
        remoteViews.setTextViewText(R.id.tv_title, s.getTitle());
        if (player.isPlaying()) {
            remoteViews.setImageViewResource(R.id.im_play, R.drawable.ic_pause);
        } else {
            remoteViews.setImageViewResource(R.id.im_play, R.drawable.ic_play);
        }

        builder.setContent(remoteViews);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        startForeground(1212, builder.build());
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MP3Binder(this);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.release();
        unregisterReceiver(receiver);
    }

    public SongPlayer getPlayer() {
        return player;
    }

    public ArrayList<Song> getData() {
        return data;
    }

    public class MP3Binder extends Binder {
        private MP3Service service;

        public MP3Binder(MP3Service service) {
            this.service = service;
        }

        public MP3Service getService() {
            return service;
        }
    }

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()) {
                case ACTION_NEXT:
                    player.change(1);
                    break;
                case ACTION_PREV:
                    player.change(-1);
                    break;
                case ACTION_PLAY:
                    if (player.isPlaying()) {
                        player.pause();
                    } else {
                        player.start();
                    }
                    break;
                case ACTION_EXIT:
                    player.release();
                    stopForeground(true);
                    break;
            }
        }
    };
}
