package com.bitfit.bitfitpart1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bitfit.bitfitpart1.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private val entries : MutableList<FoodEntity> = mutableListOf()
    private lateinit var foodDao : FoodDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        foodDao = (application as FoodApplication).db.foodDao()
        val rvFood = findViewById<RecyclerView>(R.id.rvFood)
        val addFood = findViewById<Button>(R.id.btnAdd)
        val foodAdapter = FoodAdapter(entries)

        rvFood.adapter = foodAdapter
        rvFood.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false).also {
            val dividerItemDecoration = DividerItemDecoration(this, it.orientation)
            rvFood.addItemDecoration(dividerItemDecoration)
        }

        addFood.setOnClickListener {
            val intent = Intent(this, AddFoodActivity::class.java)
            startActivity(intent)
        }

        lifecycleScope.launch (Dispatchers.IO){
            foodDao.getAll().collect{ foodList ->
                entries.clear()
                entries.addAll(foodList)
                withContext(Dispatchers.Main){
                    foodAdapter.notifyDataSetChanged()
                }
            }
        }
    }
}