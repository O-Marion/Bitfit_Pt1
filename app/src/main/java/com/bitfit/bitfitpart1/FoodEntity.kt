package com.bitfit.bitfitpart1

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "FoodTable")
data class FoodEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "Food")val name : String?,
    @ColumnInfo(name = "Calories")val calories: String?
)