package com.hfad.todolist.presentation.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.hfad.todolist.R

class HomeTasksAdapter(private val tasks: Array<HomeTaskItem>) :
    RecyclerView.Adapter<HomeTasksAdapter.HomeTasksViewHolder>() {


    class HomeTasksViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val taskCardView: CardView
        val taskName: TextView
        val taskDate: TextView
        val taskIsDone: CheckBox

        init {
            taskCardView = view.findViewById(R.id.cardView)
            taskName = view.findViewById(R.id.task_name)
            taskDate = view.findViewById(R.id.task_date)
            taskIsDone = view.findViewById(R.id.task_checkbox)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): HomeTasksViewHolder {

        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_home_tasks, viewGroup, false)

        return HomeTasksViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: HomeTasksViewHolder, position: Int) {
        viewHolder.taskName.text = tasks[position].name
        viewHolder.taskDate.text = tasks[position].date.toString()
        viewHolder.taskIsDone.isChecked = tasks[position].isDone

    }

    override fun getItemCount() = tasks.size
}