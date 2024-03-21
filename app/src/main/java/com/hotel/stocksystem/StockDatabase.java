package com.hotel.stocksystem;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {Productitem.class},version=1)
public  abstract class StockDatabase  extends RoomDatabase {
    public abstract ProductDuo productDuo();
private static volatile StockDatabase INSTANCE;
public static StockDatabase getDatabase(final Context context){
    if(INSTANCE==null){
        synchronized (StockDatabase.class){
            if(INSTANCE==null){
INSTANCE= Room.databaseBuilder(context,
        StockDatabase.class,"database_v14")
        .fallbackToDestructiveMigration()
        .fallbackToDestructiveMigrationOnDowngrade()
        .allowMainThreadQueries()
        .build();
            }
        }
    }
return INSTANCE;
}


}
