package com.bitfit.bitfitpart1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bitfit.bitfitpart1.R

class FoodAdapter(private val list: MutableList<FoodEntity>): RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val foodEntity = list[position]
        holder.bind(foodEntity)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        private val foodEntry = itemView.findViewById<TextView>(R.id.tvFoodEntry)
        private val calorieEntry = itemView.findViewById<TextView>(R.id.tvCalorieEntry)

        fun bind(foodEntity: FoodEntity){
            foodEntry.text = foodEntity.name
            calorieEntry.text = "${foodEntity.calories}\ncalories"
        }

    }
}