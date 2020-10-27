package com.t3h.mp3player;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.provider.Telephony;
import android.util.Log;

import java.util.ArrayList;

public class SystemData {
    private ContentResolver resolver;

    public SystemData(Context context) {
        resolver = context.getContentResolver();
    }

    public ArrayList<Song> getData() {
        ArrayList<Song> arr = new ArrayList<>();
        //Telephony.Sms.CONTENT_URI
        // ContactsContract.Contacts.CONTENT_URI
        // CallLog.CONTENT_URI
        // MediaStore.Audio.Media.INTERNAL_CONTENT_URI
        // MediaStore.Video.Media.EXTERNAL_CONTENT_URI
        // MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        Cursor cursor = resolver.query(
           MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
           null,
           null,
           null,
           null
        );
        cursor.moveToNext();
        int indexData = cursor.getColumnIndex(MediaStore.MediaColumns.DATA);
        int indexTitle = cursor.getColumnIndex(MediaStore.MediaColumns.TITLE);
        int indexAlbum = cursor.getColumnIndex(MediaStore.MediaColumns.ALBUM);
        int indexArtist = cursor.getColumnIndex(MediaStore.MediaColumns.ARTIST);
        int indexDuration = cursor.getColumnIndex(MediaStore.MediaColumns.DURATION);
        int indexSize = cursor.getColumnIndex(MediaStore.MediaColumns.SIZE);
        while (cursor.isAfterLast() == false) {
//            for (int i = 0; i < cursor.getColumnCount(); i++) {
//                Log.e(cursor.getColumnName(i), cursor.getString(i) + "");
//            }
//            Log.e("=============", "=================");
            String data = cursor.getString(indexData);
            String title = cursor.getString(indexTitle);
            String album = cursor.getString(indexAlbum);
            String artist = cursor.getString(indexArtist);
            int duration = cursor.getInt(indexDuration);
            int size = cursor.getInt(indexSize);
            Song s = new Song(data, title, artist, album, duration, size);
            arr.add(s);
            cursor.moveToNext();
        }
        return arr;
    }
}
