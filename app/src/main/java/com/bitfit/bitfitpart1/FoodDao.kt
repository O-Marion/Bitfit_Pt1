package com.bitfit.bitfitpart1

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface FoodDao {
    @Query("SELECT * FROM FoodTable")
    fun getAll(): Flow<List<FoodEntity>>

    @Insert
    fun insert(food: FoodEntity)


    @Query("DELETE FROM FoodTable")
    fun deleteAll()
}