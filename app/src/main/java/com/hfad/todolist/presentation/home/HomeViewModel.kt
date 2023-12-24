package com.hfad.todolist.presentation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hfad.todolist.domain.model.Category
import com.hfad.todolist.domain.model.Task

class HomeViewModel : ViewModel() {

    val homeState = MutableLiveData<HomeState>()


    fun init() {
        val homeState: HomeState = HomeState(
            categories = listOf(Category(0, "DJ"), Category(1, "fkj")),
            currentCategoryIndex = 0,
            tasks = listOf(Task(0, "dhua", 255622, 2, true))
        )
    }
}
