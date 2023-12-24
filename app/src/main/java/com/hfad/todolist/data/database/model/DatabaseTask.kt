package com.hfad.todolist.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DatabaseTask(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val name: String,
    val date: Long,
    val categoryId: Long,
    val isDone: Boolean
)
