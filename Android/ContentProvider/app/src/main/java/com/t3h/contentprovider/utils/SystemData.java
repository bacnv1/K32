package com.t3h.contentprovider.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.provider.MediaStore;

import androidx.annotation.RequiresApi;

import com.t3h.contentprovider.model.Song;

import java.util.ArrayList;

public class SystemData {
    private ContentResolver contentResolver;

    public SystemData(Context context) {
        contentResolver = context.getContentResolver();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public ArrayList<Song> getDataFromContentProvider() {
        ArrayList<Song> songs = new ArrayList<>();

        Cursor cursor = contentResolver.query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                null,
                null,
                null
        );

        cursor.moveToFirst();
        //With Image
        //content://media/external/audio/albumart/ + songId
        int indexId = cursor.
                getColumnIndex(MediaStore.Audio.Media.ALBUM_ID);
        int indexData = cursor.
                getColumnIndex(MediaStore.Audio.Media.DATA);
        int indexSize = cursor.getColumnIndex(MediaStore.Audio.Media.SIZE);
        int indexTitle = cursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
        int indexDuration = cursor.getColumnIndex(MediaStore.Audio.Media.DURATION);
        int indexAlbum = cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM);
        int indexArtist = cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);

        while (!cursor.isAfterLast()) {
            String data = cursor.getString(indexData);
            int size = cursor.getInt(indexSize);
            int duration = cursor.getInt(indexDuration);
            String title = cursor.getString(indexTitle);
            String artist = cursor.getString(indexArtist);
            String album = cursor.getString(indexAlbum);
            long id = cursor.getLong(indexId);

            Song song = new Song();
            song.setAlbum(album);
            song.setId(id);
            song.setTitle(title);
            song.setSize(size);
            song.setArtist(artist);
            song.setDuration(duration);
            song.setData(data);

            songs.add(song);
            cursor.moveToNext();

            cursor.close();
        }

        return songs;
    }
}
