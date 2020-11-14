package com.example.mynote

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("DELETE FROM notes_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM notes_table ORDER BY text ASC")
    fun getAllNords(): LiveData<List<Note>>
}