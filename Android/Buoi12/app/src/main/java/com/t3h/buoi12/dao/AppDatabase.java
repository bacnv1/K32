package com.t3h.buoi12.dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.t3h.buoi12.models.Student;

@Database(entities = {Student.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase appDatabase;

    public static AppDatabase getInstance(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(
                    context,
                    AppDatabase.class,
                    "db.student"
            )
                    .allowMainThreadQueries()
                    .build();
        }
        return appDatabase;
    }

    public abstract AppDao getAppDao();
}
