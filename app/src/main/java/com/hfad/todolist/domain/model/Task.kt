package com.hfad.todolist.domain.model

data class Task(
    val id: Long,
    val name: String,
    val date: Long,
    val categoryId: Long,
    val isDone: Boolean
)