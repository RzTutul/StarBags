package com.example.starbagsall.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.starbagsall.entites.DataPojo;
@Dao
public interface StarBagDao {

    @Insert
    long InsertValue(DataPojo dataPojo);

    @Update
    int updateValue(DataPojo dataPojo);

    @Query("Select * from starbagdata where id like:id")
    DataPojo getAllData(int id);
}

