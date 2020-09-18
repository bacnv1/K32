package com.t3h.buoi12.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.t3h.buoi12.models.Student;

import java.util.List;

@Dao
public interface AppDao {
    @Insert
    void insert(Student... students);

    @Update
    void update(Student... students);

    @Delete
    void delete(Student... students);

    @Query("SELECT * FROM Student")
    List<Student> get();
}
