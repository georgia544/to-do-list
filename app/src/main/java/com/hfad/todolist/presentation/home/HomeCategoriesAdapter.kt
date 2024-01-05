package com.hfad.todolist.presentation.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.hfad.todolist.R

class HomeCategoriesAdapter(private val categories: Array<HomeCategoryItem>) :
    RecyclerView.Adapter<HomeCategoriesAdapter.HomeCategoryViewHolder>() {


    class HomeCategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val categoriesButton: Button

        init {
            categoriesButton = view.findViewById(R.id.categories_button)
        }
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): HomeCategoryViewHolder {

        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_home_categories, viewGroup, false)

        return HomeCategoryViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: HomeCategoryViewHolder, position: Int) {
        viewHolder.categoriesButton.text = categories[position].name
    }
    override fun getItemCount() = categories.size

}