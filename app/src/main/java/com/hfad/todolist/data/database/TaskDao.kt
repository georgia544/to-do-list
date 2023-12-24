package com.hfad.todolist.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.hfad.todolist.data.database.model.DatabaseTask
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Upsert
    suspend fun upsertTask(databaseTask: DatabaseTask){}

    @Delete
    suspend fun deleteTask(databaseTask: DatabaseTask)

    @Query("SELECT * FROM databasetask ORDER BY name ASC")
    fun getTasksOrderedByName(): Flow<List<DatabaseTask>>
    @Query("SELECT * FROM databasetask ORDER BY date ASC")
    fun getTasksOrderedByDate(): Flow<List<DatabaseTask>>
    @Query("SELECT * FROM databasetask ORDER BY id ASC")
    fun getTasksOrderedById(): Flow<List<DatabaseTask>>


}