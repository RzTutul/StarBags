package com.example.starbagsall.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.starbagsall.dao.StarBagDao;
import com.example.starbagsall.entites.DataPojo;

@Database(entities = {DataPojo.class},version = 1,exportSchema = false)
public abstract class StarDatabase extends RoomDatabase {
    public abstract StarBagDao getStarBagDao();
    public static StarDatabase db;


    public static StarDatabase getInstance(Context context)
    {
        if (db == null) {
            db = Room.databaseBuilder(context, StarDatabase.class, "StarBag_DB").allowMainThreadQueries().build();

            return db;
        }
        return db;
    }

}
