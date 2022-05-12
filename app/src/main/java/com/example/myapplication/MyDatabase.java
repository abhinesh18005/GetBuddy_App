package com.example.myapplication;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.myapplication.firebase_keys;

@Database(entities = {firebase_keys.class}, version = 4)
public abstract class MyDatabase extends RoomDatabase {

    public abstract MyDAO myDAO();
    public static MyDatabase myDatabase;

    public static MyDatabase getInstance(Context context){
        if(myDatabase == null){
            myDatabase = Room.databaseBuilder(context.getApplicationContext(), MyDatabase.class, "key_database").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        }
        return myDatabase;
    }
}
