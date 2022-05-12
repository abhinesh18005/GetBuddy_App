package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MyDAO {

    @Insert
    void insert_key(firebase_keys keys);

    @Query("Select * from firebase")
    List<firebase_keys> getlist_keys();
}
