package com.example.roomdb.dao;

import android.database.Cursor;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomdb.entity.Perso;

import java.util.List;

@Dao
public interface PersoDoa {
    @Insert
    void insert(Perso p);

    @Delete
    void delet(Perso p);

    @Update
    void updat(Perso p);

    @Query("SELECT * FROM Perso")
    Cursor getData();

    @Query("SELECT * FROM PERSO WHERE age > 18")
    List<Perso> getOLderThen();

}
