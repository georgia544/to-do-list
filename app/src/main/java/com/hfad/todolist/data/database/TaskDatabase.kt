package com.hfad.todolist.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hfad.todolist.data.database.TaskDao
import com.hfad.todolist.data.database.model.DatabaseTask

@Database(
    entities = [DatabaseTask::class],
    version = 1
)
abstract class TaskDatabase:RoomDatabase() {
    abstract val dao: TaskDao
}