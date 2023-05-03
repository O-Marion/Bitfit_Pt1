package com.bitfit.bitfitpart1

import android.app.Application

class FoodApplication : Application(){
    val db by lazy { AppDatabase.getInstance(this) }
}