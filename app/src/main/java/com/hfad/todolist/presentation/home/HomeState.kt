package com.hfad.todolist.presentation.home

import com.hfad.todolist.domain.model.Category
import com.hfad.todolist.domain.model.Task

data class HomeState(
    val categories: List<Category>,
    val currentCategoryIndex: Int,
    val tasks: List<Task>
)
