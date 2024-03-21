package com.hotel.stocksystem;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProductDuo {
@Query("SELECT * FROM Productitem ORDER BY soldAt desc")
List<Productitem> getAll();
@Query("SELECT * FROM Productitem")
LiveData<List<Productitem>> LiveGetAll();
@Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertorreplace(Productitem productitems);
@Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertorreplaceAll(List<Productitem> productitems);
@Delete
void delete(Productitem items);
@Update
    void update(Productitem items);
@Query("DELETE FROM Productitem")
    void deleteAll();
}
