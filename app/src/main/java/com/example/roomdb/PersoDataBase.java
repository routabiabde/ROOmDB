package com.example.roomdb;

import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.roomdb.dao.PersoDoa;
import com.example.roomdb.entity.Perso;

import java.util.List;

@Database(entities = {Perso.class},version = 1 ,exportSchema = false)
public abstract class PersoDataBase extends RoomDatabase {


    public   abstract PersoDoa persoDoa();
    public  static  PersoDataBase instance;
    List<String> stringList;
    public static synchronized PersoDataBase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    PersoDataBase.class,"Perso")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;

    }
  
}
